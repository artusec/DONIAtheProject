package Vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JEditorPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;

public class SongAdmin_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public SongAdmin_panel() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "NUEVA CANCION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "LETRA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JEditorPane txtrEscribeAquLa = new JEditorPane();
		txtrEscribeAquLa.setText("Escribe aquí la letra");
		setLayout(new GridLayout(0, 2, 0, 0));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{199, 0};
		gbl_panel.rowHeights = new int[]{34, 16, 26, 16, 26, 16, 26, 26, 29, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNombreDeLa = new JLabel("NOMBRE DE LA CANCIÓN");
		GridBagConstraints gbc_lblNombreDeLa = new GridBagConstraints();
		gbc_lblNombreDeLa.anchor = GridBagConstraints.NORTH;
		gbc_lblNombreDeLa.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombreDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreDeLa.gridx = 0;
		gbc_lblNombreDeLa.gridy = 1;
		panel.add(lblNombreDeLa, gbc_lblNombreDeLa);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		
		JLabel lblNombreDelArtista = new JLabel("NOMBRE DEL ARTISTA");
		GridBagConstraints gbc_lblNombreDelArtista = new GridBagConstraints();
		gbc_lblNombreDelArtista.anchor = GridBagConstraints.NORTH;
		gbc_lblNombreDelArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombreDelArtista.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreDelArtista.gridx = 0;
		gbc_lblNombreDelArtista.gridy = 3;
		panel.add(lblNombreDelArtista, gbc_lblNombreDelArtista);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		
		JLabel lblGnero = new JLabel("GÉNERO");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.NORTH;
		gbc_lblGnero.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 0);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 5;
		panel.add(lblGnero, gbc_lblGnero);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 6;
		panel.add(textField_3, gbc_textField_3);
		
		JLabel lblDuracin = new JLabel("DURACIÓN");
		GridBagConstraints gbc_lblDuracin = new GridBagConstraints();
		gbc_lblDuracin.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDuracin.insets = new Insets(0, 0, 5, 0);
		gbc_lblDuracin.gridx = 0;
		gbc_lblDuracin.gridy = 7;
		panel.add(lblDuracin, gbc_lblDuracin);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 8;
		panel.add(textField_2, gbc_textField_2);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 9;
		panel.add(separator, gbc_separator);
		
		JButton btnHecho = new JButton("HECHO");
		GridBagConstraints gbc_btnHecho = new GridBagConstraints();
		gbc_btnHecho.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHecho.anchor = GridBagConstraints.NORTH;
		gbc_btnHecho.gridx = 0;
		gbc_btnHecho.gridy = 11;
		panel.add(btnHecho, gbc_btnHecho);
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(txtrEscribeAquLa);

	}
}
