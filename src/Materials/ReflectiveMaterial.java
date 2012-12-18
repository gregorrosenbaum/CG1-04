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
	public ReflectiveMaterial(Color diffuse, Color specular, int exponent,
			Color reflection) {
		super();
		this.diffuse = diffuse;
		this.specular = specular;
		this.exponent = exponent;
		this.reflection = reflection;
	}
	@Override
	public Color colorFor(Hit hit, World world, RayTracer tracer) {
		// TODO Auto-generated method stub
		return super.colorFor(hit, world, tracer);
	}
}
