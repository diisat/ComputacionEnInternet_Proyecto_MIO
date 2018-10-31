package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.logic.*;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;
import co.edu.icesi.mio.model.Tmio1SitiosRuta;
import co.edu.icesi.mio.logic.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestRutasLogic {

	@Autowired
	private IRutasLogic rutasLogic;

	@Before
	public void setupEscenario1() {

		rutasLogic=new Tmio1_Rutas_Logic();
	}
	
	/*
	 * Agrega todos los datos
	 */
	@Test
	public void crearTest() {
		
		
		assertNotNull(rutasLogic);
		
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(5));
		ruta.setHoraFin(new BigDecimal(15));
		ruta.setNumero("P27");
    	ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
    	ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
    	
    	
    	Tmio1Ruta ruta1= new Tmio1Ruta();
		ruta1.setActiva("S");
		ruta1.setDescripcion("ruta B a D");
		ruta1.setDiaInicio(new BigDecimal(7));
		ruta1.setDiaFin(new BigDecimal(7));
		ruta1.setHoraInicio(new BigDecimal(12));
		ruta1.setHoraFin(new BigDecimal(18));
		ruta1.setNumero("E21");
    	ruta1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
    	ruta1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	ruta1.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
    	
    	Tmio1Ruta ruta2= new Tmio1Ruta();
		ruta2.setActiva("N");
		ruta2.setDescripcion("ruta C a F");
		ruta2.setDiaInicio(new BigDecimal(1));
		ruta2.setDiaFin(new BigDecimal(5));
		ruta2.setHoraInicio(new BigDecimal(11));
		ruta2.setHoraFin(new BigDecimal(19));
		ruta2.setNumero("T31");
    	ruta2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
    	ruta2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	ruta2.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
    	
    	
    	Tmio1Ruta ruta3= new Tmio1Ruta();
		ruta3.setActiva("S");
		ruta3.setDescripcion("ruta D a G");
		ruta3.setDiaInicio(new BigDecimal(1));
		ruta3.setDiaFin(new BigDecimal(3));
		ruta3.setHoraInicio(new BigDecimal(5));
		ruta3.setHoraFin(new BigDecimal(15));
		ruta3.setNumero("A10");
    	ruta3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
    	ruta3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
    	ruta3.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
    	
    	assertTrue(rutasLogic.crearRuta(ruta));
    	assertTrue(rutasLogic.crearRuta(ruta1));
    	assertTrue(rutasLogic.crearRuta(ruta2));
    	assertTrue(rutasLogic.crearRuta(ruta3));
	}
	
	/*
	 * prueba con numero difenrete 3 carcteres, por lo tanto falla
	 */
	@Test
	public void crearTest1() {
	
		assertNotNull(rutasLogic);
		
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(5));
		ruta.setHoraFin(new BigDecimal(15));
		ruta.setNumero("P272");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta));
		
	}
	
	/*
	 * prueba con dia inicio y fin, no numericos y fuera de rango, por lo tanto falla
	 */
	@Test
	public void crearTest2() {
	
		assertNotNull(rutasLogic);
		Tmio1Ruta ruta2= new Tmio1Ruta();
		ruta2.setActiva("S");
		ruta2.setDescripcion("ruta A a B");
		ruta2.setDiaInicio(new BigDecimal(1));
		ruta2.setDiaFin(new BigDecimal(40));
		ruta2.setHoraInicio(new BigDecimal(5));
		ruta2.setHoraFin(new BigDecimal(15));
		ruta2.setNumero("P27");
		ruta2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta2.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta2));
		
		Tmio1Ruta ruta3= new Tmio1Ruta();
		ruta3.setActiva("S");
		ruta3.setDescripcion("ruta A a B");
		ruta3.setDiaInicio(new BigDecimal(0));
		ruta3.setDiaFin(new BigDecimal(7));
		ruta3.setHoraInicio(new BigDecimal(5));
		ruta3.setHoraFin(new BigDecimal(15));
		ruta3.setNumero("P27");
		ruta3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta3.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta3));
	
		try {
			Tmio1Ruta ruta= new Tmio1Ruta();
			ruta.setActiva("S");
			ruta.setDescripcion("ruta A a B");
			ruta.setDiaInicio(new BigDecimal("d54"));
			ruta.setDiaFin(new BigDecimal(7));
			ruta.setHoraInicio(new BigDecimal(5));
			ruta.setHoraFin(new BigDecimal(15));
			ruta.setNumero("P27");
			ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
			ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
			ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		
			assertFalse(rutasLogic.crearRuta(ruta));
		} catch (Exception e) {
			assert(e instanceof NumberFormatException);
		}
	
		
			
	}
	/*
	 * prueba con hora fuera de rango, no numerica, por lo tanto falla
	 */
	@Test
	public void crearTest3() {
	
		assertNotNull(rutasLogic);
	
		
		Tmio1Ruta ruta2= new Tmio1Ruta();
		ruta2.setActiva("S");
		ruta2.setDescripcion("ruta A a B");
		ruta2.setDiaInicio(new BigDecimal(6));
		ruta2.setDiaFin(new BigDecimal(7));
		ruta2.setHoraInicio(new BigDecimal(-5));
		ruta2.setHoraFin(new BigDecimal(15));
		ruta2.setNumero("P27");
		ruta2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta2.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta2));
	
		
		Tmio1Ruta ruta3= new Tmio1Ruta();
		ruta3.setActiva("S");
		ruta3.setDescripcion("ruta A a B");
		ruta3.setDiaInicio(new BigDecimal(6));
		ruta3.setDiaFin(new BigDecimal(7));
		ruta3.setHoraInicio(new BigDecimal(5));
		ruta3.setHoraFin(new BigDecimal(1441));
		ruta3.setNumero("P27");
		ruta3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta3.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta3));
		
		
		Tmio1Ruta ruta4= new Tmio1Ruta();
		ruta4.setActiva("S");
		ruta4.setDescripcion("ruta A a B");
		ruta4.setDiaInicio(new BigDecimal(6));
		ruta4.setDiaFin(new BigDecimal(7));
		ruta4.setHoraInicio(new BigDecimal(7));
		ruta4.setHoraFin(new BigDecimal(1));
		ruta4.setNumero("P27");
		ruta4.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta4.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta4.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta4));
		
		
		try {
			Tmio1Ruta ruta= new Tmio1Ruta();
			ruta.setActiva("S");
			ruta.setDescripcion("ruta A a B");
			ruta.setDiaInicio(new BigDecimal(6));
			ruta.setDiaFin(new BigDecimal(7));
			ruta.setHoraInicio(new BigDecimal("f52"));
			ruta.setHoraFin(new BigDecimal(15));
			ruta.setNumero("P27");
			ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
			ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
			ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		
			assertFalse(rutasLogic.crearRuta(ruta));
		} catch (Exception e) {
			assert(e instanceof NumberFormatException);
		}
		
	}
	/*
	 * prueba con activa diferente a S o N, por lo tanto falla
	 */
	@Test
	public void crearTest4() {
	
		assertNotNull(rutasLogic);
		
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva("W");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(5));
		ruta.setHoraFin(new BigDecimal(15));
		ruta.setNumero("P27");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta));
		
	}
	/*
	 * prueba con todo null , por lo tanto falla
	 */
	@Test
	public void crearTest5() {
	
		assertNotNull(rutasLogic);
		
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva(null);
		ruta.setDescripcion(null);
		ruta.setDiaInicio(null);
		ruta.setDiaFin(null);
		ruta.setHoraInicio(null);
		ruta.setHoraFin(null);
		ruta.setNumero(null);
		ruta.setTmio1Servicios(null);
		ruta.setTmio1ServiciosSitios(null);
		ruta.setTmio1SitiosRutas1(null);
	
		assertFalse(rutasLogic.crearRuta(ruta));
		
	}
	
	
	@Test
	public void buscarPorRangoDiasTest() {
		
		
		assertNotNull(rutasLogic);
		
		List<Tmio1Ruta> rutas = rutasLogic.buscarRutaRango(new BigDecimal(1), new BigDecimal(7));
		assertNotNull("No existen rutas en este rango de dias", rutas);		
		assertEquals(4, rutas.size());
		
		
	}
	
	
