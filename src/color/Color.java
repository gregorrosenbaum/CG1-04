package color;

public class Color {

	public final double r;
	public final double g;
	public final double b;

	public Color(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Color add(Color c) {
		return new Color(r + c.r, g + c.g, b + c.b);
	}

	public Color sub(Color c) {
		return new Color(r - c.r, g - c.g, b - c.b);
	}

	public Color mul(Color c) {
		return new Color(r * c.r, g * c.g, b * c.b);
	}

	public Color mul(double d) {
		return new Color(r * d, g * d, b * d);
	}
	
	public int toInt(){
		return ((int)(r * 255) << 16) + ((int)(g * 255) << 8) + (int)(b * 255);
	}

}
