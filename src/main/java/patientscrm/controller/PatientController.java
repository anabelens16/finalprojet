package patientscrm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import patientscrm.persistence.entity.Patient;
import patientscrm.persistence.repository.PatientRepository;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
		
		@Autowired
		PatientRepository patientRepo;
		
		@GetMapping
		@ResponseBody
		List<Patient> findAll(){
			return patientRepo.findAll();
		}
		
		@GetMapping(value="/{id}")
		@ResponseBody
		Patient findById(@PathVariable("id") Integer id) {
			return patientRepo.getOne(id);
		}

		@PostMapping
		@ResponseBody
		public Patient createPatient(@RequestBody Patient patient) {
			return patientRepo.save(patient);
		}

}
