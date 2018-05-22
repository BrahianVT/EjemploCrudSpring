package edu.ejemplo.dao;

import java.util.List;

import edu.ejemplo.modelos.Roles;

public interface RolesDao {

	public List<Roles> getListaRoles();
	public void guardarRol(Roles rol);
	public Roles getRolbyId(int idRol);
	public void borrarByIdRol(int idRol);
}
