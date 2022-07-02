package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	// add category
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		
		Category category2 = this.categoryService.addCategory(category);
		//System.out.println("Reached");
		
		return ResponseEntity.ok(category2);
	}
	
	
	// update category
	@PutMapping("/")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.updateCategory(category));
	}
	
	
	// get category by id
	@GetMapping("/{cId}")
	public ResponseEntity<Category> getCategory(@PathVariable("cId") int cId) {
		return ResponseEntity.ok(this.categoryService.getCategory(cId));
	}
	
	
	// delete category
	@DeleteMapping("/{cId}")
	public void deleteCategory(@PathVariable("cId") int cId) {
		this.categoryService.deleteCategory(cId);
	}

}
