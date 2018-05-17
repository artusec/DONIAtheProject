package Vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Model.Objetos.Cancion;

import javax.swing.JButton;

public class Enlaces_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Enlaces_panel() {
		
		JLabel lblEnlaceVerVideo = new JLabel("Ver video");
		lblEnlaceVerVideo.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("Enlace descarga");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_1, Alignment.TRAILING)
						.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(177, Short.MAX_VALUE)
					.addComponent(lblEnlaceVerVideo)
					.addGap(174))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(131))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblEnlaceVerVideo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(btnVolver)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		setVisible(false);

	}
	
	public void setDatos(Cancion cancion) {
		
		this.textField.setText(cancion.getVideo().getEnlace());
		this.textField_1.setText(cancion.getVideo().getEnlaceDescarga());
	}
}
