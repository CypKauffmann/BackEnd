package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="RoleP")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idPers;
    private String nomPers;
    private String prenomPers;
    private int age;
    private String email;
    private String tel;
    
    @OneToMany
    private List<RendezVous> rdv;
    
    @OneToMany
    private List<Historique> historiques;
	
    public Personne(int id, String nomPers, String prenomPers, int age, String email, String tel, List<RendezVous> rdv,
			List<Historique> historiques) {
		super();
		this.idPers = idPers;
		this.nomPers = nomPers;
		this.prenomPers = prenomPers;
		this.age = age;
		this.email = email;
		this.tel = tel;
		this.rdv = rdv;
		this.historiques = historiques;
	}
	public Personne() 
	{
		
	}
    public int getId() {
		return idPers;
	}
	public void setId(int idPers) {
		this.idPers = idPers;
	}
	public String getNomPers() {
		return nomPers;
	}
	public void setNomPers(String nomPers) {
		this.nomPers = nomPers;
	}
	public String getPrenomPers() {
		return prenomPers;
	}
	public void setPrenomPers(String prenomPers) {
		this.prenomPers = prenomPers;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<RendezVous> getRdv() {
		return rdv;
	}
	public void setRdv(List<RendezVous> rdv) {
		this.rdv = rdv;
	}
	public List<Historique> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}
	


    
    
}
