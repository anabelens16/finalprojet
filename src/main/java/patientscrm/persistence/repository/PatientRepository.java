package patientscrm.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import patientscrm.persistence.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient , Integer>{

}
