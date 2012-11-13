package Cameras;

import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;

/**
 * 
 * @author gregorrosenbaum
 * 
 */
public class OrthographicCamera extends Camera {

	/**
	 * 
	 */
	public final double s;

	/**
	 * 
	 * @param e
	 * @param g
	 * @param t
	 * @param s
	 */
	public OrthographicCamera(Point3 e, Vector3 g, Vector3 t, double s) {
		super(e, g, t);
		this.s = s;
	}

	public Ray rayFor(int w, int h, int x, int y) {
		Vector3 d = this.w.mul(-1);
		Point3 o = this.e.add(this.u.mul(((w / h) * s) * ((x - (w - 1 / 2)) / w - 1))).add(this.v.mul(s * ((y - (h - 1 / 2)) / h - 1)));
		return new Ray(o, d);
	}
}
