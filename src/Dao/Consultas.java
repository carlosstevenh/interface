package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.Conection;
import Modelos.Persona;

public class Consultas {
	protected Connection con;
	protected Statement consulta;
	
	public Consultas() {
		try {
			this.con = Conection.crearConexion();
			consulta= con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean insertarPersona(Persona persona) {
		boolean ban = false;
		String sql = "insert into persona (ide,nom,edad,tel,email) "
				+ "values ('"+persona.identification+"','"+persona.nombre+ "'," 
				+persona.edad+",'"+persona.telefono+ "','"+ persona.email+"');"; 
		try {
			consulta.executeUpdate(sql);
			ban = true;
			System.out.println("Registro exitoso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ban;
	}
	
	public List<Persona> consultarPersonas() {
		String sql = "SELECT * FROM PERSONA";
		List<Persona> personas = new ArrayList<Persona>();
		try {
			ResultSet rs = consulta.executeQuery(sql);
			while(rs.next()) {
				Persona p = new Persona (rs.getString(1),rs.getString(2),Integer.parseInt(rs.getString(3)),rs.getString(4),rs.getString(5));
				personas.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personas;
	}
	
	public void consultarPersona(String ide) {
		String sql = "SELECT * FROM PERSONA WHERE IDE = '"+ ide + "';";
		try {
			ResultSet rs = consulta.executeQuery(sql);
			while(rs.next()) {
				System.out.print("Identificacion: " + rs.getString(1)+ " - ");
				System.out.print("Nombre: " + rs.getString(2)+ " - ");
				System.out.print("Edad: " + rs.getString(3)+ " - ");
				System.out.print("Telefono: " + rs.getString(4)+ " - ");
				System.out.print("Email: " + rs.getString(5));
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean update(List<String> list) {
		boolean ban = false;
		String sql = "update persona set nom = '" + list.get(1) + "', tel = '" + list.get(2) +"', email = ' " + list.get(3) + "' "
				+ "where ide = '" + list.get(0) +"'";
		try {
			consulta.executeUpdate(sql);
			ban = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ban;
	}
	
	public boolean delete(String ide) {
		boolean ban = false;
		String sql = "delete from persona where ide = '" + ide +"';";
		System.out.println(sql);
		try {
			consulta.executeUpdate(sql);
			ban = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ban;
	}
}
