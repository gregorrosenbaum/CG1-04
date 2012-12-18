package Materials;

import main.Tracer;
import main.World;
import object.Hit;
import Lightning.Light;
import color.Color;

/**
 * 
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class PhongMaterial extends Material {

	public Color diffuse;
	public Color specular;
	public int exponent;

	/**
	 * 
	 * 
	 * @param diffuse
	 * @param specular
	 * @param exponent
	 */
	public PhongMaterial(Color diffuse, Color specular, int exponent) {
		this.diffuse = diffuse;
		this.specular = specular;
		this.exponent = exponent;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		Color returnColor = new Color(0, 0, 0);

		for (Light l : world.lights) {
			Color spec = specular.mul(l.color.mul(Math.pow(
					Math.max(hit.ray.d.dot(l.directionFrom(hit.ray.at(hit.t)).reflectedOn(hit.normal).mul(-1.0)), 0), exponent)));
			returnColor = returnColor.add(diffuse.mul(l.color.mul(Math.max(l.directionFrom(hit.ray.at(hit.t)).dot(hit.normal), 0))).add(spec));
		}
		return returnColor;
	}
}
