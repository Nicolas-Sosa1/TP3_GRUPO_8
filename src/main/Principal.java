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
		
		//BAJA CATEGORIA
		Categoria categoriaEliminar = new Categoria();
		categoriaEliminar.setId(9);

		int filasEliminar = DaoCategoria.eliminarCategoria(categoriaEliminar);

		if (filasEliminar == 1) {
		    System.out.println("Categoría eliminada: ID " + categoriaEliminar.getId());
		} else {
		    System.out.println("No se pudo eliminar la categoría");
		} 

		//LISTAR CATEGORIA
		Categoria categoriaListar = new Categoria();
		DaoCategoria.listarCategorias(categoriaListar);
	}
}
