package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagemTela  extends JPanel {  
	    BufferedImage img1, img2;  
	  
	    public ImagemTela(String url) {  
	        Dimension d = new Dimension(300, 300);  
	        setPreferredSize(d);  
	        setMaximumSize(d);  
	        setMinimumSize(d);  
	        setSize(d);  
	        try {  
	            img1 = ImageIO.read(new File(url));  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    @Override  
	    public void paintComponent(Graphics g) {  
	        Graphics2D g2d = (Graphics2D) g.create();  
	        g2d.drawImage(img1, 0, 0, this);  
	        g2d.dispose();  
	    }	   
}
