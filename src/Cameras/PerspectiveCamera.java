package Cameras;

import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;

/**
 * 
 * @author gregorrosenbaum
 *
 */
public class PerspectiveCamera extends Camera{
	
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
	public PerspectiveCamera(Point3 e, Vector3 g, Vector3 t, double angle) {
		super(e,g,t);
		this.angle = angle;
	}
	
	public Ray rayFor(int w, int h, int x, int y){
		
	}
	
	

}
