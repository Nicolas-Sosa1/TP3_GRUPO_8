package main;
import java.util.ArrayList;

//grupo
import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

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
	
		
		//MODIFICAR CATEGORIA
	    DaoCategoria dao = new DaoCategoria();
	    Categoria categoriaModificar = new Categoria();
	    categoriaModificar.setId(5);            
	    categoriaModificar.setNombre("Vehiculos"); 

	    int filasModificar = dao.modificarCategoria(categoriaModificar);

	    if (filasModificar == 1) {
	        System.out.println("Categoría modificada con éxito");
	    } else {
	        System.out.println("No se pudo modificar la categoría");
	    } 
	    /*
	    //AGREGAR PRODUCTO
		DaoProducto productoDao = new DaoProducto();
		
		Producto producto1 = new Producto();
		producto1.setCodigo("A5");
		producto1.setIdCategoria(3);
		producto1.setNombre("Monitor");
		producto1.setPrecio(200000f);
		producto1.setStock(10);
		
		int filasAgregarProducto = productoDao.AgregarProducto(producto1);
		
		if(filasAgregarProducto == 1) {
			System.out.println("Se agrego con exito el Producto");
		}
		else {
			System.out.println("No se pudo agregar el Producto");
		}
		*/
		// Listar Productos
		
		DaoProducto productoDao = new DaoProducto();
		
		ArrayList<Producto> cargarProductos = new ArrayList<Producto>();
		
		cargarProductos.add(new Producto("1", "Laptop", 120050, 50, 1));
		cargarProductos.add(new Producto("2", "Mouse", 2500, 200, 1 ));
		cargarProductos.add(new Producto("3", "Keyboard", 7599, 150, 2));
		cargarProductos.add(new Producto("4", "Monitor", 35000, 75, 3));
		cargarProductos.add(new Producto("5", "Webcam", 5025, 100, 4));
		cargarProductos.add(new Producto("6", "Printer", 10000, 150, 4));
		cargarProductos.add(new Producto("7", "Headphones", 7000, 80, 1));
		cargarProductos.add(new Producto("8", "Microphone", 5000, 60, 1));
		cargarProductos.add(new Producto("9", "joystick", 4500, 150, 2));
		cargarProductos.add(new Producto("10", "Tablet", 5025, 100, 3));
		
		for (Producto p : cargarProductos) {
		    productoDao.AgregarProducto(p);
		}
		
	    ArrayList<Producto> listaP = productoDao.listarProducto();
	    
	    System.out.println("Cantidad: " + listaP.size());
	    
	    for (Producto c : listaP) {
	       
	    	System.out.println(c); 
	    }
	    
	}
}
