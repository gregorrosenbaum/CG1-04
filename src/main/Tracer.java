package main;

import object.Hit;
import ray.Ray;
import color.Color;

public class Tracer {

	public final World world;
	protected Hit hit;
	protected int counter;
	final static int maxDepth = 6;

	public Tracer(World world) {
		this.world = world;
		this.counter = maxDepth;
	}

	public Color colorFor(Ray r) {
		counter--;
		if (counter > 0) {
			hit = world.hit(r);
			if (hit != null) {
				Color color = hit.geo.material.colorFor(hit, world, this);
				counter = maxDepth;
				return color;
			}
		}
		counter = maxDepth;
		return world.backgroundColor;
	}
}
