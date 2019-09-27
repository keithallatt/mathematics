

/**
 * Dual numbers are an extension of the real numbers by adjoining a new element ε where ε^2 = 0.
 *
 * This class represents dual numbers in the form a+bε.
 */
public class DualNumber {
	double a, b;

	public DualNumber(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public DualNumber add(DualNumber other) {
		return new DualNumber(a + other.a, b + other.b);
	}

	public DualNumber subtract(DualNumber other) {
		return new DualNumber(a - other.a, b - other.b);
	}

	public DualNumber multiply(DualNumber other) {
		return new DualNumber(a * other.a, a * other.b + b * other.a);
	}

	public DualNumber divide(DualNumber other) {
		return new DualNumber(a / other.a, (b * other.a - a * other.b) / Math.pow(other.a, 2));
	}
	
	public DualNumber pow(DualNumber other) {
		double scalar = Math.pow(a, other.a + 1);
		double epsilon = (scalar * other. b * Math.log(a)) + (other.a * b);
		return new DualNumber(scalar, epsilon);
	}

	public DualNumber conjugate() {
		return new DualNumber(a, -b);
	}

	public String toString() {
		if (a == 0) {
			if (b == 0)
				return "0";
			return ""+b+"ε";
		}
		if (b == 0)
			return ""+a;
		if (b > 0)
			return ""+a+"+"+b+"ε";
		return (""+a)+b+"ε";
	}
}
