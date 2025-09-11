package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entidad.Categoria;

public class DaoCategoria {
	
	// Datos conexion
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	// ABML

	public int AgregarCategoria(Categoria categoria) {
		String query = "Insert into categorias(Nombre) values ('" + categoria.getNombre() + "')";
		Connection cn = null;
		int filas = 0;
		
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	
	
	
	public int eliminarCategoria(Categoria categoria) {
		
		String query = "DELETE FROM Categorias WHERE IdCategoria = "+ categoria.getId();	
		Connection cn = null;
		
		int filas = 0;
		
		try {			
			cn = DriverManager.getConnection(host+dbName,user,pass);
	        Statement st = cn.createStatement();
	        filas = st.executeUpdate(query); 
		}
		catch(Exception e){
			e.printStackTrace();	
		}
		
		return filas;
			
	}
		

	public int modificarCategoria(Categoria categoria) {
		String query = "UPDATE Categorias SET Nombre = ?, IdCategoria = ? WHERE IdCategoria = ?";		
		Connection cn = null;
		
		int filas = 0;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement pS = cn.prepareStatement(query);
			pS.setString(1, categoria.getNombre());
			pS.setInt(2, categoria.getId());
			pS.setInt(3, categoria.getId());
			pS.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	
	public ArrayList<Categoria> listarCategorias(Categoria categoria) {
		
		ArrayList<Categoria> lCategorias = new ArrayList<Categoria>();
		
		String query = "SELECT * FROM Categorias";
		Connection cn = null;

		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			
			Statement st = cn.createStatement();
			ResultSet rS = st.executeQuery(query);

			while (rS.next()) 
			{
				Categoria cat = new Categoria();
				cat.setId(rS.getInt("IdCategoria"));
	            cat.setNombre(rS.getString("Nombre"));
	            lCategorias.add(cat);
	            
	            System.out.println("ID: " + cat.getId() + ", Nombre: " + cat.getNombre());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return lCategorias;
	}
	
}
