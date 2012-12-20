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
		super();
		this.color = color;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {

		Color returnColor = new Color(0, 0, 0);

		for (Light l : world.lights) {
			if (l.illuminates(hit.ray.at(hit.t), world)) {
				returnColor = returnColor.add(color.mul(l.color.mul(Math.max(l.directionFrom(hit.ray.at(hit.t)).dot(hit.normal), 0))));
			}
		}
		return returnColor;
	}
}
