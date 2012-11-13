package Cameras;

import vectorlib.Point3;
import vectorlib.Vector3;

/**
 * 
 * @author gregorrosenbaum
 *
 */
public class OrthographicCamera extends Camera{
	
	/**
	 * 
	 */
	final double s;

	/**
	 * 
	 * @param e
	 * @param g
	 * @param t
	 * @param s
	 */
	public OrthographicCamera(Point3 e, Vector3 g, Vector3 t, double s) {
		super();
		this.s = s;		
	}
	
	public Ray Rayfor(int w, int h, int x, int y){
		
	}

}
