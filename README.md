# mathematics
Mathematics related structures written in Java

## Fractions

Fractions, (equiv. Rational Numbers, q &#x2208; &#x211a;) are the set of all numbers q = a / b, for a and b in the integers, b &ne; 0. Binary operations include addition, subtraction, multiplication, division. Exponentiation is defined for a rational base and integer power. The unary operation, the reciprocal, is defined for all non-zero rational numbers.

## Complex Numbers

Complex numbers, one of three hypercomplex number systems, are an extension of the real numbers, (z &#x2208; &#8450; = &#x211D; + &#x211D;**i**) by adjoining the imaginary unit **i**, where **i**<sup>2</sup> = -1.

## Dual Numbers

Dual numbers, one of three hypercomplex number systems, are an extension of the real numbers, (&#x211D; + &#x211D;**&epsi;**) by adjoining the imaginary unit **&epsi;**, where **&epsi;**<sup>2</sup> = 0.

## Hyperbolic Numbers

Hyperbolic numbers, one of three hypercomplex number systems, are an extension of the real numbers, (&#x211D; + &#x211D;**j**) by adjoining the imaginary unit **j**, where **j**<sup>2</sup> = 1.

## Quaternions

Quaternions, often denoted as, h =
a + b**i** + c**j** + d**k** &#x2208; &#x210d;,
where **i**, **j**, and **k** are unit vectors in &#x211d;<sup>3</sup>. This is often described as an extension of the complex numbers (&#x210d; = &#x2102; + &#x2102;**j**) because taking complex numbers z<sub>1</sub> = a+b**i** and z<sub>2</sub> = c+d**i**, (a+b**i**) + (c+d**i**)**j** = a+b**i** + c**j** + d**ij** = a+b**i** + c**j** + d**k**.

This can also be redefined in terms of a scalar added to a vector in &#x211d;<sup>3</sup>:

a + b**i** + c**j** + d**k** = r + v&#8407;, s.t. r = a, v&#8407; = b**i** + c**j** + d**k**.

The definition for Quaternion addition via the scalar and vector method is:

(r<sub>1</sub>, v&#8407;<sub>1</sub>) + (r<sub>2</sub>, v&#8407;<sub>2</sub>) = (r<sub>1</sub> + r<sub>2</sub>, v&#8407;<sub>1</sub> + v&#8407;<sub>2</sub>)

The definition for Quaternion multiplication via the scalar and vector method is:

(r<sub>1</sub>, v&#8407;<sub>1</sub>)(r<sub>2</sub>, v&#8407;<sub>2</sub>) = (r<sub>1</sub>r<sub>2</sub> - v&#8407;<sub>1</sub> &#x22c5; v&#8407;<sub>2</sub>, r<sub>1</sub>v&#8407;<sub>2</sub> + r<sub>2</sub>v&#8407;<sub>1</sub> + v&#8407;<sub>1</sub> &#x2a2f; v&#8407;<sub>2</sub>)

The definition for Quaternion reciprocation via the scalar and vector method is:

 (r, v&#8407;)<sup>-1</sup> = (r / (r<sup>2</sup> + v&#8407; &#x22c5; v&#8407;), -v&#8407; / (r<sup>2</sup> + v&#8407; &#x22c5; v&#8407;))

## Matrices

Matrices are 2-dimensional grids of numbers. These are often used for linear transformations from &#x211D;<sup>m</sup> to &#x211D;<sup>n</sup>, where the matrix is n by m in size. Square matrices have special properties, such as the existence of the determinant, and in special cases, can be deemed invertible (determinant &ne; 0) or nilpotent (m<sup>n</sup> = 0 for some n, m &#x2208; M, n &#x2208; &#x2115;). These can also be used to solve systems of linear equations. 

## Vectors

Vectors represent points, directions and other components in n-space (n being the dimension of the vector). These can be thought of as column matrices, or a m by 1 matrix. These are used primarily as a tool to describe a direction with a particular magnitude. Various other operations are defined for vectors, such as inner and outer products, or cross products.

# Operations

| Structure     | Add. | Sub. | Mult. | Div. | Non-Int Pow | Exponent |
|---------------|------|------|-------|------|-------------|----------|
| Real (double) | Yes  | Yes  | Yes   | Yes  | Yes         | Yes      |
| Fraction      | Yes  | Yes  | Yes   | Yes  | No          | No       |
| Complex       | Yes  | Yes  | Yes   | Yes  | Yes         | Yes      |
| Dual          | Yes  | Yes  | Yes   | Yes  | Yes         | Yes      |
| Hyperbolic    | Yes  | Yes  | Yes   | Yes  | Yes         | Yes      |
| Quaternions   | Yes  | Yes  | Yes   | Yes  | No          | No       |
| Matrices      | Yes  | Yes  | Yes   | No   | Sometimes<sup>1</sup>| Sometimes<sup>2</sup> |
| Vectors       | Yes  | Yes  | Yes   | No   | No          | No       |

<sup>1</sup> Matrix must have non-zero determinant.

<sup>2</sup> Matrix must be nilpotent (m<sup>n</sup> = 0 for some n, m &#x2208; M, n &#x2208; &#x2115;) or diagonalizable (M = PDP<sup>-1</sup> for some P and D diagonal).
