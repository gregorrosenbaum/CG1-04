package object;

import ray.Ray;
import vectorlib.Mat3x3;
import vectorlib.Point3;
import vectorlib.Vector3;
import color.Color;

public class Triangle extends Geometry {

	public Point3 a;
	public Point3 b;
	public Point3 c;

	public Triangle(Color color, Point3 a, Point3 b, Point3 c) {
		super(color);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public Hit hit(Ray r) {
		Mat3x3 A = new Mat3x3(a.x - b.x, a.x - c.x, r.d.x, a.y - b.y, a.y - c.y, r.d.y, a.z - b.z, a.z - c.z, r.d.z);
		Vector3 b = new Vector3(a.x - r.o.x, a.y - r.o.y, a.z - r.o.z);
		Mat3x3 A1 = A.changeCol1(b);
		Mat3x3 A2 = A.changeCol2(b);
		Mat3x3 A3 = A.changeCol3(b);
		double beta = A1.determinant / A.determinant;
		double gamma = A2.determinant / A.determinant;
		double t = A3.determinant / A.determinant;
		if (t > 0 && 0 <= beta && 0 <= gamma && beta + gamma <= 1) {
			return new Hit(t, r, this);
		}
		return null;
	}
}
