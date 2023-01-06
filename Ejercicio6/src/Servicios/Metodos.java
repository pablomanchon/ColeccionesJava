package Servicios;

/*6. Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
        productos que venderemos y el precio que tendrán. Además, se necesita que la
        aplicación cuente con las funciones básicas.
        Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
        eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
        Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
        Realizar un menú para lograr todas las acciones previamente mencionadas.*/

import Entidades.Producto;

import java.util.HashMap;
import java.util.Scanner;

public class Metodos {
    HashMap<String, Integer> productos = new HashMap<String, Integer>();
    Scanner sc = new Scanner(System.in);

    private void agregarProductos() {
        do {
            Producto producto = new Producto();

            System.out.print("Nombre del producto: ");
            producto.setNombre(sc.next());

            System.out.print("Precio del producto: ");
            producto.setPrecio(sc.nextInt());

            productos.put(producto.getNombre(), producto.getPrecio());

        } while (continuar());

    }

    public void menu() {
        do {
            System.out.println("__________MENU__________" +
                    "\n(1) Agregar Productos" +
                    "\n(2) Remover Productos" +
                    "\n(3) Modificar Precio" +
                    "\n(4) Mostrar Productos" +
                    "\n(5) Salir");
        } while (continuarMenu());

    }

    private boolean continuarMenu() {
        do {
            Integer opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarProductos();
                    return true;
                case 2:
                    if (mapLleno()) {
                        removerProductos();
                        return true;
                    }
                    break;
                case 3:
                    if (mapLleno()) {
                        modificarPrecio();
                        return true;
                    }
                    break;
                case 4:
                    if (mapLleno()) {
                        System.out.println(mostrarProductos());
                    }
                    break;
                case 5:
                    System.out.println("adios :)");
                    return false;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (true);
    }

    private boolean mapLleno() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos! Escoja otra opcion");
        }
        return productos.isEmpty() ? false : true;
    }

    private void removerProductos() {

        System.out.println("____Remover Producto____");
        do {
            String producto = encontrarProducto();
            if (productos.containsKey(producto)) {

                productos.remove(producto);
                System.out.println("¡Producto removido con éxito!");

            } else
                System.out.println("El producto no se encuentra");

        } while (continuar());
    }

    private void modificarPrecio() {
        System.out.println("____Modificar Precio____");
        do {
            String producto = encontrarProducto();

            System.out.print("Ingresar nuevo precio: ");
            Integer precio = sc.nextInt();

            productos.replace(producto, productos.get(producto), precio);
            //otra forma: productos.replace(producto, precio);

        } while (continuar());
    }

    private String encontrarProducto() {
        String producto;
        boolean productoNoEncontrado; //<- éste boolean sirve para que el codigo sea mas legible
        do {
            System.out.println("¿Que producto?");
            producto = sc.next();

            productoNoEncontrado = !productos.containsKey(producto);

            if (productoNoEncontrado) {
                System.out.println("El producto no se encuentra");
            }
        } while (productoNoEncontrado);
        return producto;
    }

    private String mostrarProductos() {
        return productos.toString();
    }

    private boolean continuar() {
        System.out.println("¿Desea repetir la operacion? (s/n)");
        do {
            String opcion = sc.next().toLowerCase();
            if (opcion.equals("s")) {
                return true;
            } else if (opcion.equals("n")) {
                return false;
            } else {
                System.out.println("La opcion es incorrecta");
            }
        } while (true); //<- De ésta forma hacemos que el bucle sea infinito
        // hasta que entre en uno de los returns del If

    }

}
