package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_Tag;
import com.audit.janalysis.service.OBO_TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class OBO_TagController {
    @Autowired
    private OBO_TagService oboTagService;

    @PostMapping("/")
    public ResponseEntity<String> createTag(@RequestBody OBO_Tag oboTag) {
        int result = oboTagService.insert(oboTag);
        if (result > 0) {
            return ResponseEntity.ok("Tag created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create tag");
        }
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<String> deleteTag(@PathVariable int tagId) {
        OBO_Tag tag = oboTagService.getTagById(tagId);
        if (tag != null) {
            int result = oboTagService.delete(tag);
            if (result > 0) {
                return ResponseEntity.ok("Tag deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete tag");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<String> updateTag(@PathVariable int tagId, @RequestBody OBO_Tag oboTag) {
        OBO_Tag tag = oboTagService.getTagById(tagId);
        if (tag != null) {
            oboTag.setId(tagId);
            int result = oboTagService.update(oboTag);
            if (result > 0) {
                return ResponseEntity.ok("Tag updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete updateTag");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<OBO_Tag> getTag(@PathVariable int tagId) {
        OBO_Tag tag = oboTagService.getTagById(tagId);
        if (tag != null) {
            return ResponseEntity.ok(tag);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}