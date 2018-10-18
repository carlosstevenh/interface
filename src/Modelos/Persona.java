package Modelos;

public class Persona {
	public String identification;
	public String nombre;
	public int edad;
	public String telefono;
	public String email;
	
	public Persona(String ide, String nom, int edad, String tel, String email) {
		this.identification = ide;
		this.nombre = nom;
		this.edad = edad;
		this.telefono = tel;
		this.email = email;
	}
	
	public boolean validarEdad() {
		boolean ban = false;
		if(edad>=18) 
			ban = true;
		return ban;
	}
	public void cambiarEdad(int edad) {
		this.edad = edad;
	}
	
}
