package object;

import ray.Ray;
import color.Color;

public abstract class Geometry {

	public Color color;

	public Geometry(final Color color) {
		this.color = color;
	}

	public abstract Hit hit(final Ray r);

}
