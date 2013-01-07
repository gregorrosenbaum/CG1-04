package Materials;

import main.Tracer;
import main.World;
import object.Hit;
import Lightning.Light;
import color.Color;

/**
 * {@link Material}, that returns just one {@link Color}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class SingleColorMaterial extends Material {

	public final Color color;

	/**
	 * @param color
	 *            = {@link Color} of the {@link Material}.
	 */
	public SingleColorMaterial(Color color) {
		this.color = color;
	}

	/**
	 * This method converts the current color into backgroundColor
	 * @returns backgroundColor
	 */
	
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		for (Light l : world.lights) {
			if (l.illuminates(hit.ray.at(hit.t), world)) {
				return color;
			}
		}
		return world.backgroundColor;
	}

}
