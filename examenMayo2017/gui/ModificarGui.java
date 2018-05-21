package examenMayo2017.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examenMayo2017.funcionalidad.General;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

public class ModificarGui extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void enlazar(LocalDate localDate) {
		try {
			ModificarGui dialog = new ModificarGui(localDate);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param localDate
	 */
	public ModificarGui(LocalDate localDate) {
		setModal(true);
		setTitle("Modificar");
		setResizable(false);
		setBounds(100, 100, 450, 154);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JSpinner spinner_Fecha = new JSpinner();
		spinner_Fecha.setModel(new SpinnerDateModel(java.sql.Date.valueOf(localDate), null, null, Calendar.MONTH));
		spinner_Fecha.setEditor(new JSpinner.DateEditor(spinner_Fecha, "dd 'de' MMMM 'de' yyyy', 'EEEE"));

		spinner_Fecha.setBounds(81, 41, 224, 40);
		contentPanel.add(spinner_Fecha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						okModificar(spinner_Fecha);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void okModificar(JSpinner jSpinner) {
		LocalDate localDate = ((Date) jSpinner.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
		General.setLocalDate(localDate);
		General.setModificado(true);
		setVisible(false);
		dispose();
	}
}