package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.logic.*;
import co.edu.icesi.mio.model.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestServiciosLogic {
	
	/**
	 * Conexiones necesarias para crear un servicio
	 * 
	 */
	@Autowired
	private IRutasLogic rutasLogic;
	
	
	@Autowired
	private IServiciosLogic serviciosLogic;
	
	@Autowired
	private IBusesLogic busesLogic;

	@Autowired
	private ICondutoresLogic conductoreLogic;
	

	

	
	/**
	 * Inicializa las entidades buses, conductores y rutas
	 */

//	@Test
	public void crearServiciosTest1() {


		//Se crean los buses, conductores y rutas necesarias (escenario para crear los servicios)
		
		/////Rutas
		
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B CR1");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(5));
		ruta.setHoraFin(new BigDecimal(15));
		ruta.setNumero("P27");
    	ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
    	ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

    	rutasLogic.crearRuta(ruta);
    	
    	Tmio1Ruta ruta1= new Tmio1Ruta();
		ruta1.setActiva("S");
		ruta1.setDescripcion("ruta J a K");
		ruta1.setDiaInicio(new BigDecimal(7));
		ruta1.setDiaFin(new BigDecimal(7));
		ruta1.setHoraInicio(new BigDecimal(12));
		ruta1.setHoraFin(new BigDecimal(18));
		ruta1.setNumero("T91");
    	ruta1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
    	ruta1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	ruta1.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
    	
    	rutasLogic.crearRuta(ruta1);
    	
    	
    	/////Conductores
    	Tmio1Conductore conductor4= new Tmio1Conductore();
		conductor4.setCedula("50");
		conductor4.setNombre("Alejandro");
		conductor4.setApellidos("Perez");
		Calendar d6 = new GregorianCalendar(2017,02,10);
		conductor4.setFechaContratacion(d6.getTime());
		Calendar d7 = new GregorianCalendar(2000,10,20);
		conductor4.setFechaNacimiento(d7.getTime());
		conductor4.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor4.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Conductore conductor5= new Tmio1Conductore();
		conductor5.setCedula("60");
		conductor5.setNombre("Julian");
		conductor5.setApellidos("Romero");
		Calendar d8 = new GregorianCalendar(1950,02,14);
		conductor5.setFechaContratacion(d8.getTime());
		Calendar d9 = new GregorianCalendar(1970,11,10);
		conductor5.setFechaNacimiento(d9.getTime());
		conductor5.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor5.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	
		conductoreLogic.crearConductor(conductor4);
		conductoreLogic.crearConductor(conductor5);

		/////Buses
		Tmio1Bus bus = new Tmio1Bus();
		
		bus.setCapacidad(new BigDecimal(1000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setPlaca("IZU559");
		bus.setTipo("A");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Bus bus1 = new Tmio1Bus();
		
		bus1.setCapacidad(new BigDecimal(2000));
		bus1.setMarca("Renault");
		bus1.setModelo(new BigDecimal(2014));
		bus1.setPlaca("IAA123");
		bus1.setTipo("T");
		bus1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		busesLogic.crearBus(bus);
		busesLogic.crearBus(bus1);
		
		
		
		////////Test crear nuevos servicios
		
		assertNotNull(serviciosLogic);

		Tmio1ServicioPK s1PK = new Tmio1ServicioPK();
		
		s1PK.setCedulaConductor(conductor4.getCedula());
		s1PK.setIdBus(bus.getId());
		s1PK.setIdRuta(ruta.getId());
		Calendar d2 = new GregorianCalendar(2018,1,20);
		s1PK.setFechaInicio(d2.getTime());
		Calendar d3 = new GregorianCalendar(2018,8,27);
		s1PK.setFechaFin(d3.getTime());
		
		Tmio1Servicio s1= new Tmio1Servicio();
		s1.setId(s1PK);		
		s1.setTmio1Bus(bus);
		s1.setTmio1Conductore(conductor4);
		s1.setTmio1Ruta(ruta);
		
		
		assertTrue("No se creó correctamente el servicio",serviciosLogic.crearServicio(s1));
		ruta.addTmio1Servicio(s1);
		bus.addTmio1Servicio(s1);
		conductor4.addTmio1Servicio(s1);
		
		
//		//crea 
//		Tmio1ServicioPK s2PK = new Tmio1ServicioPK();
//		
//		s2PK.setCedulaConductor(conductor5.getCedula());
//		s2PK.setIdBus(bus.getId());
//		s2PK.setIdRuta(ruta.getId());
//		Calendar d4 = new GregorianCalendar(2017,1,20);
//		s2PK.setFechaInicio(d4.getTime());
//		Calendar d5 = new GregorianCalendar(2017,8,27);
//		s2PK.setFechaFin(d5.getTime());
//		
//		Tmio1Servicio s2= new Tmio1Servicio();
//		s2.setId(s2PK);		
//		s2.setTmio1Bus(bus);
//		s2.setTmio1Conductore(conductor5);
//		
//		s2.setTmio1Ruta(ruta);
//		
//		
//		assertTrue("No se creó correctamente el servicio",serviciosLogic.crearServicio(s2));
//		ruta.addTmio1Servicio(s2);
//		bus.addTmio1Servicio(s2);
//		conductor5.addTmio1Servicio(s2);
//		
		
		//borra los datos agregados en las tablas previamente
//		busesLogic.borrarBus(bus);
//		busesLogic.borrarBus(bus1);
//		
//		rutasLogic.borrarRuta(ruta1);
//		rutasLogic.borrarRuta(ruta);
//		
//		conductoreLogic.borrarConductor(conductor4);
//		conductoreLogic.borrarConductor(conductor5);
		
		
	}
	
	@Test
	public void validaDisponibilidad() {
		//Se crean los buses, conductores y rutas necesarias (escenario para crear los servicios)
		
				/////Rutas
				
				Tmio1Ruta ruta= new Tmio1Ruta();
				ruta.setActiva("S");
				ruta.setDescripcion("ruta A a B CR1");
				ruta.setDiaInicio(new BigDecimal(6));
				ruta.setDiaFin(new BigDecimal(7));
				ruta.setHoraInicio(new BigDecimal(5));
				ruta.setHoraFin(new BigDecimal(15));
				ruta.setNumero("P27");
		    	ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		    	ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		    	ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

		    	rutasLogic.crearRuta(ruta);
		    	
		    	Tmio1Ruta ruta1= new Tmio1Ruta();
				ruta1.setActiva("S");
				ruta1.setDescripcion("ruta J a K");
				ruta1.setDiaInicio(new BigDecimal(7));
				ruta1.setDiaFin(new BigDecimal(7));
				ruta1.setHoraInicio(new BigDecimal(12));
				ruta1.setHoraFin(new BigDecimal(18));
				ruta1.setNumero("T91");
		    	ruta1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		    	ruta1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		    	ruta1.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		    	
		    	rutasLogic.crearRuta(ruta1);
		    	
		    	
		    	/////Conductores
		    	Tmio1Conductore conductor4= new Tmio1Conductore();
				conductor4.setCedula("50");
				conductor4.setNombre("Alejandro");
				conductor4.setApellidos("Perez");
				Calendar d6 = new GregorianCalendar(2017,02,10);
				conductor4.setFechaContratacion(d6.getTime());
				Calendar d7 = new GregorianCalendar(2000,10,20);
				conductor4.setFechaNacimiento(d7.getTime());
				conductor4.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
				conductor4.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
				
				
				Tmio1Conductore conductor5= new Tmio1Conductore();
				conductor5.setCedula("60");
				conductor5.setNombre("Julian");
				conductor5.setApellidos("Romero");
				Calendar d8 = new GregorianCalendar(1950,02,14);
				conductor5.setFechaContratacion(d8.getTime());
				Calendar d9 = new GregorianCalendar(1970,11,10);
				conductor5.setFechaNacimiento(d9.getTime());
				conductor5.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
				conductor5.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		    	
				conductoreLogic.crearConductor(conductor4);
				conductoreLogic.crearConductor(conductor5);

				/////Buses
				Tmio1Bus bus = new Tmio1Bus();
				
				bus.setCapacidad(new BigDecimal(1000));
				bus.setMarca("Renault");
				bus.setModelo(new BigDecimal(2015));
				bus.setPlaca("IZU559");
				bus.setTipo("A");
				bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
				bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
				
				
				Tmio1Bus bus1 = new Tmio1Bus();
				
				bus1.setCapacidad(new BigDecimal(2000));
				bus1.setMarca("Renault");
				bus1.setModelo(new BigDecimal(2014));
				bus1.setPlaca("IAA123");
				bus1.setTipo("T");
				bus1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
				bus1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
				
				busesLogic.crearBus(bus);
				busesLogic.crearBus(bus1);
				
				
				
				////////Test crear nuevos servicios
				
				assertNotNull(serviciosLogic);

				Tmio1ServicioPK s1PK = new Tmio1ServicioPK();
				
				s1PK.setCedulaConductor(conductor4.getCedula());
				s1PK.setIdBus(bus.getId());
				s1PK.setIdRuta(ruta.getId());
				Calendar d2 = new GregorianCalendar(2018,1,20);
				s1PK.setFechaInicio(d2.getTime());
				Calendar d3 = new GregorianCalendar(2018,8,27);
				s1PK.setFechaFin(d3.getTime());
				
				Tmio1Servicio s1= new Tmio1Servicio();
				s1.setId(s1PK);		
				s1.setTmio1Bus(bus);
				
				s1.setTmio1Conductore(conductor4);
				
				s1.setTmio1Ruta(ruta);
				
				
				assertTrue("No se creó correctamente el servicio",serviciosLogic.crearServicio(s1));
				bus.addTmio1Servicio(s1);
				conductor4.addTmio1Servicio(s1);
				ruta.addTmio1Servicio(s1);
				
				//No crea servicio cuyo bus y conductor no está disponible.
				Tmio1ServicioPK s2PK = new Tmio1ServicioPK();
				
				s2PK.setCedulaConductor(conductor4.getCedula());
				s2PK.setIdBus(bus.getId());
				s2PK.setIdRuta(ruta.getId());
				Calendar d4 = new GregorianCalendar(2018,1,20);
				s2PK.setFechaInicio(d4.getTime());
				Calendar d5 = new GregorianCalendar(2018,8,27);
				s2PK.setFechaFin(d5.getTime());
				
				Tmio1Servicio s2= new Tmio1Servicio();
				s2.setId(s2PK);		
				s2.setTmio1Bus(bus);
				
				s2.setTmio1Conductore(conductor4);
				
				s2.setTmio1Ruta(ruta);
				
				
				assertFalse("No se creó correctamente el servicio",serviciosLogic.crearServicio(s2));
				bus.addTmio1Servicio(s2);
				conductor4.addTmio1Servicio(s2);
				ruta.addTmio1Servicio(s2);
				
				//borra los datos agregados en las tablas previamente
//				serviciosLogic.borrarServicio(s1);
//				busesLogic.borrarBus(bus);
//				busesLogic.borrarBus(bus1);
//				
//				rutasLogic.borrarRuta(ruta1);
//				rutasLogic.borrarRuta(ruta);
//				
//				conductoreLogic.borrarConductor(conductor4);
//				conductoreLogic.borrarConductor(conductor5);
	}

	public void validaFechaInicioMenorFechaFin() {
		
	}
	
	/**
	 * Funciona, no permite crear servicios con relaciones nulos
	 */
	@Test
	public void crearServiciosTest() {
		
		Tmio1Servicio act = new Tmio1Servicio();
		
		Tmio1ServicioPK s1PK = new Tmio1ServicioPK();
		
		s1PK.setCedulaConductor("");
		s1PK.setIdBus(0);
		s1PK.setIdRuta(0);
		Calendar d2 = new GregorianCalendar(2018,1,20);
		s1PK.setFechaInicio(d2.getTime());
		Calendar d3 = new GregorianCalendar(2018,8,27);
		s1PK.setFechaFin(d3.getTime());
		

		act.setId(s1PK);		
		act.setTmio1Bus(null);
		act.setTmio1Conductore(null);
		act.setTmio1Ruta(null);
		assertFalse("No funciona, sí se creó el servicio.",serviciosLogic.crearServicio(act));
		
		
	}
	
	
	
	
	
	@Test
	public void borrarTest() {
		Tmio1Servicio act = new Tmio1Servicio();
		
		
		
		assertFalse("No funciona, sí se borró el servicio.",serviciosLogic.borrarServicio(act));
		
		
		
	}
	
	
	@Test
	public void modificarTest() {
		
		Tmio1Servicio act = new Tmio1Servicio();
		
		
		assertFalse("no es falso",serviciosLogic.actualizarServicio(act));
		
		
	}
	
	
	
	
	
	@Test
	public void buscarRangoFechasTest1() {
		
		Calendar ini = new GregorianCalendar(2018,2,10);
		Calendar fin = new GregorianCalendar(2017,4,2);
		
		assertNull("no es nulo",serviciosLogic.buscarServicioRangoFechas(ini, fin));
		
		
		
	}
	
	
	@Test
	public void buscarRangoFechasTest2() {
		
		Calendar ini = null;
		Calendar fin = null;
		
		assertNull("no es nulo",serviciosLogic.buscarServicioRangoFechas(ini, fin));
		
		
		
	}
	
	
	
	
	
	
	
	

}
