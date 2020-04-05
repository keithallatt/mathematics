import java.util.Arrays;

public class Matrix {
	public static void main(String[]args) {
		Matrix m = Matrix.identity(3);
		
		m.set(1,0,3.0);

		System.out.println(m);				
		System.out.println(m.vectorization());
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
	
	public double trace() {
		if (width != height)
			throw new RuntimeException("Trace not defined for non-square matrices");
		double trace = 0;
		for (int i = 0; i < width; i++)
			trace += get(i, i);
		return trace;
	}

	public Matrix inverse() {
		if (width != height)
			throw new RuntimeException("Non-square matrices do not have inverses");
		if (determinant() == 0)
			throw new RuntimeException("Singular matrices do not have inverses");
		
			
        	double[][] inverse = new double[width][height];

        	// minors and cofactors
        	for (int i = 0; i < width; i++)
        		for (int j = 0; j < height; j++)
				inverse[i][j] = Math.pow(-1, i + j) * minor(i, j).determinant();

        // adjugate and determinant
        double det = 1.0 / determinant();
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }
	
	Matrix inverse_matrix = new Matrix(width, height);
	
	for (int i = 0; i < width; i++)
		for (int j = 0; j < height; j++)
			inverse_matrix.set(i, j, inverse[i][j]);

        return inverse_matrix;
    }

    private Matrix minor(int row, int column) {
        double[][] minor = new double[width - 1][height - 1];

        for (int i = 0; i < width; i++)
            for (int j = 0; i != row && j < height; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        
	Matrix minor_matrix = new Matrix(width-1, height-1);
	for (int i = 0; i < width-1; i++)
		for (int j = 0; j < height-1; j++)
			minor_matrix.set(i, j, minor[i][j]);

	return minor_matrix;
    }

    private Matrix rref() {
        double[][] rref = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            rref[i] = Arrays.copyOf(matrix[i], matrix[i].length);

        int r = 0;
        for (int c = 0; c < rref[0].length && r < rref.length; c++) {
            int j = r;
            for (int i = r + 1; i < rref.length; i++)
                if (Math.abs(rref[i][c]) > Math.abs(rref[j][c]))
                    j = i;
            if (Math.abs(rref[j][c]) < 0.00001)
                continue;

            double[] temp = rref[j];
            rref[j] = rref[r];
            rref[r] = temp;

            double s = 1.0 / rref[r][c];
            for (j = 0; j < rref[0].length; j++)
                rref[r][j] *= s;
            for (int i = 0; i < rref.length; i++) {
                if (i != r) {
                    double t = rref[i][c];
                    for (j = 0; j < rref[0].length; j++)
                        rref[i][j] -= t * rref[r][j];
                }
            }
            r++;
        }

	Matrix reduced_row_echelon_form = new Matrix(width, height);
	for (int i = 0; i < width; i++)
		for (int j = 0; j < height; j++)
			reduced_row_echelon_form.set(i, j, rref[i][j]);

        return reduced_row_echelon_form;
    }

    private Matrix transpose() {
        Matrix transpose = new Matrix(height, width);
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
		transpose.set(j, i, get(i, j));

        return transpose;
    }
}

