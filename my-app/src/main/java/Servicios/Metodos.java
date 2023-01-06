package Servicios;
import java.util.*;
import Entidades.Pais;

public class Metodos {

	TreeSet<String> paises = new TreeSet<>();
	Scanner sc = new Scanner(System.in);
	public void menu(){
		do{
		System.out.println("----------Menu----------"
		+"\n (1) Crear Paises"
		+ "\n (2) Borrar Pais"
		+ "\n (3) Mostrar Paises"
		+ "\n (4) Salir");	
		}while(opciones(Integer.parseInt(sc.nextLine())));
	}
	
	public boolean opciones(Integer opcion){
		switch(opcion){
		case 1: crearPais();
		break;
		case 2: borrarPais();
		break;
		case 3: mostrarPaises();
		break;
		case 4: System.out.print("\n Adios :)");
		return false;
		default: System.out.print("Opcion invalida");
		}
		return true;
	}

	public void crearPais() {
		String op = null;
		boolean opc = false;
		do {
			System.out.println("Ingrese un Pais");
			paises.add(sc.nextLine());

			System.out.println("Desea ingresar otro pais? (s/n)");
			do {
				op = sc.nextLine().toLowerCase();
				if (op.equals("s")) {
					opc = true;
				} else if (op.equals("n")) {
					opc = false;
				} else {
					System.out.println("Opcion invalida");
				}
			} while (!op.equals("s") && !op.equals("n"));
			} while (opc);
	}
	
	public void mostrarPaises(){
		System.out.println(paises.toString());
	}
	
	public void borrarPais(){
		System.out.print("indique que pais desea borrar: ");
		String opc = sc.nextLine();
		if(paises.contains(opc)){
			paises.remove(opc);
			System.out.println("Removido con exito");
		}else{
			System.out.println("El pais no se encuentra");
		}
	}

}