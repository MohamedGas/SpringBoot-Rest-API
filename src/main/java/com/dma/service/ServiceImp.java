package com.dma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dma.exeptions.DataNotFoundException;
import com.dma.model.Address;
import com.dma.model.Doctor;
import com.dma.model.Name;
import com.dma.repository.DoctorRepository;

@Service
public class ServiceImp implements DoctorService {

	 
	public ServiceImp(DoctorRepository repository) {
		super();
		this.repository = repository;
	}

	private DoctorRepository repository;

	// Get all doctors
	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();

		repository.findAll().stream().forEach(doctors::add);

		return doctors;

	}

	// Save Doctor
	@Override
	public Doctor saveDoctor(Doctor doctor, Address  address , Name name) {
		doctor.setAddress(address);
		doctor.setName(name);
		
		return repository.save(doctor);

	}

	@Override
	public Doctor getDoctorById(int doctorId) {
		
		return repository.findById(doctorId).orElseThrow(()-> new DataNotFoundException("Doctor", "Id", doctorId));
		
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, Address address,Name name, int  doctorId) {
		Doctor existingDoctor = repository.findById(doctorId).orElseThrow(()-> new DataNotFoundException("Doctor", "Id", doctorId));
		existingDoctor.setAddress(address);
		existingDoctor.setName(name);
		existingDoctor.setEmail(doctor.getEmail());
		repository.save(existingDoctor);
		return existingDoctor;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		repository.findById(doctorId).orElseThrow(()-> new DataNotFoundException("Doctor", "Id", doctorId));
		repository.deleteById(doctorId);
		
	}

	 
}
