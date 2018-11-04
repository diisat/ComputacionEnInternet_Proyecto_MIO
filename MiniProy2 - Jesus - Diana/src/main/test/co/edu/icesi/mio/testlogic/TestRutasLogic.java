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

	
	/*
	 * TEST 1 - crea 4 rutas - actualiza 2 -
	 */
	/*
	 * Crea exitosamente una ruta
	 */
//	@Test
	public void crearRutaTest1_1() {
	assertNotNull(rutasLogic);
		
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

    	assertTrue(rutasLogic.crearRuta(ruta));
    
	}
	
	/*
	 * No quitar comentario
	 */
//	@Before
	public void crearRutaTest1_2() {
	assertNotNull(rutasLogic);
		

	Tmio1Ruta ruta1= new Tmio1Ruta();
	ruta1.setActiva("S");
	ruta1.setDescripcion("ruta B a D CR2");
	ruta1.setDiaInicio(new BigDecimal(7));
	ruta1.setDiaFin(new BigDecimal(7));
	ruta1.setHoraInicio(new BigDecimal(12));
	ruta1.setHoraFin(new BigDecimal(18));
	ruta1.setNumero("E21");
	ruta1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
	ruta1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
	ruta1.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
    	assertTrue(rutasLogic.crearRuta(ruta1));
    
	}
	/*
	 * No quitar comentario
	 */
//	@Before
	public void crearRutaTest1_3() {
		assertNotNull(rutasLogic);
		
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

    	assertTrue(rutasLogic.crearRuta(ruta2));
    
	}
	/*
	 * No quitar comentario
	 */
//	@Before
	public void crearRutaTest1_4() {
		
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
    	
    	assertTrue(rutasLogic.crearRuta(ruta3));
    	

//		
		
	}
	
	/*
	 * prueba con numero difenrete 3 carcteres, por lo tanto falla
	 */
	@Test
	public void crearConNumDif3() {
	
		assertNotNull(rutasLogic);
		
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B C1");
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
	public void crearDiaInicioFin() {
	
		assertNotNull(rutasLogic);
		Tmio1Ruta ruta2= new Tmio1Ruta();
		ruta2.setActiva("S");
		ruta2.setDescripcion("ruta A a B C2");
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
		ruta3.setDescripcion("ruta A a B C2");
		ruta3.setDiaInicio(new BigDecimal(0));
		ruta3.setDiaFin(new BigDecimal(7));
		ruta3.setHoraInicio(new BigDecimal(5));
		ruta3.setHoraFin(new BigDecimal(15));
		ruta3.setNumero("P27");
		ruta3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta3.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta3));
			
	}
	/*
	 * prueba con hora fuera de rango, no numerica, por lo tanto falla
	 */
	@Test
	public void crearConHora() {
	
		assertNotNull(rutasLogic);
	
		
		Tmio1Ruta ruta2= new Tmio1Ruta();
		ruta2.setActiva("S");
		ruta2.setDescripcion("ruta A a B C3");
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
		ruta3.setDescripcion("ruta A a B C3");
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
		ruta4.setDescripcion("ruta A a B C3");
		ruta4.setDiaInicio(new BigDecimal(6));
		ruta4.setDiaFin(new BigDecimal(7));
		ruta4.setHoraInicio(new BigDecimal(7));
		ruta4.setHoraFin(new BigDecimal(1));
		ruta4.setNumero("P27");
		ruta4.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta4.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta4.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	
		assertFalse(rutasLogic.crearRuta(ruta4));
		
		
	}
	/*
	 * prueba con activa diferente a S o N, por lo tanto falla
	 */
	@Test
	public void crearConActivaDif() {
	
		assertNotNull(rutasLogic);
		
		Tmio1Ruta ruta= new Tmio1Ruta();
		ruta.setActiva("W");
		ruta.setDescripcion("ruta A a B C4");
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
	public void crearConNull() {
	
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
	
	
	
	/*
	 * No quitar comentario
	 */
//	@Test
	public void borrarTest() {
		
		
		assertNotNull(rutasLogic);
		
		assertTrue(rutasLogic.borrarRuta(rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(0)));
		assertTrue(rutasLogic.borrarRuta(rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(0)));
		assertTrue(rutasLogic.borrarRuta(rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(0)));
		assertTrue(rutasLogic.borrarRuta(rutasLogic.buscarRutaRango(new BigDecimal(1),new BigDecimal(7)).get(0)));
		
		
				
	}
	
	@Test
	public void buscarPorRangoDias2Test() {
		
		
		assertNotNull(rutasLogic);
		
		List<Tmio1Ruta> rutas = rutasLogic.buscarRutaRango(new BigDecimal(2), new BigDecimal(7));
		assertNotNull("No existen rutas en este rango de dias", rutas);		
		assertEquals(0, rutas.size());
		}

}
