/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaTuMascota.com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author su nombre aqui
 */
public class BuscaTuMascotaCom {

public BuscaTuMascotaCom() {
	
}

private List<Mascota> mascotas = new ArrayList<>();
private List<Dueno> duenos = new ArrayList<>();
/**
 * TODO: Anadir una nueva mascota a la lista de mascotas
 * @param mascota 
 */
public void anadirMascota(Mascota mascota){
	mascotas.add(mascota);
    
}
/**
 * TODO: Anadir un nuevo dueno a la lista de duenos
 * @param dueno 
 */
public void anadirDueno(Dueno dueno){
	duenos.add(dueno);
    
}

public Dueno consultarDueno(String cedula) {
	return duenos.stream().filter(e -> e.getcedula().equals(cedula))
		.findAny()
		.orElse(null);

}

public List<Mascota> consultarMascota(Dueno dueno) {
	return mascotas.stream().filter(e -> e.getdueno().equals(dueno))
		.collect(Collectors.toList());
}

public Mascota consultarMascota(int codigo) {
	return mascotas.stream().filter(e -> e.getcodigo() == codigo)
		.findAny()
		.orElse(null);
}

public List<Mascota> consultarMascota(String raza) {
	List<Mascota> result = new ArrayList<>();
	for(Mascota m: mascotas){
		if(m.getraza().equals(raza)){
			result.add(m);
			
		}
		
	}
	return result;
}
//	  return mascotas.stream().filter(e -> e.getraza().equals(raza))
//		.collect(Collectors.toList());



}














