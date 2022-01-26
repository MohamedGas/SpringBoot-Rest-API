package com.dma.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	private int doctorId;
	@Embedded
	private Name name;
	@Embedded
	private Address address;
	private String email ;
	
 
}
