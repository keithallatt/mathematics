
/**
 * Fraction: Represent a fraction as a ratio of 2 integers.
 */
public class Fraction {
	int a, b;

	public Fraction(int a, int b) {
		this.a = a;
		this.b = b;

		int g = gcd(a, b);
		this.a /= g;
		this.b /= g;
	}

	public Fraction(int a) {
		this(a, 1);
	}

	public Fraction() {
		this(0);
	}
	
	public Fraction add(Fraction other) {
		if (b == other.b) // already have common denominator
			return new Fraction(a + other.a, b);
		// common denom
		int common_denom = b * other.b;
		
		int numerator = a * other.b + other.a * b;
		
		return new Fraction(numerator, common_denom);
	}

	
	public Fraction subtract(Fraction other) {
		if (b == other.b) // already have common denominator
			return new Fraction(a + other.a, b);
		// common denom
		int common_denom = b * other.b;
		
		int numerator = a * other.b - other.a * b;
		
		return new Fraction(numerator, common_denom);
	}


	public Fraction multiply(Fraction other) {
		return new Fraction(a * other.a, b * other.b);
	}

	public Fraction divide(Fraction other) {
		return new Fraction(a * other.b, b * other.a);
	}

	public Fraction reciprocal() {
		return new Fraction(b, a);
	}

	public String toString() {
		if (b == 1) return ""+a;
		if (a == 0) return "0";
		return ""+a+"/"+b;
	}

	private int gcd(int x, int y) {
		if (y == 0) return x;
		return gcd(y, x % y);
	}
}
