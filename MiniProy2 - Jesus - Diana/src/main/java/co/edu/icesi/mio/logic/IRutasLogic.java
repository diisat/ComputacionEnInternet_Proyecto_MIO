package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface IRutasLogic {

	public boolean crearRuta(Tmio1Ruta ruta);
	public boolean actualizarRuta(Tmio1Ruta ruta);
	public boolean borrarRuta(Tmio1Ruta ruta);
	public List<Tmio1Ruta> buscarRutaRango(BigDecimal diaInicio, BigDecimal diaFin);
}
