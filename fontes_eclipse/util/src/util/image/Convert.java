package util.image;

/*
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
*/

public class Convert {

	public void toSize(String arquivoOrigem, String arquivoDestino, int width, int height) {

		//float alpha = 1f;
		//BufferedImage biImagem = null;
		//java.awt.image.BufferedImage imagemOriginal = null;
		try {
			//InputStream in = new FileInputStream(arquivoOrigem);
			//imagemOriginal = JPEGCodec.createJPEGDecoder(in).decodeAsBufferedImage();
     		//biImagem = org.imgscalr.Scalr.resize(imagemOriginal,width, height);
			
			// biImagem = new
			// BufferedImage(imagemOriginal.getWidth(),imagemOriginal.getHeight(),
			// BufferedImage.TYPE_INT_ARGB);

			// Graphics2D g2d = bi.createGraphics();
			// Image imagemAlpha = biImagem;

			// g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
			// alpha));
			// g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,3
			// * 0.1f));

			// g2d.drawImage(imagemAlpha, 0, 0, null);
			// g2d.create();
			//ImageIO.write(biImagem, "JPG", new java.io.File(arquivoDestino));

		} catch (Exception e) {
			e.printStackTrace(System.out);

		}
	}


}