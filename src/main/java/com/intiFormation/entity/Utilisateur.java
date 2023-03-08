package com.intiFormation.entity;



import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Utilisateur extends Personne {

<<<<<<< HEAD
=======

<<<<<<< HEAD
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int idUt;
=======

>>>>>>> main
>>>>>>> main
	private String username;
	private String password;

	@ManyToOne
	@JoinColumn(name = "idRole")
	private Role role;

<<<<<<< HEAD
/*	public int getIdUt() {
		return idUt;
	}

	public void setIdUt(int idUt) {
		this.idUt = idUt;
	}
*/
=======
<<<<<<< HEAD
=======
	

	

>>>>>>> main
>>>>>>> main
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	public Utilisateur(int idPers, String nomPers, String prenomPers, int age, String email, String tel,
			List<RendezVous> rendezVous, List<Historique> historiques, String username, String password,
			Role role) {
		super(idPers, nomPers, prenomPers, age, email, tel, rendezVous, historiques);
		this.username = username;
		this.password = password;
		this.role = role;
	}
>>>>>>> main

>>>>>>> main
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Utilisateur [username=" + username + ", password=" + password + "]";
=======
<<<<<<< HEAD
		return "Utilisateur [username=" + username + ", password=" + password + "]";
=======
		return "Utilisateur [idUt="  + ", username=" + username + ", password=" + password + "]";
>>>>>>> main
>>>>>>> main
	}

}
