package Lightning;

import main.RayTracer;
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
public abstract class Light {

	public Color color;
	public boolean castsShadows;

	/**
	 * @param color
	 *            = {@link Color}
	 * @param castsShadows
	 */
	public Light(Color color, boolean castsShadows) {
		this.color = color;
		this.castsShadows = castsShadows;
	}

	public abstract boolean illuminates(Point3 point, World world);

	public abstract Vector3 directionFrom(Point3 point);
}
