package Cameras;

import vectorlib.Point3;
import vectorlib.Vector3;


/**
 * 
 * @author gregorrosenbaum
 *
 */

public abstract class Camera {
	/**
	 * 
	 */
	final Point3 e;
	/**
	 * 
	 */
	final Vector3 g;
	/**
	 * 
	 */
	final Vector3 t;
	/**
	 * 
	 */
	final Vector3 u;
	/**
	 * 
	 */
	final Vector3 v;
	/**
	 * 
	 */
	final Vector3 w;
	
	/**
	 * 
	 * @param e
	 * @param g
	 * @param t
	 */
	public Camera (Point3 e, Vector3 g, Vector3 t){
		this.e = e;
		this.g = g;
		this.t = t;
	}
	/**
	 * 
	 * @param w
	 * @param h
	 * @param x
	 * @param y
	 * @return
	 */
	public Ray Rayfor(int w, int h, int x, int y){
		
	}

}
