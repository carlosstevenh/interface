package opciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Dao.Consultas;
import Modelos.Persona;
import ejemploInterface.VentanaPrincipal;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Agregar extends JFrame implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textName,textEdad,textTel,textEmail;
	private JTextField textIde;
	private JButton btnRegistrar;

	/**
	 * Create the application.
	 */
	public Agregar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblRegistrarPersona = new JLabel("Registrar persona");
		lblRegistrarPersona.setBounds(0, 0, 440, 18);
		lblRegistrarPersona.setFont(new Font("Droid Sans", Font.BOLD, 15));
		lblRegistrarPersona.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblRegistrarPersona);
		
		JLabel lblIdentificacin = new JLabel("Identificación");
		lblIdentificacin.setBounds(74, 56, 108, 18);
		getContentPane().add(lblIdentificacin);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(74, 86, 66, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(74, 113, 66, 15);
		getContentPane().add(lblEdad);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(74, 140, 66, 15);
		getContentPane().add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(74, 167, 66, 15);
		getContentPane().add(lblCorreo);
		
		textIde = new JTextField();
		textIde.setBounds(189, 56, 161, 19);
		getContentPane().add(textIde);
		textIde.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(189, 86, 161, 19);
		getContentPane().add(textName);
		textName.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setBounds(189, 113, 161, 19);
		getContentPane().add(textEdad);
		textEdad.setColumns(10);
		
		textTel = new JTextField();
		textTel.setBounds(189, 140, 161, 19);
		getContentPane().add(textTel);
		textTel.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(189, 167, 161, 19);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(173, 209, 114, 25);
		getContentPane().add(btnRegistrar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnRegistrar) {
			String ide = textIde.getText();
			String name = textName.getText();
			String edad = textEdad.getText();
			String tel = textTel.getText();
			String email = textEmail.getText();
			
			if(!ide.isEmpty()&&!name.isEmpty()&&!edad.isEmpty()&&!tel.isEmpty()&&!email.isEmpty()) {
				Persona persona = new Persona(ide,name,Integer.parseInt(edad),tel,email);
				Consultas con = new Consultas();
				boolean ban = con.insertarPersona(persona);
				if(ban) {
					JOptionPane.showMessageDialog(null, "Registro de persona exitoso");
					VentanaPrincipal window = new VentanaPrincipal();
					window.setVisible(true);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Registro fallido");
			}
			else
				JOptionPane.showMessageDialog(null,"Por favor todos los campos son obligatorios");
		}
		
	}
}
