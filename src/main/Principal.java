package main;

import dao.DaoCategoria;
import entidad.Categoria;

public class Principal {
	
	public static void main(String[] args) {
		
		DaoCategoria DaoCategoria = new DaoCategoria();
		Categoria categoria = new Categoria("categoria ejemplo");
		
		int filas = DaoCategoria.AgregarCategoria(categoria);
		if(filas == 1) {
			System.out.println("Nueva categoria: " + categoria.getNombre());
		} else {
			System.out.println("No se pudo agregar una nueva categoria");
		}
		
		
	}
}
