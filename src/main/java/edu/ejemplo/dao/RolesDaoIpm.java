package edu.ejemplo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ejemplo.modelos.Roles;

@Repository
public class RolesDaoIpm implements RolesDao {

	@Autowired
	SessionFactory session;
	
	Session getSession(){return session.getCurrentSession();}
	
	@Override
	public List<Roles> getListaRoles() {
		
		return (List<Roles>) getSession().createQuery("from Roles" ,Roles.class).getResultList();
	}

	@Override
	public void guardarRol(Roles rol) {
		getSession().saveOrUpdate(rol);
		
	}

	@Override
	public Roles getRolbyId(int idRol) {
		Roles encontrado = getSession().find(Roles.class, idRol);
		return encontrado;
	}

	@Override
	public void borrarByIdRol(int idRol) {
		Roles encontrado = getRolbyId(idRol);
		if(encontrado != null)
			getSession().delete(encontrado);
		else
			System.out.println("No se encontro role");
		
	}

}
