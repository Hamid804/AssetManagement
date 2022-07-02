package com.example.controller;

import java.util.Set;

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

import com.example.model.Asset;
import com.example.model.Category;
import com.example.model.Employee;
import com.example.service.AssetService;

@RestController
@RequestMapping("/asset")
@CrossOrigin("*")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	
	// add asset
	@PostMapping("/")
	public ResponseEntity<Asset> addAsset(@RequestBody Asset asset) {
		
		Asset asset2 = this.assetService.addAsset(asset);
		
		return ResponseEntity.ok(asset2);
	}
	
	
	// update asset
	@PutMapping("/")
	public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset) {
		return ResponseEntity.ok(this.assetService.updateAsset(asset));
	}
	
	
	// get text-searched assets
	@GetMapping("/searched/{searchText}")
	public Set<Asset> getSearchedAssets(@PathVariable("searchText") String searchText) {
		return this.assetService.getSearchedAssets(searchText);
	}
	
	
	// get asset by id
	@GetMapping("/{aId}")
	public ResponseEntity<Asset> getAsset(@PathVariable("aId") int aId) {
		return ResponseEntity.ok(this.assetService.getAsset(aId));
	}
	
	
	// get all assigned assets to a employee
	@GetMapping("/employee/{eId}")
	public Set<Asset> getAllAssignedAssets(@PathVariable("eId") int eId) {
		Employee employee = new Employee();
		employee.seteId(eId);
		
		return this.assetService.getAssignedAssets(employee);
	}
	
	
	// get all assets of a category
	@GetMapping("/category/{cId}")
	public Set<Asset> getAllAssetsOfCategory(@PathVariable("cId") int cId) {
		Category category = new Category();
		category.setcId(cId);
		
		return this.assetService.getAssetsOfCategory(category);
	}
	
	
	// delete asset
	@DeleteMapping("/{aId}")
	public void deleteAsset(@PathVariable("aId") int aId) {
		this.assetService.deleteAsset(aId);
	}
}
