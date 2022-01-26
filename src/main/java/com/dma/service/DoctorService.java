package com.dma.service;

import java.util.List;

import javax.print.Doc;

import com.dma.model.Address;
import com.dma.model.Doctor;
import com.dma.model.Name;

public interface DoctorService {

	List<Doctor> getAllDoctors();

	Doctor saveDoctor(Doctor doctor, Address address, Name name);

	Doctor getDoctorById(int doctorId);

	Doctor updateDoctor(Doctor doctor, Address address, Name name, int doctorId);
	
	void deleteDoctor(int doctorId);

}
