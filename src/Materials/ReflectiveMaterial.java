package Materials;

import main.Tracer;
import main.World;
import object.Hit;
import ray.Ray;
import Lightning.Light;
import color.Color;

/**
 * 
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class ReflectiveMaterial extends Material {

	public Color diffuse;
	public Color specular;
	public int exponent;
	public Color reflection;

	/**
	 * 
	 * 
	 * @param diffuse
	 * @param specular
	 * @param exponent
	 * @param reflection
	 */
	public ReflectiveMaterial(Color diffuse, Color specular, int exponent, Color reflection) {
		this.diffuse = diffuse;
		this.specular = specular;
		this.exponent = exponent;
		this.reflection = reflection;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		Color returnColor = new Color(world.ambient.r, world.ambient.g, world.ambient.b);
		for (Light l : world.lights) {
			if (l.illuminates(hit.ray.at(hit.t), world)) {
				Color reflec = reflection.mul(tracer.colorFor(new Ray(hit.ray.at(hit.t), hit.ray.d.add(hit.normal.mul(hit.ray.d.mul(-1).dot(
						hit.normal) * 2)))));
				Color spec = specular.mul(l.color.mul(Math.pow(
						Math.max(hit.ray.d.dot(l.directionFrom(hit.ray.at(hit.t)).reflectedOn(hit.normal).mul(-1.0)), 0), exponent)));
				returnColor = returnColor.add(diffuse.mul(l.color.mul(Math.max(l.directionFrom(hit.ray.at(hit.t)).dot(hit.normal), 0))).add(spec)
						.add(reflec));
			}
		}
		return returnColor;
	}
}
