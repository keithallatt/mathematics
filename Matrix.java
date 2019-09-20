

public class Matrix {
	public static void main(String[]args) {
		Matrix m = Matrix.identity(3);
		
		m.set(1,0,3.0);

		System.out.println(m);				
		System.out.println(m.determinant());
	}

	double matrix[][];
	int width, height;

	public Matrix(int width, int height) {
		this.width = width;
		this.height = height;
		matrix = new double[height][width];
	
		for (int w = 0; w < width; w++)
			for (int h = 0; h < height; h++)
				matrix[h][w] = 0;
	}
	
	public double determinant() {
		if (width != height)
			throw new RuntimeException("Non-square matrices do not have determinants");
		int dim = width;
		
		if (dim == 1)
			return matrix[0][0];

		double running_total = 0;
		
		for (int i = 0; i < dim; i++) {
			double scalar = matrix[0][i];

			Matrix minor = new Matrix(dim-1, dim-1);
			for (int h = 1; h < dim; h++) {
				for (int a = 0; a < i; a++)
					minor.matrix[h-1][a] = matrix[h][a];
				for (int a = i+1; a < dim; a++)
					minor.matrix[h-1][a-1] = matrix[h][a];
				
			}

			running_total += Math.pow(-1, i+2) * scalar * minor.determinant(); 
		}
		return running_total;
	}

	public static Matrix identity(int dim) {
		Matrix m = new Matrix(dim, dim);
		for (int i = 0; i < dim; i++)
			m.set(i,i,1);

		return m;
	}

	public void set(int i, int j, double value) {
		matrix[i][j] = value;
	}

	public double get(int i, int j) {
		return matrix[i][j];
	}

	public Vector vectorization() {
		Vector v = new Vector(width*height);
		for (int j = 0; j < width; j++)
			for (int i = 0; i < height; i++)
				v.set(j*height + i,  matrix[i][j]);
		return v;
	}

	public String toString() {
		String[] rows = new String[matrix.length];
		for (int i = 0; i < rows.length; i++)
			rows[i] = "|\t";
		
		for (int column = 0; column < matrix[0].length; column ++) {
			int maxLength = 0;
			for (int row = 0; row < matrix.length; row ++) { 
				rows[row] += matrix[row][column];

				maxLength = Math.max(maxLength, rows[row].length());	
			}
			
			for (int row = 0; row < matrix.length; row ++) {
				while (rows[row].length() <= maxLength)
					rows[row] += " ";
				rows[row] += "\t";
			}
		}
		
		
		for (int i = 0; i < rows.length; i++)
			rows[i] += "|";
		

		return String.join("\n", rows);	
	}
}

