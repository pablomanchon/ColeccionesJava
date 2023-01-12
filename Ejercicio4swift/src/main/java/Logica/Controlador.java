package Logica;

import Persistencia.ControladorPersistencia;

public class Controlador {

    ControladorPersistencia persis = new ControladorPersistencia();

    public void guardar(String nombre, String raza) {
        Perro perro = new Perro(nombre, raza);
        persis.guardar(perro);
    }
}
