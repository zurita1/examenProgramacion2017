package examenMayo2017.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * Clase AcercaDe 
 * @author Guillermo Boquizo Sánchez
 * @version 2.0
 */
public class AcercaDe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setModal(true);
		setResizable(false);
		setTitle("Acerca de. Examen Mayo 2017");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);

		JLabel lblCentro = new JLabel("<html>\r\n<p>IES GRAN CAPIT\u00C1N</p>\r\nversi\u00F3n 1.0\r\n</html>");
		lblCentro.setBounds(154, 29, 156, 55);
		contentPanel.add(lblCentro);
		{
			JLabel lblmodulo = new JLabel(
					"<html>\r\n<p>M\u00F3dulo: Programaci\u00F3n</p>\r\n<p>Mayo de 2017</p>\r\n</html>");
			lblmodulo.setBounds(154, 75, 168, 68);
			contentPanel.add(lblmodulo);
		}
		{
			JLabel lblnombre = new JLabel("<html>\r\n<p>Rafael Garcia Zurita</p>\r\n</html>");
			lblnombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblnombre.setBounds(154, 122, 201, 55);
			contentPanel.add(lblnombre);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}