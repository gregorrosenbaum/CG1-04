package Lightning;

import main.RayTracer;
import main.World;
import object.Hit;
import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;
import color.Color;

/**
 * Spotlight for the {@link RayTracer}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class Spotlight extends Light {

	public Point3 position;
	public Vector3 direction;
	public double halfAngle;

	public Spotlight(Color color, Point3 position, boolean castsShadows, Vector3 direction, double halfAngle) {
		super(color, castsShadows);
		this.halfAngle = halfAngle;
		this.direction = direction;
		this.position = position;
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		Hit hit = world.hit(new Ray(point, direction));

		return true;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return position.sub(point).normalized();
	}
}
