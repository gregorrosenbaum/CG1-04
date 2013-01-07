package Materials;

import main.Tracer;
import main.World;
import object.Hit;
import ray.Ray;
import vectorlib.Point3;
import Lightning.Light;
import color.Color;

/**
 * ReflectiveMaterials shows a {@link Material} for a perfect diffuse reflected body with a shining point 
 * and reflection
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
	 * @param diffuse = 
	 * 					
	 * @param specular
	 * @param exponent
	 * @param reflection
	 */
	public ReflectiveMaterial(Color diffuse, Color specular, int exponent, Color reflection) {
		this.diffuse = diffuse;
		this.specular = specular;
		this.exponent = exponent;
		this.reflection = reflection;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		// we declare a temporary color to which we will add all light colors
		// it initializes with the ambient color of the world
		Color returnColor = new Color(world.ambient.r, world.ambient.g, world.ambient.b);

		// we declare this for performance reasons, as it would be called several times in the loop
		Point3 pointOnRay = hit.ray.at(hit.t);

		for (Light l : world.lights) {
			// this first step is the same as in the phong material
			// here we check if the light illuminates the object and add the corresponding color
			// formula: see assignment sheet -> PhongMaterial
			if (l.illuminates(pointOnRay, world)) {
				Color spec = specular.mul(l.color.mul(Math.pow(
						Math.max(hit.ray.d.dot(l.directionFrom(pointOnRay).reflectedOn(hit.normal).mul(-1.0)), 0), exponent)));
				returnColor = returnColor.add(diffuse.mul(l.color.mul(Math.max(l.directionFrom(pointOnRay).dot(hit.normal), 0))).add(spec));
			}
		}

		// as a second step, we add the reflection
		Color reflec = reflection.mul(tracer.colorFor(new Ray(pointOnRay, hit.ray.d.add(hit.normal.mul(hit.ray.d.mul(-1).dot(hit.normal) * 2)))));
		return returnColor.add(reflec);
	}
}
