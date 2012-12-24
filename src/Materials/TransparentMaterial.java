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

	/**
	 * 
	 * 
	 * @param indexOfRefraction
	 */
	public TransparentMaterial(double indexOfRefraction) {
		this.indexOfRefraction = indexOfRefraction;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		double cosg1 = hit.ray.d.mul(-1).dot(hit.normal);
		Normal3 normal = hit.normal;
		double n1 = world.indexOfRefraction;
		double n2 = indexOfRefraction;
		double test = Math.toDegrees(Math.acos(cosg1));

		if (test > 90 || test < -90) {
			// normal = hit.normal.mul(-1);
			n2 = 1.0 / n2;
			cosg1 = -(hit.ray.d.mul(-1).dot(hit.normal));
		}

		double cosg2 = Math.sqrt(1 - ((n1 / n2) * (n1 / n2)) * (1 - cosg1 * cosg1));
		// double cosg2 = Math.sqrt(1 - Math.pow((n1 / n2) * Math.sqrt(1 - (cosg1 * cosg1)), 2));
		double test2 = Math.toDegrees(Math.acos(cosg2));

		double R0 = Math.pow(((n1 - n2) / (n1 + n2)), 2);

		double R = R0 + (1 - R0) * Math.pow(1 - Math.pow(cosg1, 2), 5);

		double T = 1 - R;

		Vector3 t = hit.ray.d.mul(n1 / n2).sub(normal.mul(cosg2 - (n1 / n2) * cosg1));

		return (tracer.colorFor(new Ray(hit.ray.at(hit.t), hit.ray.d.add(normal.mul(hit.ray.d.mul(-1).dot(normal) * 2)))).mul(R)).add(tracer
				.colorFor(new Ray(hit.ray.at(hit.t), t.normalized())).mul(T));
	}
}
