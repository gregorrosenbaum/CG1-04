package main;

import object.Hit;
import ray.Ray;
import Materials.LambertMaterial;
import Materials.PhongMaterial;
import color.Color;

public class Tracer {

	public final World world;
	protected Hit hit;
	protected int counter;

	public Tracer(World world) {
		this.world = world;
		this.counter = 6;
	}

	public Color colorFor(Ray r) {
		counter--;
		if (counter > 0) {
			hit = world.hit(r);
			if (hit != null) {
				if (hit.geo.material instanceof LambertMaterial || hit.geo.material instanceof PhongMaterial) {
					counter = 6;
				}
				try {
					return hit.geo.material.colorFor(hit, world, this);
				} catch (StackOverflowError e) {
					System.out.println(counter);
				}
			}
		}
		counter = 6;
		return world.backgroundColor;
	}
}
