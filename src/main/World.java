package main;

import object.Geometry;
import object.Hit;
import ray.Ray;
import color.Color;

/**
 * 
 * A world that contains all our elements, has a background color.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 * 
 */

public class World {

	/**
	 * Background of our world, used when nothing is hit.
	 */
	public Color backgroundColor;
	/**
	 * An Array of elements to be placed in our world.
	 */
	public Geometry[] elements;

	/**
	 * 
	 * Creates a new world.
	 * 
	 * @param backgroundColor
	 *            Background of our world, used when nothing is hit.
	 * @param elements
	 *            An Array of elements to be placed in our world.
	 */
	public World(final Color backgroundColor, final Geometry[] elements) {
		this.backgroundColor = backgroundColor;
		this.elements = elements;
	}

	/**
	 * 
	 * Checks all elements for intersection.
	 * 
	 * @param ray the ray to check with.
	 * @return the color of the intersected object or the background of the world.
	 */
	
	public Color hit(final Ray ray) {
		Hit temp = null;
		for (Geometry element : elements) {
			Hit h = element.hit(ray);
			if (temp == null || temp.t > h.t) {
				temp = h;
			}
		}
		if (temp != null) {
			return temp.geo.color;
		}
		return backgroundColor;
	}

}
