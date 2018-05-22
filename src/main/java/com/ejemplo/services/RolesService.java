package com.ejemplo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ejemplo.dao.RolesDao;
import edu.ejemplo.modelos.Roles;

@Service
@Transactional
public class RolesService {

	@Autowired
	RolesDao rolesDao;
	
	public List<Roles> getListaRoles() {
		
		return rolesDao.getListaRoles();
	}


	public void guardarRol(Roles rol) {
		rolesDao.guardarRol(rol);
		
	}

	public Roles getRolbyId(int idRol) {
		return rolesDao.getRolbyId(idRol);
	}

	public void borrarByIdRol(int idRol) {
		rolesDao.borrarByIdRol(idRol);
	}

}
