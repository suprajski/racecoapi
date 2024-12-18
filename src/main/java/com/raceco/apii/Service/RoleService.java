package com.raceco.apii.Service;

import com.raceco.apii.Entity.Role;

import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    List<Role> getAllRoles();
    Role getRoleByName(String roleName);
    void deleteRole(Long roleId);
}
