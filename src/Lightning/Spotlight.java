package Lightning;

import main.RayTracer;
import main.World;
import object.Hit;
import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;
import Materials.TransparentMaterial;
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
		Ray ray = new Ray(position, point.sub(position).normalized());
		Hit hit = world.hit(ray);
		double alpha = Math.acos(direction.dot(point.sub(position)) / (direction.magnitude * point.sub(position).magnitude));
		if (alpha <= halfAngle
				&& (castsShadows == false || hit == null
						|| (double) Math.round(hit.t * 100000) / 100000 >= (double) Math.round(ray.tOf(point) * 100000) / 100000 || hit.geo.material instanceof TransparentMaterial)) {
			return true;
		}
		return false;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return position.sub(point).normalized();
	}
}
