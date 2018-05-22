package Vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Clase que se encarga de rellenar el panel con una imagen.
 */
public class PanelImagen extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	
	/**
	 * Constructora. Crea un panel que llevará una imagen pintada en él.
	 * @param url Ruta en al que se encuentra la imagen.
	 */
    public PanelImagen(URL url) {
    	
    	super();
    	String aux1 = url.getPath();
    	try {
    		image = ImageIO.read(new File(aux1));
    	
    	} catch (IOException ex) {}
    }
	/**
	 * Pinta la imagen en el panel.
	 * @param g Gráficos de la imagen.
	 */
    @Override
    protected void paintComponent(Graphics g) {
    	
    	if(image == null)
    		System.out.println("null");
        g.drawImage(image, 0 , 0, this);
    }
}