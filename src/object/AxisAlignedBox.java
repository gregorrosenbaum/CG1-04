package object;

import ray.Ray;
import vectorlib.Point3;
import color.Color;

public class AxisAlignedBox extends Geometry {

	public Point3 lbf;
	public Point3 run;

	public AxisAlignedBox(Color color, Point3 lbf, Point3 run) {
		super(color);
		this.lbf = lbf;
		this.run = run;
	}

	@Override
	public Hit hit(Ray r) {
		// double t = r.o.sub(lbf).dot(run) / r.d.dot(run);
		// if (t > 0) {
		// return new Hit(t, r, this);
		// }
		return null;
	}

}