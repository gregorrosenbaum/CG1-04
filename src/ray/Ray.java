package ray;

import vectorlib.Point3;
import vectorlib.Vector3;

/**
 * Constructs a Ray with a {@link Point3} and a {@link Vector3}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 * 
 */
public class Ray {

	public final Point3 o;
	public final Vector3 d;

	/**
	 * 
	 * @param o
	 *            = {@link Point3} of the Ray.
	 * @param d
	 *            = {@link Vector3} of the Ray.
	 */
	public Ray(final Point3 o, final Vector3 d) {
		this.o = o;
		this.d = d;
	}

	/**
	 * Returns the {@link Point3} with the distance t.
	 * 
	 * @param t
	 *            = Distance from the {@link Camera} to the {@link Point3}.
	 * @return {@link Point3}
	 */
	public Point3 at(double t) {
		return o.add(d.mul(t));
	}
	/**
	 * Returns the {@link Vector3} at the {@link Point3} p.
	 * @param p = 
	 * @return {@link Vector3}
	 */
	public Vector3 tOf(Point3 p) {
		return p.sub(o);
	}

	@Override
	public String toString() {
		return "o:" + o + ", d: " + d;
	}
}
