package Materials;

import main.RayTracer;
import main.World;
import object.Hit;
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
		super();
		this.indexOfRefraction = indexOfRefraction;
	}

	@Override
	public Color colorFor(Hit hit, World world, RayTracer tracer) {
		// TODO Auto-generated method stub
		return super.colorFor(hit, world, tracer);
	}
	
	

}
