package Lightning;

import main.RayTracer;
import main.World;
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

	public Spotlight(Color color, Point3 position, boolean castsShadows,
			Vector3 direction, double halfAngle) {
		super(color, castsShadows);
		this.halfAngle = halfAngle;
		this.direction = direction;
		this.position = position;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		// TODO Auto-generated method stub
		return super.illuminates(point, world);
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		// TODO Auto-generated method stub
		return super.directionFrom(point);
	}
}
