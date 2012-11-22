package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;

public class RayTracer extends Canvas {

	private static final long serialVersionUID = 5555522598959749695L;

	// our variables can be changed therefore are not static
	protected BufferedImage img;
	protected int width;
	protected int height;
	protected World world;

	public RayTracer(int width, int height, World world) {
		this.world = world;
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(final Graphics g) {
		// erzeugt ein neues BufferedImage mit dem Farbtyp INT RGB
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				// setzt einen Punkt des Rasters mit den Koordinaten x,x auf die
				// angegebene Farbe
				img.getRaster()
						.setDataElements(
								x,
								y,
								img.getColorModel().getDataElements(
										(int) (world.hit(new Ray(new Point3(0,
												1, 0), new Vector3(-0.33,
												-0.66, -0.69))).b * 13944082), null));
			}
		}

		g.drawImage(img, 0, 0, null);
	}

	@Override
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the image. Redraws the {@link ImageCanvas} for the
	 * changes to show.
	 * 
	 * @param width
	 *            the width of the image.
	 */
	public void setWidth(final int width) {
		this.width = width;
		repaint();
	}

	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the image. Redraws the {@link ImageCanvas} for the
	 * changes to show.
	 * 
	 * @param height
	 *            the height of the image.
	 */
	public void setHeight(final int height) {
		this.height = height;
		repaint();
	}

	/**
	 * Gets the BufferedImage in the {@link ImageCanvas}.
	 * 
	 * @return the {@link BufferedImage} in the {@link ImageCanvas}.
	 */
	public BufferedImage getImage() {
		return img;
	}

}