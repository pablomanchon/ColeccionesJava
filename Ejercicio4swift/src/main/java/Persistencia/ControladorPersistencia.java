package Persistencia;

import Logica.Perro;

public class ControladorPersistencia {
    PerroJpaController perroJpa = new PerroJpaController();

    public void guardar(Perro perro) {
        perroJpa.create(perro);
    }
}
