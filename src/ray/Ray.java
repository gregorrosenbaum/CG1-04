package ray;

import vectorlib.Point3;
import vectorlib.Vector3;

public class Ray {

	public final Point3 o;
	public final Vector3 d;

	public Ray(final Point3 o, final Vector3 d) {
		this.o = o;
		this.d = d;
	}

	public Point3 at(double t) {
		return o.add(d.mul(t));
	}

	public Vector3 tOf(Point3 p) {
		return p.sub(o);
	}
}
