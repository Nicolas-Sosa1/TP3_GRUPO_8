package main;
import java.util.ArrayList;

//grupo
import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {
	
	public static void main(String[] args) {
		
		/*
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
	    */
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
		/*
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
	    */
	    // MODIFICAR UN PRODUCTO
		// Agrego unas categorias para probar modificacion
		
		DaoCategoria daoCat = new DaoCategoria();		
		
		Categoria cat1 = new Categoria();
		cat1.setNombre("Electronica");
		daoCat.AgregarCategoria(cat1);
		
		Categoria cat2 = new Categoria();
		cat2.setNombre("Hogar");
		daoCat.AgregarCategoria(cat2);
		
		Categoria cat3 = new Categoria();
		cat3.setNombre("Ropa");
		daoCat.AgregarCategoria(cat3);
		
		Categoria cat4 = new Categoria();
		cat4.setNombre("Alimentos");
		daoCat.AgregarCategoria(cat4);
			
		// Creo 10 productos y lo agregos para modificar
		
		DaoProducto daoPr = new DaoProducto();
		
	    Producto pr1 = new Producto("P1", "Samsung A54", 250000, 10, 1);
	    Producto pr2 = new Producto("P2", "Televisor 50", 350000, 4, 1);
	    Producto pr3 = new Producto("P3", "Notebook Lenovo", 300000, 6, 1);
	    Producto pr4 = new Producto("P4", "Cocina", 260000, 9, 2);
	    Producto pr5 = new Producto("P5", "Zapatillas Nike", 180000, 20, 3);
	    
	    Producto pr6 = new Producto("P6", "Camiseta Adidas", 100000, 22, 3);
	    Producto pr7 = new Producto("P7", "Heladera", 400000, 4, 2);
	    Producto pr8 = new Producto("P8", "Paquete fideos", 1200, 100, 4);
	    Producto pr9 = new Producto("P9", "Yogurt", 2200, 20, 4);
	    Producto pr10 = new Producto("P10", "Cama 2 plazas", 170000, 4, 2);
	    
	    daoPr.AgregarProductoConSP(pr1);
	    daoPr.AgregarProductoConSP(pr2);
	    daoPr.AgregarProductoConSP(pr3);
	    daoPr.AgregarProductoConSP(pr4);
	    daoPr.AgregarProductoConSP(pr5);
	    
	    daoPr.AgregarProductoConSP(pr6);
	    daoPr.AgregarProductoConSP(pr7);
	    daoPr.AgregarProductoConSP(pr8);
	    daoPr.AgregarProductoConSP(pr9);
	    daoPr.AgregarProductoConSP(pr10);
	    
	 	// Listado de recien agregados/modificados
	 	ArrayList<Producto> lProductos = daoPr.listarProducto();
	 	System.out.println("Lista de todos los productos:");
	 	for(Producto pr : lProductos) {
	 		System.out.println(pr);
	 	}
	 	
	 	Producto prM1 = new Producto("P1", "Samsung S10", 300000, 4, 2);
	 	Producto prM2 = new Producto("P5", "Zapatillas Vans", 200000, 8, 2);
	 	Producto prM3 = new Producto("P8", "Queso cremoso", 4000, 20, 3);
	 	
	 	daoPr.ModificarProducto(prM1);
	 	daoPr.ModificarProducto(prM2);
	 	daoPr.ModificarProducto(prM3);
	 	
	 	
	    
	    
	}
}
