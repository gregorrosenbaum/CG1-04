package object;

import ray.Ray;

public class Hit {

	public final double t;
	public final Ray ray;
	public final Geometry geo;

	public Hit(final double t, final Ray ray, final Geometry geo) {
		this.t = t;
		this.ray = ray;
		this.geo = geo;
	}

	@Override
	public String toString() {
		return t + " " + ray + " " + geo + "]";
	}

}
