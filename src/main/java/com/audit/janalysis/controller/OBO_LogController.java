package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_Log;
import com.audit.janalysis.service.OBO_LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class OBO_LogController {
    @Autowired
    private OBO_LogService oboLogService;

    @PostMapping("/")
    public ResponseEntity<String> createLog(@RequestBody OBO_Log oboLog) {
        int result = oboLogService.insert(oboLog);
        if (result > 0) {
            return ResponseEntity.ok("Log created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create log");
        }
    }

    @DeleteMapping("/{logId}")
    public ResponseEntity<String> deleteLog(@PathVariable int logId) {
        OBO_Log log = oboLogService.getLogById(logId);
        if (log != null) {
            int result = oboLogService.delete(log);
            if (result > 0) {
                return ResponseEntity.ok("Log deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete log");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{logId}")
    public ResponseEntity<String> updateLog(@PathVariable int logId, @RequestBody OBO_Log oboLog) {
        OBO_Log log = oboLogService.getLogById(logId);
        if (log != null) {
            oboLog.setId(logId);
            int result = oboLogService.update(oboLog);
            if (result > 0) {
                return ResponseEntity.ok("Log updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update log");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{logId}")
    public ResponseEntity<OBO_Log> getLogById(@PathVariable int logId) {
        OBO_Log log = oboLogService.getLogById(logId);
        if (log != null) {
            return ResponseEntity.ok(log);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<OBO_Log>> getAllLogs() {
        List<OBO_Log> logs = oboLogService.getAllLogs();
        return ResponseEntity.ok(logs);
    }
}

