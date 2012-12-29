package main;

import object.Hit;
import ray.Ray;
import color.Color;

public class Tracer {

	public final World world;
	protected Hit hit;
	// the protection mechanism that prevents recursion from happening more than maxDepth times
	protected int recursionCounter;
	public static final int maxDepth = 6;

	public Tracer(World world) {
		this.world = world;
		this.recursionCounter = maxDepth;
	}

	public Color colorFor(Ray r) {
		recursionCounter--;
		if (recursionCounter > 0) {
			hit = world.hit(r);
			if (hit != null) {
				// it is important that the recursionCounter is reset between the variable
				// allocation and the return
				// this makes sure we reset the counter AFTER the recursion
				Color color = hit.geo.material.colorFor(hit, world, this);
				recursionCounter = maxDepth;
				return color;
			}
		}
		recursionCounter = maxDepth;
		return world.backgroundColor;
	}
}
