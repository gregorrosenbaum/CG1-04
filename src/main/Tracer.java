package main;

import object.Hit;
import ray.Ray;
import color.Color;

public class Tracer {

	public final World world;
	protected Hit hit;
	protected int counter;

	public Tracer(World world) {
		this.world = world;
		counter = 6;
	}

	public Color colorFor(Ray r) {
		counter -= 1;
		if (counter == 0) {
			counter = 6;
			return world.backgroundColor;
		}
		hit = world.hit(r);
		counter = 6;
		if (hit != null) {
			return hit.geo.material.colorFor(hit, world, this);
		}
		return world.backgroundColor;
	}
}
