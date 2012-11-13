package Cameras;

import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;

/**
 * 
 * @author gregorrosenbaum
 * 
 */
public class PerspectiveCamera extends Camera {

	/**
	 * 
	 */
	public final double angle;

	/**
	 * 
	 * @param e
	 * @param g
	 * @param t
	 * @param angle
	 */
	public PerspectiveCamera(final Point3 e, final Vector3 g, final Vector3 t, final double angle) {
		super(e, g, t);
		this.angle = angle;
	}

	@Override
	public Ray rayFor(int w, int h, int x, int y) {
		return null;
	}

}
