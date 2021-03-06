
/**
 * Complex numbers are an extension of the real numbers by adjoining the element i where i^2 = -1. 
 * 
 * This class represents complex numbers in the form a+bi.
 */
public class ComplexNumber {
	private double a,b;

	public ComplexNumber(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public ComplexNumber add(ComplexNumber other) {
		return new ComplexNumber(a + other.a, b + other.b);
	}
	
	public ComplexNumber subtract(ComplexNumber other) {
		return new ComplexNumber(a + other.a, b + other.b);
	}

	public ComplexNumber multiply(ComplexNumber other) {
		return new ComplexNumber(a * other.a - b * other.b, a * other.b + b * other.a);
	}

	public ComplexNumber divide(ComplexNumber other) {
		ComplexNumber z = this.multiply(other.conjugate());
		
		z.a /= Math.pow(other.norm(), 2);
		z.b /= Math.pow(other.norm(), 2);

		return z;
	}
	
	public double norm() {
		return Math.sqrt(a*a + b*b);
	}

	public double arg() {
		return Math.atan2(a, b);
	}

	public ComplexNumber conjugate() {
		return new ComplexNumber(a, -b);
	}

	public ComplexNumber pow(ComplexNumber other) {
		double scalar = norm() / Math.exp(arg() * other.b);

		ComplexNumber exponent = new ComplexNumber(Math.cos(other.a * arg()), Math.sin(other.a * arg()));
		
		return exponent.multiply(new ComplexNumber(scalar, 0));
	}

	public String toString() {
		if (a == 0) {
			if (b == 0)
				return "0";
			return ""+b+"i";
		}
		if (b == 0)
			return ""+a;
		if (b > 0)
			return ""+a+"+"+b+"i";
		return (""+a)+b+"i";
	}
}
