package object;

import ray.Ray;
import vectorlib.Point3;
import vectorlib.Vector3;
import color.Color;

public class AxisAlignedBox extends Geometry {

	public Vector3 lbf;
	public  Point3 run;

	public AxisAlignedBox(Color color,Vector3 lbf, Point3 run) {
		super(color);
		this.lbf = lbf;
		this.run = run;
	}

	@Override
	public Hit hit(Ray r) {
		
		double tx_min, ty_min, tz_min;
		double tx_max, ty_max, tz_max;
		
		double a = 1.0 / r.d.x;
		if(a >= 0){
			tx_min = (lbf.x - r.o.x) * a;
			tx_max = (run.x - r.o.x) * a;
		}else{
			tx_max = (lbf.x - r.o.x) * a;
			tx_min = (run.x - r.o.x) * a;
		}
		
		double b = 1.0 / r.d.y;
		if(b >= 0){
			ty_min = (lbf.y - r.o.y) * b;
			ty_max = (run.y - r.o.y) * b;
		}else{
			ty_max = (lbf.y - r.o.y) * b;
			ty_min = (run.y - r.o.y) * b;
		}
		
		double c = 1.0 / r.d.z;
		if(c >= 0){
			tz_min = (lbf.z - r.o.z) * c;
			tz_max = (run.z - r.o.z) * c;
		}else{
			tz_max = (lbf.z - r.o.z) * c;
			tz_min = (run.z - r.o.z) * c;
		}

		double t0,t1;

		int face_in, face_out;
		
		if(tx_min > ty_min){
			t0 = tx_min;
			face_in = (a >= 0.0) ? 0 : 3;
		}else{
			t0 = ty_min;
			face_in = (b >= 0.0) ? 1 : 4;
		}
		
		if(tz_min > t0){
			t0 = tz_min;
			face_in = (c >= 0.0) ? 2: 5;
		}
		
		if(tx_max < ty_max){
			t1 = tx_max;
			face_out = (a >= 0.0) ? 3 : 0;
		}else{
			t1 = ty_max;
			face_out= (b >= 0.0) ? 4 : 1;
		}
		
		if(tz_max < t1){
			t1 = tz_max;
			face_out= (c >= 0.0) ? 5: 2;
		}
		
		if(t0 < t1 && t1 > 0){
			if(t0 > 0){
				return new Hit(t0, r, this);
			}else{
				return new Hit(t1, r, this);
			}
		}

		return null;
//		double t = r.o.sub(run).dot(lbf) / r.d.dot(lbf);
//		if (t > 0) {
//			return new Hit(t, r, this);
//		}
//		return null;
	}

}