package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Servicio;

public interface IServiciosLogic {

	
	public boolean actualizarServicio(Tmio1Servicio servicio);
	public boolean crearServicio(Tmio1Servicio servicio);
	public boolean borrarServicio(Tmio1Servicio servicio);
	public List<Tmio1Servicio> buscarServicioRangoFechas(Calendar fechaInicio, Calendar fechaFin );
	
}
