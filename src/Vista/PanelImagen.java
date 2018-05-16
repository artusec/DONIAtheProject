package Vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{


	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;

    public PanelImagen(boolean cual) {
	    	super();
	    	try {
	    		if(cual)
	    		   image = ImageIO.read(new File("src/icons/perfillogo.png"));
	    		else
	    		   image = ImageIO.read(new File("src/icons/LOGO_DONIA_pequeno.png"));
	    	} catch (IOException ex) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0 , 0, this); // 165
    }
}