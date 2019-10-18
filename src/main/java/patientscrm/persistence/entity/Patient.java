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
	public String getCivilite() {
		return civility;
	}
	public void setCivilite(String civilite) {
		this.civility = civilite;
	}
	public String getNom() {
		return name;
	}
	public void setNom(String nom) {
		this.name = nom;
	}
	public String getPrenom() {
		return firstname;
	}
	public void setPrenom(String prenom) {
		this.firstname = prenom;
	}
	public String getAdresse() {
		return address;
	}
	public void setAdresse(String adresse) {
		this.address = adresse;
	}
	public Integer getCp() {
		return zipcode;
	}
	public void setCp(Integer cp) {
		this.zipcode = cp;
	}
	public String getVille() {
		return city;
	}
	public void setVille(String ville) {
		this.city = ville;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return phone;
	}
	public void setTelephone(String telephone) {
		this.phone = telephone;
	}
	@Override
	public String toString() {
		return new StringBuilder(this.getIdPatient())
				.append(" (")
				.append(this.getNom())
				.append(", ")
				.append(this.getPrenom())
				.append(", ")
				.append(this.getEmail())
				.append(", ")
				.append(this.getTelephone())
				.append(")")
				.toString();
	}
}
		