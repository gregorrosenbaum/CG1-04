package Materials;

import main.RayTracer;
import main.World;
import object.Hit;
import color.Color;
/**
 * {@link Material}, that returns jaust one {@link Color}. 
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class SingleColorMaterial extends Material {
	
	public Color color;

	/**
	 * @param color = {@link Color} of the {@link Material}.
	 */
	public SingleColorMaterial(Color color) {
		super();
		this.color = color;
	}

	@Override
	public Color colorFor(Hit hit, World world, RayTracer tracer) {
		// TODO Auto-generated method stub
		return super.colorFor(hit, world, tracer);
	}
	
	

}
