package Servicios;

import Entidades.Perro;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);
    ArrayList<Perro> perros = new ArrayList<Perro>();

    public void menu() {
        do {
            System.out.println("----------Menu----------" +
                    "\n(1) Crear perro" +
                    "\n(2) Borrar perro" +
                    "\n(3) Mostrar perros" +
                    "\n(4) Salir");
        } while (opciones(Integer.parseInt(sc.nextLine())));

    }

    public boolean opciones(Integer opcion) {
        switch (opcion) {
            case 1:
                crearPerro();
                break;
            case 2:
                borrarPerro();
                break;
            case 3:
                mostrarPerros();
                break;
            case 4:
                return false;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
        return true;
    }

    private void crearPerro() {
        do {
            String nombre, raza;
            System.out.println("Nombre del perro");
            nombre = sc.nextLine();
            System.out.println("Raza del perro: ");
            raza = sc.nextLine();
            Perro perro = new Perro(nombre, raza);
            perros.add(perro);
            System.out.println("¿Desea agregar otro Perro? (s/n)");
        } while (continuar());
    }


    private boolean continuar() {
        do {
            String opcion = sc.nextLine().toLowerCase();
            switch (opcion) {
                case "s":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentarlo");
            }
        } while (true);
    }

    private void borrarPerro() {
        do {
            System.out.println("Ingrese el nombre del perro que desea borrar: ");
            String nombre = sc.nextLine();
            boolean encontrado = false;
            for (int i = 0; i < perros.size(); i++) {
                if (perros.get(i).getNombre().equals(nombre)){
                    perros.remove(i);
                    System.out.println("Perro removido con exito");
                    encontrado = true;
                }
            }
            if (!encontrado)
                System.out.println("El perro no se encuentra en la lista");
            System.out.println("Desea quitar otro perro? (s/n)");
        } while (continuar());


    }

    private void mostrarPerros() {
        System.out.println("----------Lista de perros----------\n" +
                perros);
    }

}

