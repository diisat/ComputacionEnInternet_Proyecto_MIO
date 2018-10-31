package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
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
	
	@Autowired
	private IServiciosLogic serviciosLogic;
	
//	///////
//	@Autowired
//	private IBusesLogic busesLogic;
//
//	@Autowired
//	private ICondutoresLogic conductoreLogic;
//	
//	@Autowired
//	private IRutasLogic rutasLogic;


	@Before
	public void setupEscenario1() {

		serviciosLogic=new Tmio1_Servicios_Logic();
		
//		busesLogic=new Tmio1_Buses_Logic();
//		conductoreLogic= new Tmio1_Conductores_Logic();
//		rutasLogic= new Tmio1_Rutas_Logic();
		
	}
	
	
	@Test
	public void crearTest() {
		
		assertNotNull(serviciosLogic);
		
		Tmio1ServicioPK s1PK = new Tmio1ServicioPK();
		
		s1PK.setCedulaConductor("12345");
		s1PK.setIdBus(-23);
		s1PK.setIdRuta(-46);
		Calendar d2 = new GregorianCalendar(2018,1,20);
		s1PK.setFechaInicio(d2.getTime());
		Calendar d3 = new GregorianCalendar(2018,8,27);
		s1PK.setFechaFin(d3.getTime());
		
		Tmio1Servicio s1= new Tmio1Servicio();
		s1.setId(s1PK);
		
		
//		s1.setTmio1Bus(serviciosLogic);
//		s1.setTmio1Conductore(tmio1Conductore);
//		s1.setTmio1Ruta(tmio1Ruta);
		
		
		
		
	}
	
	
	
	
	
	

}
