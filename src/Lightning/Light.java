package Lightning;

import main.World;
import vectorlib.Point3;
import vectorlib.Vector3;
import color.Color;
/**
 * Abstract superclass for all light of the {@link RayTracer}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class Light {

	public Color color;
	public boolean castsShadows;

	/**
	 * @param color = {@link Color}
	 * @param castsShadows
	 */
	public Light(Color color, boolean castsShadows) {
		this.color = color;
		this.castsShadows = castsShadows;
	}
	
	public boolean illuminates (Point3 point, World world){
		return true;
	}
	
	public Vector3 directionFrom (Point3 point){
		return new Vector3 (0, 0, 0);
	}
}
