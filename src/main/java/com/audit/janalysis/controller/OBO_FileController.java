package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_File;
import com.audit.janalysis.service.OBO_FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
public class OBO_FileController {
    @Autowired
    private OBO_FileService oboFileService;

    @PostMapping("/")
    public ResponseEntity<String> createFile(@RequestBody OBO_File oboFile) {
        int result = oboFileService.insert(oboFile);
        if (result > 0) {
            return ResponseEntity.ok("File created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create file");
        }
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<String> deleteFile(@PathVariable int fileId) {
        OBO_File file = oboFileService.getFileById(fileId);
        if (file != null) {
            int result = oboFileService.delete(file);
            if (result > 0) {
                return ResponseEntity.ok("File deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete file");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{fileId}")
    public ResponseEntity<String> updateFile(@PathVariable int fileId, @RequestBody OBO_File oboFile) {
        OBO_File file = oboFileService.getFileById(fileId);
        if (file != null) {
            oboFile.setId(fileId);
            int result = oboFileService.update(oboFile);
            if (result > 0) {
                return ResponseEntity.ok("File updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update file");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<OBO_File> getFileById(@PathVariable int fileId) {
        OBO_File file = oboFileService.getFileById(fileId);
        if (file != null) {
            return ResponseEntity.ok(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<OBO_File>> getAllFiles() {
        List<OBO_File> files = oboFileService.getAllFiles();
        return ResponseEntity.ok(files);
    }
}
