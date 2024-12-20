package com.raceco.apii.Controller;

import com.raceco.apii.Entity.Role;
import com.raceco.apii.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.addRole(role));
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{roleName}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String roleName) {
        return ResponseEntity.ok(roleService.getRoleByName(roleName));
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }
}
