

public class Vector {
	private double[] vector;
	public final int dimension;

	public Vector(double... values) {
		this(values.length);
		int i = 0;
		for (double v : values)
			vector[i++] = v;
	}

	public Vector(int dimensions) {
		dimension = dimensions;
		vector = new double[dimensions];
		for (int i = 0; i < dimensions; i++)
			vector[i] = 0.0;
	}

	public static Vector unitVector(int dimensions, int dimension_direction) {
		Vector v = new Vector(dimensions);
		v.vector[dimension_direction] = 1.0;
		return v;
	}

	public void set(int dim, double value) {
		vector[dim] = value;
	}

	public double get(int dim) {
		return vector[dim];
	}

	public Vector add(Vector other) {
		if (other.dimension != dimension)
			throw new RuntimeException("Vectors must have same dimension");
		
		Vector sum = new Vector(dimension);
		for (int i = 0; i < dimension; i++)
			sum.vector[i] = vector[i] + other.vector[i];
		return sum;
	}


	public Vector subtract(Vector other) {
		if (other.dimension != dimension)
			throw new RuntimeException("Vectors must have same dimension");
		
		Vector difference = new Vector(dimension);
		for (int i = 0; i < dimension; i++)
			difference.vector[i] = vector[i] - other.vector[i];
		return difference;
	}


	public Vector scalarProduct(double scalar) {
		Vector multiple = new Vector(dimension);
		for (int i = 0; i < dimension; i++)
			multiple.vector[i] = vector[i] * scalar;

		return multiple;
	}

	public Vector negative() {
		return scalarProduct(-1);
	}

	/*
	 * Cross product only exists in R^0, R^1, R^3 and R^7 as a function from R^n X R^n -> R^n, so we will define as [ R^n ]^(n-1) -> R^n
	 */
	public Vector crossProduct(Vector other) {
		// for now, only R3 allowed.
		if (dimension != 3 || other.dimension != 3)
			throw new RuntimeException("Must accomplish cross product in R^3 only.");
		
		double a = vector[0];
		double b = vector[1];
		double c = vector[2];
		double d = other.vector[0];
		double e = other.vector[1];
		double f = other.vector[2];

		return new Vector(
			b*f - c*e,
			c*d - a*f,
			a*e - b*d
		);
	}	

	public double innerProduct(Vector other) {
		if (other.dimension != dimension)
			throw new RuntimeException("Vectors must have same dimension");
		
		double total = 0.0;
		for (int i = 0; i < dimension; i++)
			total += vector[i] * other.vector[i];
		return total;
	}

	public Matrix outerProduct(Vector other) {
		Matrix m = new Matrix(dimension, other.dimension);

		for (int i = 0; i < dimension; i++)
			for (int j = 0; j < other.dimension; j++)
				m.set(i, j, vector[i]*other.vector[j]);
		
		return m;
	}

	public double norm() {
		double val = 0;
		for (double value : vector)
			val += Math.pow(value, 2);
		return Math.sqrt(val);
	}

	public String toString() {
		int maxLength = 0;
		for (double value : vector)
			maxLength = Math.max(maxLength, (""+value).length());
		
		String output = "";
		for (double value : vector) {
			String line = "" + value;
			while (line.length() < maxLength)
				line += " ";
			output += "| "+line+" |\n";
		}
		return output.trim();
	}
}	
