package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_Comment;
import com.audit.janalysis.service.OBO_CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class OBO_CommentController {
    @Autowired
    private OBO_CommentService oboCommentService;

    @PostMapping("/")
    public ResponseEntity<String> createComment(@RequestBody OBO_Comment oboComment) {
        int result = oboCommentService.insert(oboComment);
        if (result > 0) {
            return ResponseEntity.ok("Comment created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create comment");
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable int commentId) {
        OBO_Comment comment = oboCommentService.getCommentById(commentId);
        if (comment != null) {
            int result = oboCommentService.delete(comment);
            if (result > 0) {
                return ResponseEntity.ok("Comment deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete comment");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable int commentId, @RequestBody OBO_Comment oboComment) {
        OBO_Comment comment = oboCommentService.getCommentById(commentId);
        if (comment != null) {
            oboComment.setId(commentId);
            int result = oboCommentService.update(oboComment);
            if (result > 0) {
                return ResponseEntity.ok("Comment updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update comment");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<OBO_Comment> getCommentById(@PathVariable int commentId) {
        OBO_Comment comment = oboCommentService.getCommentById(commentId);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<OBO_Comment>> getAllComments() {
        List<OBO_Comment> comments = oboCommentService.getAllComments();
        return ResponseEntity.ok(comments);
    }
}