//	@Test
	public void actualizarTest() {
		
		
		assertNotNull(rutasLogic);
	
		Tmio1Ruta actualizada1= rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(0);
		actualizada1.setDescripcion("ruta Z a W");
		actualizada1.setDiaInicio(new BigDecimal (5));
		Tmio1Ruta actualizada2= rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(1);
		actualizada2.setDescripcion("ruta P a Q");
		actualizada2.setDiaInicio(new BigDecimal (2));
		assertTrue(rutasLogic.actualizarRuta(actualizada1));
		assertTrue(rutasLogic.actualizarRuta(actualizada2));
	}
	
	//@Test
	public void borrarTest() {
		
		
		assertNotNull(rutasLogic);
		
		Tmio1Ruta primera= rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(0);
		assertTrue(rutasLogic.borrarRuta(primera));
		
		Tmio1Ruta primera2= rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(0);
		assertTrue(rutasLogic.borrarRuta(primera2));

		
	}
	
	@Test
	public void buscarPorRangoDias2Test() {
		
		
		assertNotNull(rutasLogic);
		
		List<Tmio1Ruta> rutas = rutasLogic.buscarRutaRango(new BigDecimal(2), new BigDecimal(7));
		assertNotNull("No existen rutas en este rango de dias", rutas);		
		assertEquals(2, rutas.size());
		}

}
