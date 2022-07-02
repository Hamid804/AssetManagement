package com.example.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	private String aName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	private Date purchaseDate;
	private String conditionNotes;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee assignedEmp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee recoveredEmp;
	
	private String availability;
	
	public Asset() {
		super();
	}

	public Asset(int aId, String aName, Category category, Date purchaseDate, String conditionNotes,
			Employee assignedEmp, Employee recoveredEmp, String availability) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.category = category;
		this.purchaseDate = purchaseDate;
		this.conditionNotes = conditionNotes;
		this.assignedEmp = assignedEmp;
		this.recoveredEmp = recoveredEmp;
		this.availability = availability;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getConditionNotes() {
		return conditionNotes;
	}

	public void setConditionNotes(String conditionNotes) {
		this.conditionNotes = conditionNotes;
	}

	public Employee getAssignedEmp() {
		return assignedEmp;
	}

	public void setAssignedEmp(Employee assignedEmp) {
		this.assignedEmp = assignedEmp;
	}

	public Employee getRecoveredEmp() {
		return recoveredEmp;
	}

	public void setRecoveredEmp(Employee recoveredEmp) {
		this.recoveredEmp = recoveredEmp;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
}
