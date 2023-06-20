package org.lowcode.utils;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static Image monochrome(BufferedImage image, Color color) {
		try {
			File f = new File("C:\\Users\\bigoh\\Pictures\\pz.jpg");
			if (!f.exists())
				return null;
			if (!f.canRead())
				System.out.println(f.getAbsoluteFile());
			
			BufferedImage bi = ImageIO.read(f);
			for (int i = 0; i < bi.getHeight(); i++)
				for (int j = 0; j < bi.getWidth();j++) {
					//if (bi.getRGB(i, j) == Color.WHITE.getRGB())
						//System.out.println(bi.getRGB(i, j));
						//System.out.println(Color.RED.getRGB());
						bi.setRGB(i, j, bi.getRGB(i, j) + 50_000);
				}
			ImageIO.write(bi, "png",new File("C:\\Users\\bigoh\\Pictures\\px.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
