package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_Role;
import com.audit.janalysis.service.OBO_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OBO_RoleController {


        @Autowired
        private OBO_RoleService roleService;

        @GetMapping("/getRoleById/{role_id}")
        public ResponseEntity<OBO_Role> getRoleById(@PathVariable("role_id") int role_id) {
            OBO_Role role = roleService.getRoleById(role_id);
            if (role != null) {
                return ResponseEntity.ok(role);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/getAllRoles")
        public ResponseEntity<List<OBO_Role>> getAllRoles() {
            List<OBO_Role> roles = roleService.getAllRole();
            return ResponseEntity.ok(roles);
        }

        @PostMapping("/addRole")
        public ResponseEntity<OBO_Role> addRole(@RequestBody OBO_Role oboRole) {
            int result = roleService.insert(oboRole);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body(oboRole);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @PutMapping("/updateRole/{role_id}")
        public ResponseEntity<OBO_Role> updateRole(@PathVariable("role_id") int role_id, @RequestBody OBO_Role oboRole) {
            OBO_Role existingRole = roleService.getRoleById(role_id);
            if (existingRole != null) {
                oboRole.setId(String.valueOf(role_id));
                int result = roleService.update(oboRole);
                if (result > 0) {
                    return ResponseEntity.ok(oboRole);
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/deleteRole/{role_id}")
        public ResponseEntity<Void> deleteRole(@PathVariable("role_id") int role_id) {
            OBO_Role existingRole = roleService.getRoleById(role_id);
            if (existingRole != null) {
                int result = roleService.delete(existingRole);
                if (result > 0) {
                    return ResponseEntity.noContent().build();
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    }

