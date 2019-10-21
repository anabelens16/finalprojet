package patientscrm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	
	private Integer idPatient;
	private String civility;
	private String name;
	private String firstname;
	private String address;
	private Integer zipcode;
	private String city;
	private String email;
	private String phone;
	
	public Patient(String civilite, String nom, String prenom, String adresse, Integer cp, String ville,
			String email, String telephone) {
		super();
	
		this.name = nom;
		this.firstname = prenom;
		this.email = email;
		this.phone = telephone;
	}
	public Patient(String nom, String prenom, String telephone) {
        super();
        this.name = nom;
        this.firstname = prenom;
        this.phone = telephone;
    }
	public Patient() {
		super();
	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_patient")
	public Integer getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}
	
	public String getCivility() {
		return civility;
	}
	public void setCivility(String civility) {
		this.civility = civility;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return new StringBuilder(this.getIdPatient())
				.append(" (")
				.append(this.getName())
				.append(", ")
				.append(this.getFirstname())
				.append(", ")
				.append(this.getEmail())
				.append(", ")
				.append(this.getPhone())
				.append(")")
				.toString();
	}
}
		