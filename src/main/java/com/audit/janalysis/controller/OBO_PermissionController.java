package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_Permission;
import com.audit.janalysis.service.OBO_PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OBO_PermissionController {
        @Autowired
        private OBO_PermissionService permissionService;

        @GetMapping("/getPermissions")
        public ResponseEntity<List<OBO_Permission>> getPermissions() {
            List<OBO_Permission> permissions = permissionService.getPermissions();
            return ResponseEntity.ok(permissions);
        }

        @GetMapping("/getPermissionById/{id}")
        public ResponseEntity<OBO_Permission> getPermissionById(@PathVariable("id") Integer id) {
            OBO_Permission permission = permissionService.getPermission(id);
            if (permission != null) {
                return ResponseEntity.ok(permission);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/addPermission")
        public ResponseEntity<OBO_Permission> addPermission(@RequestBody OBO_Permission oboPermission) {
            int result = permissionService.addPermission(oboPermission);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body(oboPermission);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @PutMapping("/updatePermission/{id}")
        public ResponseEntity<OBO_Permission> updatePermission(@PathVariable("id") Integer id, @RequestBody OBO_Permission oboPermission) {
            OBO_Permission existingPermission = permissionService.getPermission(id);
            if (existingPermission != null) {
                oboPermission.setId(id);
                int result = permissionService.updatePermission(oboPermission);
                if (result > 0) {
                    return ResponseEntity.ok(oboPermission);
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/deletePermission/{id}")
        public ResponseEntity<Void> deletePermission(@PathVariable("id") Integer id) {
            int result = permissionService.deletePermission(id);
            if (result > 0) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }



}
