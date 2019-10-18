package patientscrm.persistence.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import patientscrm.persistence.entity.Patient;

class TestPatient {
	@Autowired
    PatientRepository patientRepo;
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testFindOne() {
		//given
		Patient patient = new Patient();
		entityManager.persist(patient);
		entityManager.flush();
		int id = patient.getIdPatient();
		// when
		Patient found =  patientRepo.findOne(id);
		System.out.println(found);
		// then
		assertThat(found)
			.isEqualToComparingFieldByField(patient);
	}
	@Test
	public void testFindAll() {
		//given
		Patient patient = new Patient(, , );
		entityManager.persist(patient);
		patient = new Patient();
		entityManager.persist(patient);
		entityManager.flush();
		// when
		List<Patient> found =  patientRepo.findAll();
		System.out.println(found);
		// then
		assertThat(found)
		.hasSize(2);
	}
	
	@Test
	public void testFindBy() {
		//given
				String nom = "";
				Patient patient = new Patient( );
				entityManager.persist(patient);
				patient = new Patient(nom ,, );
				entityManager.persist(patient);
				entityManager.flush();
				// when
				Set<Patient> found =  patientRepo.findByNom(nom);
				System.out.println(found);
				// then
				assertThat(found)
					.hasSize(2);
				found.stream()
					.map(Patient::getNom)
					.forEach(t -> assertThat(t).isEqualTo(nom));
		
	}
	
}
