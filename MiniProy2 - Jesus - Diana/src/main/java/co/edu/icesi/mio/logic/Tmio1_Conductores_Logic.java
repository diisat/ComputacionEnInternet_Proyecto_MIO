package co.edu.icesi.mio.logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;

@Service
public class Tmio1_Conductores_Logic implements ICondutoresLogic {
	


	// atributos
	@PersistenceContext
    private EntityManager em;
	

	@Autowired
    private ITmio1_Conductores_DAO conductorDAO ;
	
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
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean crearConductor(Tmio1Conductore cond) {

		
				if(validarConductor(cond)) {

					
					try {
						
						conductorDAO.save(em, cond);
						
					} catch (Exception e) {
						return false;
					}
					
				
				return true;
		}else {
			
			return false;	
		}
		
		
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean actualizarConductor(Tmio1Conductore cond) {
	
		if(validarConductor(cond)) {

			
			conductorDAO.update(em, cond);
		
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean borrarConductor(Tmio1Conductore cond) {
		
		if(validarConductor(cond)) {

		
			conductorDAO.delete(em, cond);
			
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Tmio1Conductore> buscarConductorNombre(String nombre) {
		
		if(!nombre.equals("") && nombre != null) {

			
			List<Tmio1Conductore> act=conductorDAO.findByName(em, nombre);
		
			
			return act;
		}else {
			return null;	
		}
		
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Tmio1Conductore> buscarConductorApellido(String apellido) {
		// falta hacer todas las validaciones
		if(!apellido.equals("") && apellido!=null) {

			
			List<Tmio1Conductore> act=conductorDAO.findByLastName(em, apellido);
		
			return act;
		}else {
			return null;	
		}
		
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Tmio1Conductore buscarConductorCedula(String cedula) {

		if(!cedula.equals("") && cedula !=null) {

			
			Tmio1Conductore act=conductorDAO.findByCedula(em, cedula);
			
			
			return act;
		}else {
			return null;	
		}
		
	}
	


}
