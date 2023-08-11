package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_Page;
import com.audit.janalysis.service.OBO_PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page")
public class OBO_PageController {
    @Autowired
    private OBO_PageService oboPageService;

    @PostMapping("/")
    public ResponseEntity<String> createPage(@RequestBody OBO_Page oboPage) {
        int result = oboPageService.insert(oboPage);
        if (result > 0) {
            return ResponseEntity.ok("Page created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create page");
        }
    }

    @DeleteMapping("/{pageId}")
    public ResponseEntity<String> deletePage(@PathVariable int pageId) {
        OBO_Page page = oboPageService.getPageById(pageId);
        if (page != null) {
            int result = oboPageService.delete(page);
            if (result > 0) {
                return ResponseEntity.ok("Page deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete page");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{pageId}")
    public ResponseEntity<String> updatePage(@PathVariable int pageId, @RequestBody OBO_Page oboPage) {
        OBO_Page page = oboPageService.getPageById(pageId);
        if (page != null) {
            oboPage.setId(pageId);
            int result = oboPageService.update(oboPage);
            if (result > 0) {
                return ResponseEntity.ok("Page updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update page");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{pageId}")
    public ResponseEntity<OBO_Page> getPageById(@PathVariable int pageId) {
        OBO_Page page = oboPageService.getPageById(pageId);
        if (page != null) {
            return ResponseEntity.ok(page);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<OBO_Page>> getAllPages() {
        List<OBO_Page> pages = oboPageService.getAllPages();
        return ResponseEntity.ok(pages);
    }
}

