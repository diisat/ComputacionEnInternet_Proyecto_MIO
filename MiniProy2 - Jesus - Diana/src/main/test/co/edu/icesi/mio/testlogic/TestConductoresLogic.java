package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.dao.*;
import co.edu.icesi.mio.dao.*;
import co.edu.icesi.mio.logic.ICondutoresLogic;
import co.edu.icesi.mio.logic.Tmio1_Conductores_Logic;
import co.edu.icesi.mio.model.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestConductoresLogic {

	@Autowired
	private ICondutoresLogic conductorLogic;

   @Before
	public void setupEscenario1() {

	   
	   conductorLogic=new Tmio1_Conductores_Logic();
		
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("01");
		conductor.setNombre("Diana");
		conductor.setApellidos("Torres");
		Calendar d = new GregorianCalendar(2018,01,10);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1997,07,22);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Conductore conductor3= new Tmio1Conductore();
		conductor3.setCedula("06");
		conductor3.setNombre("Diana");
		conductor3.setApellidos("Prince");
		Calendar d4 = new GregorianCalendar(2000,03,18);
		conductor3.setFechaContratacion(d4.getTime());
		Calendar d5 = new GregorianCalendar(1960,12,24);
		conductor3.setFechaNacimiento(d5.getTime());
		conductor3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		Tmio1Conductore conductor2= new Tmio1Conductore();
		conductor2.setCedula("02");
		conductor2.setNombre("Jesus");
		conductor2.setApellidos("Pazi");
		Calendar d2 = new GregorianCalendar(2017,07,03);
		conductor2.setFechaContratacion(d2.getTime());
		Calendar d3 = new GregorianCalendar(1998,05,20);
		conductor2.setFechaNacimiento(d3.getTime());
		conductor2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		Tmio1Conductore conductor4= new Tmio1Conductore();
		conductor4.setCedula("10");
		conductor4.setNombre("Valentina");
		conductor4.setApellidos("Tamura");
		Calendar d6 = new GregorianCalendar(2017,02,10);
		conductor4.setFechaContratacion(d6.getTime());
		Calendar d7 = new GregorianCalendar(2000,10,20);
		conductor4.setFechaNacimiento(d7.getTime());
		conductor4.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor4.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Conductore conductor5= new Tmio1Conductore();
		conductor5.setCedula("123");
		conductor5.setNombre("Hillary");
		conductor5.setApellidos("Clinton");
		Calendar d8 = new GregorianCalendar(1950,02,14);
		conductor5.setFechaContratacion(d8.getTime());
		Calendar d9 = new GregorianCalendar(1970,11,10);
		conductor5.setFechaNacimiento(d9.getTime());
		conductor5.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor5.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		Tmio1Conductore conductor6= new Tmio1Conductore();
		conductor6.setCedula("15");
		conductor6.setNombre("Valentina");
		conductor6.setApellidos("Clinton");
		Calendar d10 = new GregorianCalendar(2016,05,02);
		conductor6.setFechaContratacion(d10.getTime());
		Calendar d11 = new GregorianCalendar(1998,05,02);
		conductor6.setFechaNacimiento(d11.getTime());
		conductor6.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor6.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		conductorLogic.crearConductor(conductor);
		conductorLogic.crearConductor(conductor3);
		conductorLogic.crearConductor(conductor2);
		conductorLogic.crearConductor(conductor4);
		conductorLogic.crearConductor(conductor5);
		conductorLogic.crearConductor(conductor6);

		
		
		
	}

   /**
	 * Funciona, crea un conductor con una cedula "89" 
	 */
   @Test
	public void crearTest1() {

		assertNotNull(conductorLogic);
		
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("89");
		conductor.setNombre("Luis");
		conductor.setApellidos("Miguel");
		Calendar d = new GregorianCalendar(2015,07,12);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1989,03,20);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		assertTrue(conductorLogic.crearConductor(conductor));
		
	}
   /**
	 * Funciona, no crea un conductor con una cedula "gehkl" 
	 */
	@Test
	public void crearTest2() {

		assertNotNull(conductorLogic);
		
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("gehkl");
		conductor.setNombre("Marcela");
		conductor.setApellidos("Rodriguez");
		Calendar d = new GregorianCalendar(2017,01,11);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1999,04,24);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		assertFalse(conductorLogic.crearConductor(conductor));
		
	}
	
	
	
	/**
	 * Funciona, no deja crear un conductor con una cedula "" .
	 */
	@Test
	public void crearTest3() {

		assertNotNull(conductorLogic);
		
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("");
		conductor.setNombre("Marcela");
		conductor.setApellidos("Rodriguez");
		Calendar d = new GregorianCalendar(2017,01,11);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1999,04,24);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		assertFalse(conductorLogic.crearConductor(conductor));
		
	}
	
	
	/**
	 * Funciona, no deja crear un conductor misma cedula de un conductor ya creado "7896" .
	 */
	@Test
	public void crearTest4() {

		assertNotNull(conductorLogic);
		
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("7896");
		conductor.setNombre("Mateo");
		conductor.setApellidos("Mar");
		Calendar d = new GregorianCalendar(2017,01,11);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1999,04,24);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Conductore conductor1= new Tmio1Conductore();
		conductor1.setCedula("7896");
		conductor1.setNombre("Marcela");
		conductor1.setApellidos("Rodriguez");
		Calendar d2 = new GregorianCalendar(2017,01,11);
		conductor1.setFechaContratacion(d2.getTime());
		Calendar d4 = new GregorianCalendar(1999,04,24);
		conductor1.setFechaNacimiento(d4.getTime());
		conductor1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		assertTrue(conductorLogic.crearConductor(conductor));
		assertFalse(conductorLogic.crearConductor(conductor1));
		
	}
	
	
	/**
	 * Funciona, no deja crear un conductor con un nombre y apellido 
	 * de menos de tres caracteres. 
	 */
	@Test
	public void crearTest5() {

		assertNotNull(conductorLogic);
		
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("443");
		conductor.setNombre("Da");
		conductor.setApellidos("Ro");
		Calendar d = new GregorianCalendar(2017,01,11);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1999,04,24);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		assertFalse(conductorLogic.crearConductor(conductor));
		
	}

	
	///////////////BUSCAR POR NOMBRE
	/**
	 * Funciona encuentra 2 Valentina para el crearTest1
	 */
	@Test
	public void buscarPorNombreTest1() {

		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorNombre("Valentina");
		assertNotNull(lista);
		assertEquals(2,lista.size());
		
	}

	/**
	 * Funciona encuentra 1 Jesus para el crearTest1
	 */
	@Test
	public void buscarPorNombreTest2() {

		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorNombre("Jesus");
		assertNotNull(lista);
		assertEquals(1,lista.size());
		
		
	}
	
	/**
	 * Funciona, no encuentra a Peter para el crearTest1
	 */
	@Test
	public void buscarPorNombreTest3() {
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorNombre("Peter");
		assertEquals(0,lista.size());
		
	}
	
	/**
	 * Funciona, no encuentra a --- para el crearTest1
	 */
	@Test
	public void buscarPorNombreTest4() {
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorNombre("---");
		assertEquals(0,lista.size());
		
	}
	
	/**
	 * Funciona, no encuentra a "" para el crearTest1
	 */
	@Test
	public void buscarPorNombreTest5() {
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorNombre("");
		assertNull(lista);
		
		
	}
	
	
	////////////////
	
	
	
	/**
	 * Funciona, encuentra la cedula "02", "123", "199"
	 */
	@Test
	public void buscarPorCedulaTest1() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore c =conductorLogic.buscarConductorCedula("02");
		assertNotNull(c);
		assertEquals("02",c.getCedula());
	
		Tmio1Conductore c1 =conductorLogic.buscarConductorCedula("123");
		assertNotNull(c1);
		assertEquals("123",c1.getCedula());
		
		
		Tmio1Conductore c2 =conductorLogic.buscarConductorCedula("199");
		assertNull(c2);
		
		
	}
	
	
	/**
	 * Funciona, no busca la cedula "", porque no es v�lida
	 */
	@Test
	public void buscarPorCedulaTest2() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore c =conductorLogic.buscarConductorCedula("");
		assertNull(c);
		
		
	}
	
	/**
	 * Funciona, no busca la cedula "klj", porque no es v�lida
	 */
	@Test
	public void buscarPorCedulaTest3() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore c1 =conductorLogic.buscarConductorCedula("kjl");
		assertNull(c1);
		
	}
	
	/**
	 * Funciona, no encuentra la cedula "1456", porque no cre� en la base de datos
	 */
	@Test
	public void buscarPorCedulaTest4() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore c =conductorLogic.buscarConductorCedula("1456");
		assertNull(c);
	
	}
	
	/**
	 * Funciona, no busca la cedula "45f87exaDD", porque no es v�lida
	 */
	@Test
	public void buscarPorCedulaTest5() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore c =conductorLogic.buscarConductorCedula("45f87exaDD");
		assertNull(c);
		
		
	}

	////////////////////////////
	
	
	/**
	 * Funciona, encuentra los apellidos "Tamura" y "Clinton"
	 */
	@Test
	public void buscarPorApellidoTest1() {
		
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorApellido("Clinton");
		assertNotNull(lista);
		assertEquals(2,lista.size());
		
		List<Tmio1Conductore> lista2 =conductorLogic.buscarConductorApellido("Tamura");
		assertNotNull(lista2);
		assertEquals(1,lista2.size());
		
	}
	
	
	/**
	 * Funciona, no encuentra los apellidos "Fernandez" y "Moreno"
	 */
	@Test
	public void buscarPorApellidoTest2() {
		
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorApellido("Fernandez");
		assertEquals(0,lista.size());
		
		
		List<Tmio1Conductore> lista2 =conductorLogic.buscarConductorApellido("Moreno");
		assertEquals(0,lista2.size());
		
		
	}
	
	/**
	 * Funciona, no encuentra los apellidos "" .
	 */
	@Test
	public void buscarPorApellidoTest3() {
		
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorApellido("");
		assertNull(lista);
		
	}
	
	/**
	 * Funciona, no encuentra los apellidos "12jjf" porque no son v�lidos
	 */
	@Test
	public void buscarPorApellidoTest4() {
		
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorApellido("12jjf");
		assertEquals(0,lista.size());
		
	}
	
	/**
	 * Funciona, no encuentra los apellidos "di" ni "hw" 
	 * por que tienen menos de tres caracteres
	 * por tanto no se guardaron
	 */
	@Test
	public void buscarPorApellidoTest5() {
		
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorApellido("di");
		assertEquals(0,lista.size());
		
		List<Tmio1Conductore> lista2 =conductorLogic.buscarConductorApellido("hw");
		assertEquals(0,lista2.size());
		
	}
	
	////////////ACTUALIZAR TEST
	
	
	/**
	 * Funciona, actualiza el conductor ced "01" llamado Diana a Rondal macdonald
	 */
	@Test
	public void actualizarTest1() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore conductor= conductorLogic.buscarConductorCedula("01");
		conductor.setNombre("RONALD");
		conductor.setApellidos("MACDONALD'S");
		Calendar d1 = new GregorianCalendar(1950,10,28);
		conductor.setFechaNacimiento(d1.getTime());
		
		assertTrue(conductorLogic.actualizarConductor(conductor));
		
	}
	
	
	/**
	 * Funciona, no actualiza el conductor "1478" porque no existe en la base de datos 
	 */
	@Test
	public void actualizarTest2() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore conductor= conductorLogic.buscarConductorCedula("1478");
		if(conductor!=null) conductor.setNombre("a");
		
		assertFalse(conductorLogic.actualizarConductor(conductor));
		
	}
	
	/**
	 * Funciona, no actualiza el conductor "" porque no existe en la base de datos 
	 */
	@Test
	public void actualizarTest3() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore conductor= conductorLogic.buscarConductorCedula("");
		assertFalse(conductorLogic.actualizarConductor(conductor));
		
	}
	
	/**
	 * Funciona, actualiza el conductor "01" que se hab�a actualizado en actualizarTest1
	 */
	@Test
	public void actualizarTest4() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore conductor= conductorLogic.buscarConductorCedula("01");
		conductor.setNombre("TommY");
		
		assertTrue(conductorLogic.actualizarConductor(conductor));
		
	}
	
	
	/**
	 * Funciona, no actualiza el conductor "123"
	 */
	@Test
	public void actualizarTest5() {
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore conductor= conductorLogic.buscarConductorCedula("123");

		assertTrue(conductorLogic.actualizarConductor(conductor));
		
	}
	
	
	
	///////////////BORRAR TEST

	/**
	 * Funciona, elimina todas los conductores creados en el test1
	 */
	@Test
	public void borrarTest1() {
		
		assertNotNull(conductorLogic);

		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("01")));
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("02")));
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("06")));
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("10")));
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("123")));
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("15")));
		
				
	}
	
	public void setupEscenario2() {
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("03");
		conductor.setNombre("Juan");
		conductor.setApellidos("Reyes");
		Calendar d = new GregorianCalendar(2017,02,10);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1996,04,21);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Conductore conductor3= new Tmio1Conductore();
		conductor3.setCedula("111");
		conductor3.setNombre("Stephany");
		conductor3.setApellidos("Nieto");
		Calendar d4 = new GregorianCalendar(2004,10,20);
		conductor3.setFechaContratacion(d4.getTime());
		Calendar d5 = new GregorianCalendar(1950,11,22);
		conductor3.setFechaNacimiento(d5.getTime());
		conductor3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		Tmio1Conductore conductor2= new Tmio1Conductore();
		conductor2.setCedula("08");
		conductor2.setNombre("Manuel");
		conductor2.setApellidos("Jimenez");
		Calendar d2 = new GregorianCalendar(2017,07,03);
		conductor2.setFechaContratacion(d2.getTime());
		Calendar d3 = new GregorianCalendar(1998,05,20);
		conductor2.setFechaNacimiento(d3.getTime());
		conductor2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		conductorLogic.crearConductor(conductor);
		conductorLogic.crearConductor(conductor2);
		conductorLogic.crearConductor(conductor3);
		
	}
	
	
	/**
	 * Funciona, elimina los conductores "03" y "08" del escenario2
	 */
	@Test
	public void borrarTest2() {
		setupEscenario2();
		
		assertNotNull(conductorLogic);

		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("03")));
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("08")));
		
				
	}
	
	
	
	/**
	 * Funciona, no elimina  el conductor "03" porque no existe , se elimino en
	 * el borrartest2
	 */
	@Test
	public void borrarTest3() {
		
		
		assertNotNull(conductorLogic);
		assertFalse(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("03")));
				
	}
	
	
	/**
	 * Funciona, no elimina el conductor "3940" porque no existe y nunca se ha agregado
	 */
	@Test
	public void borrarTest4() {
		
		assertNotNull(conductorLogic);
		assertFalse(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("3940")));
		
				
	}
	
	
	
	/**
	 * Funciona, no elimina el conductor con cedula "" porque no es v�lido
	 */
	@Test
	public void borrarTest5() {
		
		assertNotNull(conductorLogic);


		assertFalse(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("")));

				
	}
	
	
	

}
