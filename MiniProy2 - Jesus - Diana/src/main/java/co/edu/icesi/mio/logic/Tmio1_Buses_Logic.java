package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.edu.icesi.mio.dao.ITmio1_Buses_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;


@Service
public class Tmio1_Buses_Logic implements IBusesLogic {
	


	@PersistenceContext
    private EntityManager em;
    
	@Autowired
	private ITmio1_Buses_DAO busesDAO;
	

//	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiniProyectoComputacion");
	
	
	
	
	

//	 la placa est� definida y tenga seis caracteres; la marca est� definida y tenga
//	 al menos tres caracteres; el modelo sea num�rico de cuatro d�gitos; el tipo sea P, A, o T; la
//	 capacidad sea num�rica mayor a cero.
	
	public boolean validarBus(Tmio1Bus bus) {
		/*
		 * Validaci�n esta completa
		 */
		boolean ret=false;
		// valida la placa
		if(bus.getPlaca()!=null && !bus.getPlaca().equals("")  && bus.getPlaca().length()==6) {
			// valida la marca
			if(bus.getMarca()!=null&&!bus.getMarca().equals("")  && bus.getMarca().length()>=3) {
				// valida el modelo
				if(bus.getModelo()!=null && bus.getModelo().compareTo(new BigDecimal(1000))>=0 ) {
					// valida el tipo
					if(bus.getTipo()!=null && (bus.getTipo().equals("P")||bus.getTipo().equals("A")||bus.getTipo().equals("T"))) {
						// valida la capacidad
						if(bus.getCapacidad()!=null && bus.getCapacidad().compareTo(new BigDecimal(0))>0) {
							ret=true;	
						}
					}
				}	
			}
		}
		
		return ret;
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean crearBus(Tmio1Bus bus) {
		
		
		if(validarBus(bus)) {

			
			busesDAO.save(em, bus);
		
			
			return true;
		}else {
			return false;	
		}
		
	}
	

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Tmio1Bus buscarPlaca(String placa) {
		
		if(placa!=null&&!placa.equals("")) {

			
			Tmio1Bus act=busesDAO.findByPlaca(em, placa);
			
			
			return act;
		}else {
			return null;	
		}
	}
	

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean actualizarBus(Tmio1Bus bus) {
		
		
		if(validarBus(bus)) {

	
			busesDAO.update(em, bus);
			
			
			return true;
		}else {
			return false;	
		}

	}
	

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean borrarBus(Tmio1Bus bus) {
		
		
		if(validarBus(bus)) {

			
			busesDAO.delete(em, bus);
			
			
			return true;
		}else {
			return false;	
		}

	}
	

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Tmio1Bus> buscarBusModelo(BigDecimal modelo) {
		
		
		
		if(modelo!=null && modelo.compareTo(new BigDecimal(1000))>=0) {

			
			List<Tmio1Bus> act= busesDAO.findByModel(em, modelo);
		
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Tmio1Bus> buscarBusTipo(String tipo) {
		
		
		if(tipo!=null && (tipo.equals("P")||tipo.equals("A")||tipo.equals("T"))) {

		
			List<Tmio1Bus> act= busesDAO.findByType(em, tipo);

			
			return act;
		}else {
			return null;	
		}
		
	}
	

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Tmio1Bus> buscarBusCapacidad(BigDecimal capacidad) {
		
		List<Tmio1Bus> act=null;
		if(capacidad!=null ) {

			if (capacidad.compareTo(new BigDecimal(0))>0 && busesDAO!=null) {
				
			 act= busesDAO.findByCapacity(em, capacidad);
			
			}
		}
			return act;	
		
		
	}


}
