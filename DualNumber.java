

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
	
	public DualNumber(DualNumber other) {
		return new DualNumber(a + other.a, b + other.b);
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
