package Materials;

import main.Tracer;
import main.World;
import object.Hit;
import vectorlib.Point3;
import Lightning.Light;
import color.Color;

/**
 * PhongMaterial shows a {@link Material} for a perfect diffuse reflected body with a shining point
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class PhongMaterial extends Material {

	public final Color diffuse;
	public final Color specular;
	public final int exponent;

	/**
	 * This constructor gives a PhongMaterial
	 * 
	 * @param diffuse = 
	 * 					diffuse reflection of {@link Color} of {@link Material} 
	 * @param specular = 
	 * 					specular mirror-like reflection of {@link Color} of {@link Material}
	 * @param exponent = 
	 * 					 is the exponent for the function e^x
	 * 					
	 */
	public PhongMaterial(Color diffuse, Color specular, int exponent) {
		this.diffuse = diffuse;
		this.specular = specular;
		this.exponent = exponent;
	}

	/**
	 * This method converts the current color into returnColor
	 * @returns returnColor
	 */
	
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		// we declare a temporary color to which we will add all light colors
		// it initializes with the ambient color of the world
		Color returnColor = new Color(world.ambient.r, world.ambient.g, world.ambient.b);

		// we declare this for performance reasons, as it would be called several times in the loop
		Point3 pointOnRay = hit.ray.at(hit.t);

		for (Light l : world.lights) {
			// here we check if the light illuminates the object and add the corresponding color
			// formula: see assignment sheet -> PhongMaterial
			if (l.illuminates(pointOnRay, world)) {
				Color spec = specular.mul(l.color.mul(Math.pow(
						Math.max(hit.ray.d.dot(l.directionFrom(pointOnRay).reflectedOn(hit.normal).mul(-1.0)), 0), exponent)));
				returnColor = returnColor.add(diffuse.mul(l.color.mul(Math.max(l.directionFrom(pointOnRay).dot(hit.normal), 0))).add(spec));
			}
		}
		return returnColor;
	}
}
