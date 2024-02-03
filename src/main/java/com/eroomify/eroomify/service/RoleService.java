package com.eroomify.eroomify.service;

import com.eroomify.eroomify.entity.Role;
import com.eroomify.eroomify.entity.User;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role createRole(Role theRole);

    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);
    User assignRoleToUser(Long userId, Long roleId);
    Role removeAllUsersFromRole(Long roleId);
}
