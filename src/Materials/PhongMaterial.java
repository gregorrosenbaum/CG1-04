package Materials;

import main.Tracer;
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
		super();
		this.diffuse = diffuse;
		this.specular = specular;
		this.exponent = exponent;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		return null;
	}

}
