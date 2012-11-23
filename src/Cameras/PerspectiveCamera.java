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
		Vector3 p1 = this.w.mul(-1);
		double p2 = h / 2.0;
		double p3 = Math.tan(angle);
		Vector3 part1 = p1.mul((p2) / p3);
		Vector3 part2 = u.mul(x - ((w - 1) / 2.0));
		Vector3 part3 = v.mul(y - ((h - 1) / 2.0));
		Vector3 r = part1.add(part2).add(part3);
		Vector3 d = r.mul(1.0 / r.magnitude);
		return new Ray(o, d);
	}
}
