
/**
 * Hyperbolic numbers are an extension of the real numbers by adjoining a new element j where j^2 = 1.
 *
 * This class represents hyperbolic numbers in the form a+bj.
 */
public class HyperbolicNumber {
	double a, b;
	
	public HyperbolicNumber(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	
	public HyperbolicNumber add(HyperbolicNumber other) {
		return new HyperbolicNumber(a + other.a, b + other.b);
	}

	public HyperbolicNumber subtract(HyperbolicNumber other) {
		return new HyperbolicNumber(a - other.a, b - other.b);
	}

	public HyperbolicNumber multiply(HyperbolicNumber other) {
		return new HyperbolicNumber(a * other.a + b * other.b, a * other.b + b * other.a);
	}

	public HyperbolicNumber divide(HyperbolicNumber other) {
		HyperbolicNumber z = multiply(other.conjugate());
		double denom = other.multiply(other.conjugate()).a;
		
		return new HyperbolicNumber(z.a / denom, z.b / denom);
	}
	
	public HyperbolicNumber pow(HyperbolicNumber other) {
		double scalar = Math.pow(a, other.a + 1);
		double epsilon = (scalar * other. b * Math.log(a)) + (other.a * b);
		return new HyperbolicNumber(scalar, epsilon);
	}

	public HyperbolicNumber conjugate() {
		return new HyperbolicNumber(a, -b);
	}
	public String toString() {
		if (a == 0) {
			if (b == 0)
				return "0";
			return ""+b+"j";
		}
		if (b == 0)
			return ""+a;
		if (b > 0)
			return ""+a+"+"+b+"j";
		return (""+a)+b+"j";
	}
}
