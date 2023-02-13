package util.image;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imaging {

	public static void paint() throws IOException {
		int width = 1;
		int height = 1;
		float alpha = 1f;
		BufferedImage bi2 = ImageIO.read(new File("c:/teste/map.png"));
		width = bi2.getWidth();
		height = bi2.getHeight();
		BufferedImage bi = new BufferedImage(width, height,	BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = bi.createGraphics();

		Image castle = new ImageIcon("c:/teste/map.png").getImage();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1 * 0.1f));
		g2d.drawImage(castle, 0, 0, null);
		g2d.create();

		ImageIO.write(bi, "PNG", new java.io.File("c:/teste/bosta.png"));

		// g2d.
		// ImageIO.write(ImageIO.read(new java.io.File("C:/teste/map.png")),
		// "PNG", new java.io.File("c:\\yourImageName.PNG"));

	}

	public static void main(String[] args) {

		try {
			paint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 * package com.zetcode;
 * 
 * 
 * import java.awt.AlphaComposite; import java.awt.Color; import
 * java.awt.Graphics; import java.awt.Graphics2D; import javax.swing.JFrame;
 * import javax.swing.JPanel;
 * 
 * 
 * public class TransparentRectangles extends JPanel {
 * 
 * 
 * public void paint(Graphics g) { super.paint(g);
 * 
 * Graphics2D g2d = (Graphics2D)g; g2d.setColor(Color.BLUE);
 * 
 * 
 * for (int i = 1; i <= 10; i++) {
 * g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i *
 * 0.1f)); g2d.fillRect(50 * i, 20, 40, 40); } }
 * 
 * 
 * public static void main(String[] args) {
 * 
 * JFrame frame = new JFrame("Transparent Rectangles"); frame.add(new
 * TransparentRectangles());
 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(590,
 * 120); frame.setLocationRelativeTo(null); frame.setVisible(true); } }
 */