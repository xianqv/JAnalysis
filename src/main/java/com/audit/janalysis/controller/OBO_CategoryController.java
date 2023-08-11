package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_Category;
import com.audit.janalysis.service.OBO_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class OBO_CategoryController {
    @Autowired
    private OBO_CategoryService oboCategoryService;

    @PostMapping("/")
    public ResponseEntity<String> createCategory(@RequestBody OBO_Category oboCategory) {
        int result = oboCategoryService.insert(oboCategory);
        if (result > 0) {
            return ResponseEntity.ok("Category created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create category");
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable int categoryId) {
        OBO_Category category = oboCategoryService.getCategoryById(categoryId);
        if (category != null) {
            int result = oboCategoryService.delete(category);
            if (result > 0) {
                return ResponseEntity.ok("Category deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete category");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable int categoryId, @RequestBody OBO_Category oboCategory) {
        OBO_Category category = oboCategoryService.getCategoryById(categoryId);
        if (category != null) {
            oboCategory.setId(categoryId);
            int result = oboCategoryService.update(oboCategory);
            if (result > 0) {
                return ResponseEntity.ok("Category updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update category");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<OBO_Category> getCategoryById(@PathVariable int categoryId) {
        OBO_Category category = oboCategoryService.getCategoryById(categoryId);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<OBO_Category>> getAllCategories() {
        List<OBO_Category> categories = oboCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}

