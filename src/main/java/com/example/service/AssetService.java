package com.example.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Asset;
import com.example.model.Category;
import com.example.model.Employee;
import com.example.repo.AssetRepository;

@Service
public class AssetService {
	
	@Autowired
	private AssetRepository assetRepository;
	
	// adding new asset
	public Asset addAsset(Asset asset) {
		return this.assetRepository.save(asset);
	}
	
	
	// updating asset
	public Asset updateAsset(Asset asset) {
		return this.assetRepository.save(asset);
	}
	
	
	// getting text-searched based assets
	public Set<Asset> getSearchedAssets(String searchText) {
		String strPattern = "%"+searchText+"%";
		return this.assetRepository.findByaNameLike(strPattern);
	}
	
	
	// getting asset by id
	public Asset getAsset(int aId) {
		return this.assetRepository.findById(aId).get();
	}
	
	
	// getting all assigned assets of an employee
	public Set<Asset> getAssignedAssets(Employee employee) {
		return this.assetRepository.findByAssignedEmp(employee);
	}
	
	
	// getting all assets of a category
	public Set<Asset> getAssetsOfCategory(Category category) {
		return this.assetRepository.findByCategory(category);
	}
	
	
	// deleting asset
	public void deleteAsset(int aId) {
		this.assetRepository.deleteById(aId);
	}

}
