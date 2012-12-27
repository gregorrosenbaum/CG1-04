package Materials;

import main.Tracer;
import main.World;
import object.Hit;
import ray.Ray;
import vectorlib.Normal3;
import vectorlib.Vector3;
import color.Color;

/**
 * 
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class TransparentMaterial extends Material {

	public double indexOfRefraction;
	protected double counter;
	protected double maxDepth = 3;

	/**
	 * 
	 * 
	 * @param indexOfRefraction
	 */
	public TransparentMaterial(double indexOfRefraction) {
		this.indexOfRefraction = indexOfRefraction;
		this.counter = maxDepth;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		counter--;
		if(counter <= 0){
			return world.backgroundColor;
		}
		double cosg1 = hit.ray.d.mul(-1).dot(hit.normal);
		Normal3 normal = hit.normal;
		double n1 = world.indexOfRefraction;
		double n2 = indexOfRefraction;
		double test = Math.toDegrees(Math.acos(cosg1));
		boolean tir = false;

		if (test > 90) {
			normal = hit.normal.mul(-1);
			cosg1 = (hit.ray.d.mul(-1).dot(normal));
			n1 = indexOfRefraction;
			n2 = world.indexOfRefraction;
		}

		double cosg2 = (Math.sqrt(1 - ((n1 / n2) * (n1 / n2))
				* (1 - cosg1 * cosg1)));

		double R0 = Math.pow(((n1 - n2) / (n1 + n2)), 2);

		double R = 1;

		if (n1 > n2) {
			double sing2 = (n1 / n2) * (n1 / n2) * (1 - cosg1 * cosg1);
			// double gc = Math.asin(n2 / n1);
			if (sing2 > 1) {
				tir = true;
			}
		}

		if (n1 <= n2) {
			R = R0 + (1 - R0) * Math.pow(1 - cosg1, 5);
		} else if (n1 > n2 && tir == false) {
			R = R0 + (1 - R0) * Math.pow(1 - cosg2, 5);
		} else if (n1 > n2 && tir == true) {
			R = 1;
		}

		if (R != 1) {
			double T = 1 - R;
			
			Vector3 t = hit.ray.d.mul(n1 / n2).add(
					normal.mul(cosg1 * (n1 / n2) - cosg2));
			
			Color color =  (tracer.colorFor(new Ray(hit.ray.at(hit.t), hit.ray.d
					.add(normal.mul(cosg1 * 2)))).mul(R)).add(tracer.colorFor(
					new Ray(hit.ray.at(hit.t), t)).mul(T));
			counter = maxDepth;
			return color;
		} else {
			Color color = tracer.colorFor(new Ray(hit.ray.at(hit.t), hit.ray.d
					.add(normal.mul(cosg1 * 2))));
			counter = maxDepth;
			return color;
		}
	}
}
