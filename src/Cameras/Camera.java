package Cameras;

import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;

/**
 * Abstract Superclass for all the cameras we are going to create. For exmaple
 * {@link OrthographicCamera} or {@link PerspectiveCamera}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */

public abstract class Camera {
	/**
	 * 
	 */
	public Point3 e;
	/**
	 * 
	 */
	public Vector3 g;
	/**
	 * 
	 */
	public Vector3 t;
	/**
	 * 
	 */
	public Vector3 u;
	/**
	 * 
	 */
	public Vector3 v;
	/**
	 * 
	 */
	public Vector3 w;

	/**
	 * Creates a Camera in 3-dimensional space.
	 * 
	 * @param e = 
	 * @param g = 
	 * @param t = 
	 */
	public Camera(final Point3 e, final Vector3 g, final Vector3 t) {
		this.e = e;
		this.g = g;
		this.t = t;
		this.w = g.mul(1 / g.magnitude).mul(-1);
		this.u = t.x(w).mul(1.0 / t.x(w).magnitude);
		this.v = w.x(u);
	}

	/**
	 * 
	 * @param w
	 * @param h
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract Ray rayFor(int w, int h, int x, int y);

}
