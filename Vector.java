

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


	public Vector scalarMultiply(double scalar) {
		Vector multiple = new Vector(dimension);
		for (int i = 0; i < dimension; i++)
			multiple.vector[i] = vector[i] * scalar;

		return multiple;
	}

	/*
	 * Cross product only exists in R^0, R^1, R^3 and R^7 as a function from R^n X R^n -> R^n, so we will define as [ R^n ]^(n-1) -> R^n
	 */
	

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
}	
