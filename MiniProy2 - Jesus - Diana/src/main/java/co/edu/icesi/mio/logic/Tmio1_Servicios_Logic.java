package co.edu.icesi.mio.logic;

import java.util.Calendar;
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

import co.edu.icesi.mio.dao.*;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.*;
import co.edu.icesi.mio.model.Tmio1Servicio;


@Service
public class Tmio1_Servicios_Logic implements IServiciosLogic{
	

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
    private ITmio1_Servicios_DAO serviciosDAO ;
	
	//METODOS
	
	
	//////
//	@Autowired
//	private ITmio1_Buses_DAO busesDao;
//	@Autowired
//	private ITmio1_Rutas_DAO rutasDao;
//	@Autowired
//	private ITmio1_Conductores_DAO conductoresDao;
//	

	@Autowired
	private IBusesLogic busesLogic;
	@Autowired
	private ICondutoresLogic conductoresLogic;
	@Autowired
	private IRutasLogic rutasLogic;
	
//	public Tmio1Bus getBus(int id) {
//		busesDao=new Tmio1_Buses_DAO();
//		return busesDao.findById(em, id);
//	}
//
//	public Tmio1Conductore getConductor(String cedula) {
//		conductoresDao = new Tmio1_Conductores_DAO();
//		return conductoresDao.findByCedula(em, cedula);
//	}
//
//	public Tmio1Ruta getRuta(int id) {
//		rutasDao= new Tmio1_Rutas_DAO();
//		return rutasDao.findById(em, id);
//	}
	
	///////
	
	
		// SERVICIOS
		
//	 las llaves foráneas existan; la fecha inicio esté definida y sea menor o
//	 igual que la fecha final. “La solución debe validar que al momento de crear un nuevo servicio,
//	 tanto el bus como el conductor se encuentren disponibles, es decir que no se encuentren
//	 asignados a otro servicio que coincida con las fechas, días y horarios establecidos.”
	 
		public boolean validarServicio(Tmio1Servicio servicio) {
			//TODO
			
			
			boolean ret =false;
			//valida las llaves foraneas
			if (busesLogic.validarBus(servicio.getTmio1Bus()) && conductoresLogic.validarConductor(servicio.getTmio1Conductore())
					&& rutasLogic.validarRuta(servicio.getTmio1Ruta())) {
		
				// validar que el bus se encuantre disponible
				
				
				
				
				//validar que el conductor se encuentre disponible
				
				
						ret=true;
					
				
				
			
			
			}
			return ret;
		}
	

		@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public boolean crearServicio(Tmio1Servicio servicio) {
			
			// falta hacer todas las validaciones
			if(validarServicio(servicio)) {

				serviciosDAO.save(em, servicio);
				
				return true;
			}else {
				return false;	
			}
			
			
		}
		

		@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public boolean actualizarServicio(Tmio1Servicio servicio) {
			
			// falta hacer todas las validaciones
			if(validarServicio(servicio)) {

				serviciosDAO.update(em, servicio);
				
				return true;
			}else {
				return false;	
			}
			
			
		}
		

		@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public boolean borrarServicio(Tmio1Servicio servicio) {
			
			// falta hacer todas las validaciones
			if(validarServicio(servicio)) {

				serviciosDAO.delete(em, servicio);
				
				return true;
			}else {
				return false;	
			}
			
			
		}
		
		

		@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public List<Tmio1Servicio> buscarServicioRangoFechas(Calendar fechaInicio, Calendar fechaFin ) {
			// falta hacer todas las validaciones
			if(fechaInicio!=null && fechaFin!=null) {

				List<Tmio1Servicio> act= serviciosDAO.findByRangeOfDates(em, fechaInicio, fechaFin);
				
				return act;
			}else {
				return null;	
			}
			
		}
		

		
		
		
		
		
}
