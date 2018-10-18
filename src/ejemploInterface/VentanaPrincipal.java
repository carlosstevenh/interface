package ejemploInterface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import opciones.Agregar;
import opciones.Listar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar menuBar ;
	JMenuItem mntmInsertar;
	JMenuItem mntmListar;

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		menuBar = new JMenuBar();
		getContentPane().add(menuBar);
		
		mntmInsertar = new JMenuItem("Insertar");
		menuBar.add(mntmInsertar);
		mntmInsertar.addActionListener(this);
		
		mntmListar = new JMenuItem("Listar");
		menuBar.add(mntmListar);
		mntmListar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mntmInsertar) {
			Agregar window = new Agregar();
			window.setVisible(true);
			dispose();
		}
			//JOptionPane.showMessageDialog(null, "Insertar");
		if(e.getSource()==mntmListar) {
			Listar window = new Listar();
			window.setVisible(true);
			dispose();
		}
			//JOptionPane.showMessageDialog(null, "Listar");
	}
}
