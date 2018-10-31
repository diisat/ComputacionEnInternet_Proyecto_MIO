package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Bus;

public interface IBusesLogic {

	public boolean crearBus(Tmio1Bus bus);
	public boolean actualizarBus(Tmio1Bus bus);
	public boolean borrarBus(Tmio1Bus bus);
	public List<Tmio1Bus> buscarBusModelo(BigDecimal modelo);
	public List<Tmio1Bus> buscarBusTipo(String tipo);
	public List<Tmio1Bus> buscarBusCapacidad(BigDecimal capacidad);
	public Tmio1Bus buscarPlaca(String placa);
}
