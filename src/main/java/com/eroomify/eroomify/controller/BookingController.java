package com.eroomify.eroomify.controller;

import com.eroomify.eroomify.entity.BookedRoom;
import com.eroomify.eroomify.entity.Room;
import com.eroomify.eroomify.exception.InvalidBookingRequestException;
import com.eroomify.eroomify.exception.ResourceNotFoundException;
import com.eroomify.eroomify.response.BookingResponse;
import com.eroomify.eroomify.response.RoomResponse;
import com.eroomify.eroomify.service.BookingService;
import com.eroomify.eroomify.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final RoomService roomService;

    public BookingController(BookingService bookingService,
                             RoomService roomService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
    }

    @GetMapping("/all-bookings")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BookingResponse>> getAllBookings(){
        List<BookedRoom> bookings = bookingService.getAllBookings();
        List<BookingResponse> bookingResponses = new ArrayList<>();
        for (BookedRoom booking : bookings){
            BookingResponse bookingResponse = getBookingResponse(booking);
            bookingResponses.add(bookingResponse);
        }
        return ResponseEntity.ok(bookingResponses);
    }

    @PostMapping("/room/{roomId}/booking")
    public ResponseEntity<Object> saveBooking(@PathVariable Long roomId,
                                         @RequestBody BookedRoom bookingRequest){
        try{
            String confirmationCode = bookingService.saveBooking(roomId, bookingRequest);
            return ResponseEntity.ok(
                    "Room booked successfully, Your booking confirmation code is :"+confirmationCode);

        }catch (InvalidBookingRequestException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/confirmation/{confirmationCode}")
    public ResponseEntity<?> getBookingByConfirmationCode(@PathVariable String confirmationCode){
        try{
            BookedRoom booking = bookingService.findByBookingConfirmationCode(confirmationCode);
            BookingResponse bookingResponse = getBookingResponse(booking);
            return ResponseEntity.ok(bookingResponse);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/user/{email}/bookings")
    public ResponseEntity<List<BookingResponse>> getBookingsByUserEmail(@PathVariable String email) {
        List<BookedRoom> bookings = bookingService.getBookingsByUserEmail(email);
        List<BookingResponse> bookingResponses = new ArrayList<>();
        for (BookedRoom booking : bookings) {
            BookingResponse bookingResponse = getBookingResponse(booking);
            bookingResponses.add(bookingResponse);
        }
        return ResponseEntity.ok(bookingResponses);
    }

    @DeleteMapping("/booking/{bookingId}/delete")
    public void cancelBooking(@PathVariable Long bookingId){
        bookingService.cancelBooking(bookingId);
    }

    private BookingResponse getBookingResponse(BookedRoom booking) {
        Room theRoom = roomService.getRoomById(booking.getRoom().getId()).get();
        RoomResponse room = new RoomResponse(
                theRoom.getId(),
                theRoom.getRoomType(),
                theRoom.getRoomPrice());
        return new BookingResponse(
                booking.getBookingId(), booking.getCheckInDate(),
                booking.getCheckOutDate(),booking.getGuestFullName(),
                booking.getGuestEmail(), booking.getNumOfAdults(),
                booking.getNumOfChildren(), booking.getTotalNumOfGuest(),
                booking.getBookingConfirmationCode(), room);
    }

}
