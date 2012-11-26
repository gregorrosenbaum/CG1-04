package main;

import object.Geometry;
import object.Hit;
import ray.Ray;
import color.Color;

public class World {

	public Color backgroundColor;
	public Geometry[] elements;

	public World(Color backgroundColor, Geometry[] elements) {
		this.backgroundColor = backgroundColor;
		this.elements = elements;
	}

	public Color hit(Ray ray) {
		Hit temp = null;
		for (Geometry element : elements) {
			Hit h = element.hit(ray);
			if (temp == null || temp.t > h.t){
				temp = h;
			}			
			if (temp != null) {
				return element.color;
			}
		}
		return backgroundColor;
	}

}
