

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
		if (dimension == 3 && other.dimension == 3) {
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
		} else if (dimension == 7 && other.dimension == 7) {
			double x1 = vector[0];	
			double x2 = vector[1];
			double x3 = vector[2];
			double x4 = vector[3];
			double x5 = vector[4];
			double x6 = vector[5];
			double x7 = vector[6];
			
			double y1 = other.vector[0];	
			double y2 = other.vector[1];
			double y3 = other.vector[2];
			double y4 = other.vector[3];
			double y5 = other.vector[4];
			double y6 = other.vector[5];
			double y7 = other.vector[6];
			
			return new Vector(
				(-x3*y2 + x2*y3 - x5*y4 + x4*y5 - x6*y7 + x7*y6),
				(-x1*y3 + x3*y1 - x6*y4 + x4*y6 - x7*y5 + x5*y7),
				(-x2*y1 + x1*y2 - x7*y4 + x4*y7 - x5*y6 + x6*y5),
				(-x1*y5 + x5*y1 - x2*y6 + x6*y2 - x3*y7 + x7*y3),
				(-x4*y1 + x1*y4 - x2*y7 + x7*y2 - x6*y3 + x3*y6),
				(-x7*y1 + x1*y7 - x4*y2 + x2*y4 - x3*y5 + x5*y3),
				(-x5*y2 + x2*y5 - x4*y3 + x3*y4 - x1*y6 + x6*y1)		
			);
		}
					


		throw new RuntimeException("Cross product in R^"+dimension+" not allowed.");
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
