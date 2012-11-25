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
//		Point3 o = this.e.add(this.u.mul(x).add(this.v.mul(y)));
		Vector3 part1 = this.u.mul(s * ((x - ((w - 1) / 2.0)) / (w - 1)));
		Vector3 part2 = this.v.mul(s * ((y - ((h - 1) / 2.0)) / (h - 1)));
		Point3 o = this.e.add(part1).add(part2);
		return new Ray(o, d);
	}
}