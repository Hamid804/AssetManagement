package com.example.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Asset;
import com.example.model.Category;
import com.example.model.Employee;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
	
	Set<Asset> findByAssignedEmp(Employee employee);
	
	
	Set<Asset> findByCategory(Category category);
	
	
	Set<Asset> findByaNameLike(String strPattern);
}
