package Vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{

	
	 private BufferedImage image;

	    public PanelImagen() {
	       try {                
	          image = ImageIO.read(new File("src\\icons\\perfillogo.png"));
	       } catch (IOException ex) {
	            // handle exception...
	       }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 165 ,5, this); // see javadoc for more info on the parameters            
	    }

}

