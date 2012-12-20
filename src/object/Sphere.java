package object;

import ray.Ray;
import util.Eps;
import vectorlib.Point3;
import Materials.Material;
import color.Color;

/**
 * Constructs a {@link Geometry} Sphere with a radius, a {@link Point3} and a {@link Color}.
 * 
 * @param color
 *            = Color of the Sphere.
 * @param c
 *            = {@link Point3} of the Sphere.
 * @param r
 *            = Radius of the Sphere.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class Sphere extends Geometry {

	public Point3 c;
	public double r;

	/**
	 * Constructs a {@link Geometry} Sphere with a radius, a {@link Point3} and a {@link Color}.
	 * 
	 * @param material
	 *            = Color of the Sphere.
	 * @param c
	 *            = {@link Point3} of the Sphere.
	 * @param r
	 *            = Radius of the Sphere.
	 */
	public Sphere(Material material, Point3 c, double r) {
		super(material);
		this.c = c;
		this.r = r;
	}

	@Override
	public Hit hit(Ray ray) {

		double a = ray.d.dot(ray.d);
		double b = ray.d.dot((ray.o.sub(c)).mul(2));
		double cn = (ray.o.sub(c).dot(ray.o.sub(c)) - (this.r * this.r));
		double d = (b * b) - 4.0 * a * cn;
		double t1 = (-b + Math.sqrt(d)) / (2.0 * a);
		double t2 = (-b - Math.sqrt(d)) / (2.0 * a);

		if (d > Eps.ylon) {
			if (t1 > t2) {
				return new Hit(t2, ray, this, (ray.o.sub(c).add(ray.d.mul(t2)).asNormal()));
			} else {
				return new Hit(t1, ray, this, (ray.o.sub(c).add(ray.d.mul(t1)).asNormal()));
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Sphere [c=" + c + ", r=" + r + ", material=" + material + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		return true;
	}
}