package patientscrm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	
	private Integer idPatient;
	private String civilite;
	private String nom;
	private String prenom;
	private String adresse;
	private Integer cp;
	private String ville;
	private String email;
	private Integer telephone;
	
	public Patient(String civilite, String nom, String prenom, String adresse, Integer cp, String ville,
			String email, Integer telephone) {
		super();
	
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
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
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
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
		