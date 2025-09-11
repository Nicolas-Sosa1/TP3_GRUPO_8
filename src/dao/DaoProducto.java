package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
}
