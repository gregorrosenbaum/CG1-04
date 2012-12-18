package Materials;

import main.RayTracer;
import main.World;
import object.Hit;
import color.Color;
/**
 * Superclass for all materials we create for the {@link Geometry}.
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */
public class Material {
	
	public Material(){
		
	}
	/**
	 * 
	 * 
	 * @param hit = checks for a {@link Hit}
	 * @param world = {@link World} that displays all the {@link Geometry}.
	 * @param tracer = {@link RayTracer}.
	 * @return
	 */
	public Color colorFor(Hit hit, World world, RayTracer tracer) {
		return new Color(0, 0, 0);
	}
}
