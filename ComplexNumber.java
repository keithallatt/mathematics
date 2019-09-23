

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
}
