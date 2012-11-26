package object;

import ray.Ray;
import color.Color;

/**
 * Abstract Superclass for all the objects we are going to create for the
 * RayTracer. For example a {@link Sphere}, a {@link Plane} or a
 * {@link Triangle}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 * 
 */
public abstract class Geometry {

	public Color color;

	/**
	 * Abstract Superclass for all the objects we are going to create for the
	 * RayTracer. For example a {@link Sphere}, a {@link Plane} or a
	 * {@link Triangle}.
	 * 
	 * @param color
	 *            = {@link Color} of the Geometry.
	 */
	public Geometry(final Color color) {
		this.color = color;
	}

	/**
	 * Checks if the given {@link Geometry} is hit by the {@link Ray}.
	 * 
	 * @param r
	 *            = {@link Ray} to hit the {@link Geometry}.
	 * @return
	 */
	public abstract Hit hit(final Ray r);

	@Override
	public String toString() {
		return "Geometry [color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geometry other = (Geometry) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

}
