package tests;

import object.Plane;
import ray.Ray;
import vectorlib.Normal3;
import vectorlib.Point3;
import vectorlib.Vector3;
import Cameras.PerspectiveCamera;
import color.Color;

public class GeoUnit {

	public static void main(String[] args) {
		PerspectiveCamera cam = new PerspectiveCamera(new Point3(0, 1, 0), new Vector3(0, -1, -1), new Vector3(0, 1, 0), 30);
		Ray ray = cam.rayFor(1024, 768, 300, 400);
		System.out.println(ray);
		// Ray ray = new Ray(new Point3(0, 1, 0), new Vector3(-0.33, -0.66, -0.69));
		Plane plane = new Plane(new Color(0, 1, 0), new Point3(0, 0, 0), new Normal3(0, 1, 0));
		System.out.println(plane.hit(ray));
	}
}