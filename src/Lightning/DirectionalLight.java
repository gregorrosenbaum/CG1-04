package Lightning;

import object.Hit;
import main.RayTracer;
import main.World;
import ray.Ray;
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

	public Vector3 direction;

	/**
	 * 
	 * @param color
	 *            = {@link Color} of the hitted pixel.
	 * @param castsShadows
	 *            =
	 * @param direction
	 *            = Direction of the light.
	 */
	public DirectionalLight(Color color, boolean castsShadows, Vector3 direction) {
		super(color, castsShadows);
		this.direction = direction;
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		if (castsShadows == true) {
			Ray ray = new Ray(new Point3 (direction.x*50, direction.y*50, direction.z*50), direction.normalized());
			Hit hit = world.hit(ray);
			if (hit == null
					|| (double) Math.round(hit.t * 100000) / 100000 >= (double) Math
							.round(ray.tOf(point) * 100000) / 100000) {
				return true;
			}
			return false;
		}
		return true;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return direction.mul(-0.8);

	}

}
