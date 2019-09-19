

public class Vector {
	private double[] vector;
	public final int dimension;

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

	public double dotProduct(Vector other) {
		if (other.dimension != dimension)
			throw new RuntimeException("Vectors must have same dimension");
		
		double total = 0.0;
		for (int i = 0; i < dimension; i++)
			total += vector[i] * other.vector[i];
		return total;
	}
}	
