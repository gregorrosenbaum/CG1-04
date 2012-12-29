package Materials;

import main.Tracer;
import main.World;
import object.Hit;
import Lightning.Light;
import color.Color;

/**
 * 
 * 
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class LambertMaterial extends Material {

	public Color color;

	/**
	 * @param color
	 *            = {@link Color} of the {@link Material}.
	 */
	public LambertMaterial(Color color) {
		this.color = color;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		// we declare a temporary color to which we will add all light colors
		// it initializes with the ambient color of the world
		Color returnColor = new Color(world.ambient.r, world.ambient.g, world.ambient.b);

		for (Light l : world.lights) {
			// here we check if the light illuminates the object and add the corresponding color
			// formula: see assignment sheet -> LambertMaterial
			if (l.illuminates(hit.ray.at(hit.t), world)) {
				returnColor = returnColor.add(color.mul(l.color.mul(Math.max(l.directionFrom(hit.ray.at(hit.t)).dot(hit.normal), 0))));
			}
		}
		return returnColor;
	}
}
