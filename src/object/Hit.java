package object;

import ray.Ray;

/**
 * Tests if the {@link Ray} of the {@link Camera} hits the {@link Geometry}
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 * 
 * @param t
 *            = Distance between the {@link Geometry}-Object and the
 *            {@link Camera}.
 * @param ray
 *            = Ray from the {@link Camera} to the {@link Geometry}.
 * @param geo
 *            = {@link Geometry}-Object ({@link Plane}, {@link Sphere},
 *            {@link Triangle}
 */
public class Hit {

	public final double t;
	public final Ray ray;
	public final Geometry geo;

	/**
	 * 
	 * @param t
	 *            = Distance between the {@link Geometry}-Object and the
	 *            {@link Camera}.
	 * @param ray
	 *            = Ray from the {@link Camera} to the {@link Geometry}.
	 * @param geo
	 *            = {@link Geometry}-Object ({@link Plane}, {@link Sphere},
	 *            {@link Triangle}
	 */

	public Hit(final double t, final Ray ray, final Geometry geo) {
		this.t = t;
		this.ray = ray;
		this.geo = geo;
	}

	@Override
	public String toString() {
		return t + " " + ray + " " + geo + "]";
	}

}
