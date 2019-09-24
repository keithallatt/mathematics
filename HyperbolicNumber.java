
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
