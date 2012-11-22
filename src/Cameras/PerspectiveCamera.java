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
		this.angle = Math.toRadians(angle);
	}

	@Override
	public Ray rayFor(int w, int h, int x, int y) {
		Point3 o = this.e;
		Vector3 r = this.w.mul(-1).mul((h / 2.0) / Math.tan(angle)).add(u.mul(x - ((w - 1) / 2.0))).add(v.mul(y - ((h - 1) / 2.0)));
		Vector3 d = r.mul(1.0 / r.magnitude);
		return new Ray(o, d);
	}
}
