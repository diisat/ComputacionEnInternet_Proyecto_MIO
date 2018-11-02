package co.edu.icesi.mio.logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;

@Service
public class Tmio1_Conductores_Logic implements ICondutoresLogic {
	

	EntityManagerFactory managerFactor = Persistence.createEntityManagerFactory("MiniProyectoComputacion");
	
	// atributos
	@PersistenceContext
    private EntityManager em= managerFactor.createEntityManager();
	

	@Autowired
    private ITmio1_Conductores_DAO conductorDAO  =new Tmio1_Conductores_DAO();
	//preguntar pq cuando se quita el new falla la instanciacion
	
	////////
	//METODOS
	
	// CONDUCTORES
	
	
//	la cédula esté definida y sea numérica; el nombre esté definido y
//	tenga por lo menos tres caracteres; el apellido esté definido y tenga por lo menos tres
//	caracteres; la fecha de nacimiento esté definida y sea mayor de edad; la fecha de contratación
//	esté definida y sea menor a la fecha actual.
//	
	public boolean validarConductor(Tmio1Conductore cond) {
		boolean ret = false;
		try {
	
			// validar cedula
			if(cond!=null) {
				
				Integer.parseInt(cond.getCedula());
			
			if(cond.getCedula()!=null && !cond.getCedula().equals("") ) {
				
				//validar nombre
				if(cond.getNombre()!=null && !cond.getNombre().equals("") && cond.getNombre().length()>=3) {
					//validar apellido
					if(cond.getApellidos()!=null && !cond.getApellidos().equals("") && cond.getApellidos().length()>=3) {
						//validar fecha nacimiento
						if(cond.getFechaNacimiento()!=null) {
							//validar fecha contratacion
							if(cond.getFechaContratacion()!=null) {
								ret=true;
							}
						}
					}
					
				}
			}
				
			}
			
			return ret;
		} catch (NumberFormatException e) {
			
			return false;
		}
		
	}
	
	@Transactional 
	public boolean crearConductor(Tmio1Conductore cond) {

		
				if(validarConductor(cond)) {

					
					try {
						em.getTransaction().begin();
						conductorDAO.save(em, cond);
						em.getTransaction().commit();
					} catch (Exception e) {
						return false;
					}
					
				
				return true;
		}else {
			
			return false;	
		}
		
		
	}
	
	@Transactional
	public boolean actualizarConductor(Tmio1Conductore cond) {
	
		if(validarConductor(cond)) {

			em.getTransaction().begin();
			conductorDAO.update(em, cond);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	@Transactional
	public boolean borrarConductor(Tmio1Conductore cond) {
		
		if(validarConductor(cond)) {

			em.getTransaction().begin();
			conductorDAO.delete(em, cond);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	

	public List<Tmio1Conductore> buscarConductorNombre(String nombre) {
		
		if(!nombre.equals("") && nombre != null) {

			em.getTransaction().begin();
			List<Tmio1Conductore> act=conductorDAO.findByName(em, nombre);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public List<Tmio1Conductore> buscarConductorApellido(String apellido) {
		// falta hacer todas las validaciones
		if(!apellido.equals("") && apellido!=null) {

			em.getTransaction().begin();
			List<Tmio1Conductore> act=conductorDAO.findByLastName(em, apellido);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public Tmio1Conductore buscarConductorCedula(String cedula) {

		if(!cedula.equals("") && cedula !=null) {

			em.getTransaction().begin();
			Tmio1Conductore act=conductorDAO.findByCedula(em, cedula);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	


}
