

/**
 * In mathematics, the quaternions are a number system that extends the complex numbers. 
 * They were first described by Irish mathematician William Rowan Hamilton in 1843 and 
 * applied to mechanics in three-dimensional space. A feature of quaternions is that 
 * multiplication of two quaternions is noncommutative. Hamilton defined a quaternion as 
 * the quotient of two directed lines in a three-dimensional space or equivalently as 
 * the quotient of two vectors.
 * 
 * i^2 = j^2 = k^2 = ijk = -1
 */
public class Quaternion {
	private double scalar;
	private Vector vector;

	public Quaternion() {
		this(0.0, 0.0, 0.0, 0.0);
	}

	public Quaternion(double a, double b, double c, double d) {
		this(a, new Vector(b, c, d));
	}

	public Quaternion(double scalar, Vector vector) {
		this.scalar = scalar;
		this.vector = vector;
	}
	
	public Quaternion add(Quaternion other) {
		return new Quaternion(scalar + other.scalar, vector.add(other.vector));
	}	
	
	public Quaternion subtract(Quaternion other) {
		return new Quaternion(scalar - other.scalar, vector.subtract(other.vector));
	}

	public Quaternion multiply(Quaternion other) {
		double r1 = scalar;
		double r2 = other.scalar;

		Vector v1 = vector;
		Vector v2 = other.vector;

		return new Quaternion(
			r1 * r2 - v1.innerProduct(v2),
			v2.scalarProduct(r1).add(v1.scalarProduct(r2)).add(v1.crossProduct(v2))
		);
	}

	public String toString() {
		String repr = ""+scalar;

		double b = vector.get(0);
		double c = vector.get(1);
		double d = vector.get(2);

		if (b > 0)
			repr += "+";
		if (b != 0)
			repr += ""+b+"i";
		
		if (c > 0)
			repr += "+";
		if (c != 0)
			repr += ""+c+"j";
		
		if (d > 0)
			repr += "+";
		if (d != 0)
			repr += ""+d+"k";
		
		return repr;
	}
}
