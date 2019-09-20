

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
	double scalar;
	Vector vector;

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
	
	
	
}
