package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;

public class SongAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	public SongAdmin() {
		setResizable(false);
		setFont(new Font("Cooper Black", Font.ITALIC, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage(SongAdmin.class.getResource("/image/LOGO_DONIA.png")));
		setTitle("NEW SONG");
		setBounds(100, 100, 439, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 0, 255), 3, true));
		setContentPane(contentPane);
		
		JTextArea txtrAddHereThe = new JTextArea();
		txtrAddHereThe.setBackground(Color.LIGHT_GRAY);
		txtrAddHereThe.setText("Add here the lyrics!");
		
		JLabel lblLyrics = new JLabel("LYRICS");
		
		JLabel lblSongName = new JLabel("SONG NAME");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblArtistName = new JLabel("ARTIST NAME");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblGenre = new JLabel("GENDER");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblDuration = new JLabel("DURATION");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnDone = new JButton("DONE!");
		btnDone.setBackground(Color.GRAY);
		btnDone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Aqui hay que recoger los datos que se han introducido, comprobarlos y añadirlos a la
				// base de datos
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDuration)
								.addComponent(lblArtistName)
								.addComponent(lblGenre)
								.addComponent(lblSongName)
								.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
									.addComponent(textField_1, 168, 168, 168))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField_3, Alignment.LEADING)
									.addComponent(textField_2, Alignment.LEADING, 168, 168, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDone)
							.addGap(47)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(lblLyrics))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(txtrAddHereThe, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLyrics)
						.addComponent(lblSongName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(lblArtistName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(lblGenre)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(lblDuration)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(btnDone))
						.addComponent(txtrAddHereThe, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE))
					.addGap(175))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
