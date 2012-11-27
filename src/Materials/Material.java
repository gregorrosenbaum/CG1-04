package Materials;

import main.RayTracer;
import main.World;
import object.Hit;
import color.Color;
/**
 * Superclass for all materials we create for the {@link World}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class Material {

	public Color colorFor(Hit hit, World world, RayTracer tracer) {
		return new Color(0, 0, 0);
	}
}
