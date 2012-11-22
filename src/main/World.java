package main;

import ray.Ray;
import color.Color;

public class World {
	
	public Color backgroundColor;

	public World(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public Color hit(Ray ray){
		return backgroundColor;
	}
	

}
