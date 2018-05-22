package edu.ejemplo.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tax_cat_rol")
@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRol;
	private String description;
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Roles(){};
	public Roles(int idRol, String description) {
		super();
		this.idRol = idRol;
		this.description = description;
	}
	
}
