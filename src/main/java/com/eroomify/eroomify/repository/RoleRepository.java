package com.eroomify.eroomify.repository;

import com.eroomify.eroomify.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String role);

    boolean existsByName(String role);
}
