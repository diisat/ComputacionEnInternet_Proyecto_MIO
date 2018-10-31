package co.edu.icesi.mio.logic;

import java.util.List;

import co.edu.icesi.mio.model.Tmio1Conductore;

public interface ICondutoresLogic {

	public boolean crearConductor(Tmio1Conductore cond);
	public boolean actualizarConductor(Tmio1Conductore cond);
	public boolean borrarConductor(Tmio1Conductore cond);
	
	public List<Tmio1Conductore> buscarConductorNombre(String nombre);
	public Tmio1Conductore buscarConductorCedula(String cedula);
	public List<Tmio1Conductore> buscarConductorApellido(String apellido);


}
