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

    public PanelImagen(String cual) {
	    	super();
	    	try {
	    		image = ImageIO.read(new File(cual));
	    	
	    	} catch (IOException ex) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
    	if(image == null)
    		System.out.println("null");
        g.drawImage(image, 0 , 0, this); // 165
    }
}