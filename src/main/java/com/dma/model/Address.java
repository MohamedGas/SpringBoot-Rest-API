package com.dma.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
	private String streetName;
	private String cityName;
	private String stateName;
	private int zipCode;
}
