package Lightning;

import main.RayTracer;
import main.World;
import vectorlib.Point3;
import vectorlib.Vector3;
import color.Color;

/**
 * PointLight for the {@link RayTracer}
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class PointLight extends Light {

	public Point3 position;

	/**
	 * 
	 * @param color
	 *            = {@link Color} of the hitted pixel.
	 * @param castsShadows
	 *            =
	 * @param position
	 *            = Position of the light.
	 */
	public PointLight(Color color, boolean castsShadows, Point3 position) {
		super(color, castsShadows);
		this.position = position;
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		return true;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return position.sub(point).normalized();
	}
}
