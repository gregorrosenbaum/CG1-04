package Lightning;

import main.RayTracer;
import main.World;
import vectorlib.Point3;
import vectorlib.Vector3;
import color.Color;

/**
 * Directional Light for the {@link RayTracer}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class DirectionalLight extends Light {

	public Point3 direction;

	/**
	 * 
	 * @param color
	 *            = {@link Color} of the hitted pixel.
	 * @param castsShadows
	 *            =
	 * @param direction
	 *            = Direction of the light.
	 */
	public DirectionalLight(Color color, boolean castsShadows, Point3 direction) {
		super(color, castsShadows);
		this.direction = direction;
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		return false;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return null;
	}

}
