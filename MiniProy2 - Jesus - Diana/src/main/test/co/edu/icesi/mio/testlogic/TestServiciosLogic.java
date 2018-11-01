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
import co.edu.icesi.mio.logic.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestServiciosLogic {
	
	/**
	 * Conexiones necesarias para crear un servicio
	 * 
	 */
	
	@Autowired
	private IServiciosLogic serviciosLogic;
	
	@Autowired
	private IBusesLogic busesLogic;

	@Autowired
	private ICondutoresLogic conductoreLogic;
	
	@Autowired
	private IRutasLogic rutasLogic;

	
	/**
	 * Inicializa las entidades buses, conductores y rutas
	 */

	@Before
	public void setupEscenario1() {

		serviciosLogic=new Tmio1_Servicios_Logic();
		
		busesLogic=new Tmio1_Buses_Logic();
		conductoreLogic= new Tmio1_Conductores_Logic();
		rutasLogic= new Tmio1_Rutas_Logic();
		
		
		//crear los buses, conductores y rutas necesarias
		
		//Rutas
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta F a H Es1");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(3));
		ruta.setHoraFin(new BigDecimal(15));
		ruta.setNumero("D10");
    	ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
    	ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
    	
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
    	
    	rutasLogic.crearRuta(ruta);
    	
    	
    	//Conductores
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
		
		//Buses
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
		
		
	}
	
	
	@Test
	public void Test1() {
		
		assertNotNull(serviciosLogic);
		
		Tmio1Conductore conductor = conductoreLogic.buscarConductorCedula("50");
		Tmio1Bus bus= busesLogic.buscarPlaca("IZU559");
		Tmio1Ruta ruta= rutasLogic.buscarRutaRango(new BigDecimal(7),new BigDecimal( 7)).get(0);
		
		Tmio1ServicioPK s1PK = new Tmio1ServicioPK();
		
		s1PK.setCedulaConductor("50");
		s1PK.setIdBus(busesLogic.buscarPlaca("IZU559").getId());
		s1PK.setIdRuta(ruta.getId());
		Calendar d2 = new GregorianCalendar(2018,1,20);
		s1PK.setFechaInicio(d2.getTime());
		Calendar d3 = new GregorianCalendar(2018,8,27);
		s1PK.setFechaFin(d3.getTime());
		
		Tmio1Servicio s1= new Tmio1Servicio();
		s1.setId(s1PK);		
		s1.setTmio1Bus(bus);
		s1.setTmio1Conductore(conductor);
		s1.setTmio1Ruta(ruta);
		
		
		
		
	}
	
	
	
	
	
	

}
