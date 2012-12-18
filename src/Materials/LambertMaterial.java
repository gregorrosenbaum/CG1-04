package Materials;

import main.RayTracer;
import main.World;
import object.Hit;
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
	public Color colorFor(Hit hit, World world, RayTracer tracer) {
		// TODO Auto-generated method stub
		return super.colorFor(hit, world, tracer);
	}
	
}
