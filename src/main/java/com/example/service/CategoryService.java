package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	// adding new category
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	
	// updating an asset
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	
	// getting a category by id
	public Category getCategory(int cId) {
		return this.categoryRepository.findById(cId).get();
	}
	
	
	// deleting a category
	public void deleteCategory(int cId) {
		this.categoryRepository.deleteById(cId);
	}
}
