package opciones;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ejemploInterface.VentanaPrincipal;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.Consultas;
import Modelos.Persona;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;

public class Listar extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnGuardar;
	public JTable table;
	public String[] nameColumns = {"Identificacion","nombre","edad","telefono","correo"};
	public String [][] data = {{"as","asd","qw","asda","asd"},{"as","asd","qw","asda","asd"}};
	DefaultTableModel dtm = new DefaultTableModel();
	JScrollPane mibarra1, miBarra2;
	private JTable table_1;
 
	/**
	 * Create the application.
	 */
	public Listar() {
		
		/*Consultas con = new Consultas();
		List<Persona> personas = con.consultarPersonas();
		int contador = 0;
		for (Persona persona : personas) {
			data[contador][0] = persona.identification;
			data[contador][1] = persona.nombre;
			data[contador][2] = persona.edad;
			data[contador][3] = persona.telefono;
			data[contador][4] = persona.email;
			contador++;
		}*/
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnGuardar = new JButton("Regresar");
		btnGuardar.setBounds(160, 222, 97, 25);
		getContentPane().add(btnGuardar);
		
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"zas", "as", "as", "as"},
				{"as", "as", "as", "asas"},
				{null, "as", "as", "asas"},
			},
			new String[] {
				"Edad", "Nombre", "Identificacion", "New column"
			}
		));
		table_1.setBounds(115, 37, 1, 1);
		getContentPane().add(table_1);
		
		btnGuardar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnGuardar) {
			VentanaPrincipal window = new VentanaPrincipal();
			window.setVisible(true);
			dispose();
		}
	}
}
	
