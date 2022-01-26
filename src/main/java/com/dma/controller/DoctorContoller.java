package com.dma.controller;

import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dma.model.Address;
import com.dma.model.Doctor;
import com.dma.model.Name;
import com.dma.service.ServiceImp;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorContoller {

	private ServiceImp service;

	public DoctorContoller(ServiceImp service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<Doctor> getAllDoctors() {
		return service.getAllDoctors();
	}

	@GetMapping("{id}")
	public Doctor getDoctorById(@PathVariable("id") int doctorId) {
		return service.getDoctorById(doctorId);
	}

	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		Address address = doctor.getAddress();
		Name name = doctor.getName();

		return new ResponseEntity<Doctor>(service.saveDoctor(doctor, address, name), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") int doctorId, @RequestBody Doctor doctor) {
		Address address = doctor.getAddress();
		Name name = doctor.getName();
		return new ResponseEntity<Doctor>(service.updateDoctor(doctor, address, name, doctorId), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") int id)
	{	
		service.deleteDoctor(id);
		return new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
	}

}