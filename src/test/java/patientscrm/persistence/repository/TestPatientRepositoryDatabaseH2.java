package patientscrm.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import patientscrm.persistence.entity.Patient;

@DataJpaTest // imply H2, disable full auto-config, keep only jpa part and rollback transactions
//@AutoConfigureTestDatabase(replace=Replace.NONE) // don't replace mysql with h2
//@ActiveProfiles("test")  	// with AutoConfigureTestDatabase/replace/None 
//							// allow to load application-test.properties 
//							// instead of application.properties
//							// to address another mysql database for tests only
class TestPatientRepositoryDatabaseH2 {
	@Autowired
	PatientRepository patientRepo;
		
	// use special test H2 entityManager different from configuration application
	@Autowired
	TestEntityManager entityManager;

	@Test
    public void testFindOne() {
        //given
        var nom = "DROUARD";
        var prenom = "Romain";
        var telephone = "06 19 75 45 99";

        var patientInserted = new Patient(nom, prenom, telephone);
        entityManager.persist(patientInserted);
        entityManager.flush();
        Integer idPatient = patientInserted.getIdPatient();
        //when
        var found = patientRepo.getOne(idPatient);
        //then
        assertAll(
                ()-> assertEquals(idPatient, found.getIdPatient()),
                ()-> assertEquals(nom, found.getNom()),
                ()-> assertEquals(prenom, found.getPrenom()),
                ()-> assertEquals(telephone, found.getTelephone())
                );
    }
@Test
    public void testFindAll() {
        //given
        var patient = new Patient("DROUARD", "Romain", "06 19 75 45 99");
        entityManager.persist(patient);
        patient = new Patient("SANCHEZ", "Marie", "06 19 88 46 87");
        entityManager.persist(patient);
        entityManager.flush();
        //when
        var found = patientRepo.findAll();
        //then
        assertEquals(2, found.size());
    }
}
