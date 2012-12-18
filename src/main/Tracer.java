package main;

import object.Hit;
import ray.Ray;
import color.Color;

public class Tracer {

	public final World world;
	protected Hit hit;

	public Tracer(World world) {
		this.world = world;
	}

	public Color colorFor(Ray r) {

		hit = world.hit(r);
		if (hit != null) {
			return hit.geo.material.colorFor(hit, world, this);
		}
		return world.backgroundColor;
	}
}
