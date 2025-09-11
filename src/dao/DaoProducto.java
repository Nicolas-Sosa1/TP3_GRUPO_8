package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Producto;

public class DaoProducto {
	// Datos conexion
			private String host = "jdbc:mysql://localhost:3306/";
			private String user = "root";
			private String pass = "root";
			private String dbName = "bdinventario";
			
			// ABML
			// Alta sin parametro
			public int AgregarProducto(Producto producto) {
				String query = "Insert into productos(Codigo, Nombre, Precio, Stock, IdCategoria) values ('" + producto.getCodigo() + "','" + producto.getNombre() + "'," +
						producto.getPrecio() + "," + producto.getStock() + "," + producto.getIdCategoria() + ")";
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
			
			// Alta con procedimiento almacenado
			public void AgregarProductoConSP(Producto producto) {
				Connection cn = null;
				try {
					cn = DriverManager.getConnection(host+dbName, user, pass);
					CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto(?,?,?,?,?)");
					cst.setString(1, producto.getCodigo());
					cst.setString(2, producto.getNombre());
					cst.setFloat(3, producto.getPrecio());
					cst.setInt(4, producto.getStock());
					cst.setInt(5, producto.getIdCategoria());
					cst.execute();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
			public int eliminarProducto(Producto producto) {
			    
				String query = "DELETE FROM Productos WHERE Codigo = '" + producto.getCodigo() + "'";
			    
			    Connection cn = null;
			    int filas = 0;
			    
			    try {
			        cn = DriverManager.getConnection(host + dbName, user, pass);
			        Statement st = cn.createStatement();
			        filas = st.executeUpdate(query);
			    }
			    catch(Exception e){
			        e.printStackTrace();
			    }
			    
			    return filas;
			}
			
			
			// Modificacion con parametros
			public int ModificarProducto(Producto producto) {
				String query = "Update productos SET Nombre=?, Precio=?, Stock=?, IdCategoria=? where Codigo=?";
				Connection cn = null;
				int filas = 0;
				
				try {
					cn = DriverManager.getConnection(host+dbName, user, pass);
					PreparedStatement pst = cn.prepareStatement(query);
					pst.setString(1, producto.getNombre());
					pst.setFloat(2, producto.getPrecio());
					pst.setInt(3,  producto.getStock());
					pst.setInt(4, producto.getIdCategoria());
					pst.setString(5, producto.getCodigo());
					filas = pst.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return filas;
			}
			
			public ArrayList<Producto> listarProducto() {
			    ArrayList<Producto> lProductos = new ArrayList<Producto>();
			    Connection cn = null;

			    try {
			        cn = DriverManager.getConnection(host + dbName, user, pass);
			        String query = "SELECT * FROM Productos";
			        Statement st = cn.createStatement();
			        ResultSet rs = st.executeQuery(query);

			        while (rs.next()) {
			            Producto p = new Producto();
			            p.setCodigo(rs.getString("Codigo"));
			            p.setNombre(rs.getString("Nombre"));
			            p.setPrecio(rs.getFloat("Precio"));
			            p.setStock(rs.getInt("Stock"));
			            p.setIdCategoria(rs.getInt("IdCategoria"));

			            lProductos.add(p);
			        }

			    } catch (Exception e) {
			        e.printStackTrace();
			    } 
			    
			    return lProductos;
			}
			
}



