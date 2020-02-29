package com.bridgelabz.functionalprograms.utils;



import com.bridgelabz.errors.QuadraticRootsCantBeFoundForZeroOrLessValuesError;
import com.bridgelabz.exceptions.ArraySizeDoesNotSatisfyRequiredLengthException;
import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.exceptions.UnsupportedValuesForEuclideanDistanceCalculationException;

public class Utility {
	private Utility() {

	}

	// Sum of three Integer adds to ZERO logic
	/**
	 * 
	 * @param tripletsArray
	 * @return
	 * @throws ArraySizeDoesNotSatisfyRequiredLengthException
	 */
	public static int findTriplets(int tripletsArray[]) throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int length = tripletsArray.length;
		System.out.println();
		int i, j, k, count = 0;
		if (tripletsArray.length > 3) {
			for (i = 0; i < length; i++) {
				for (j = i + 1; j < length; j++) {
					for (k = j + 1; k < length; k++) {
						// printing distinct triples (i, j, k) where a[i] + a[j] + a[k] = 0
						if (tripletsArray[i] + tripletsArray[j] + tripletsArray[k] == 0) {
							System.out.println(tripletsArray[i] + " " + tripletsArray[j] + " " + tripletsArray[k]);
							count++;
						}
					}
				}
			}
			// return number of distinct triplets (i, j, k) such that a[i] + a[j] + a[k] = 0
			return count;
		} else {
			throw new ArraySizeDoesNotSatisfyRequiredLengthException("Enter atleast 3 inputs to find triplets");
		}
	}
	//sum of three longs adds to zero
	/**
	 * 
	 * @param tripletsArray
	 * @return
	 * @throws ArraySizeDoesNotSatisfyRequiredLengthException
	 */
	public static int findTriplets(long tripletsArray[]) throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int length = tripletsArray.length;
		System.out.println();
		int i, j, k, count = 0;
		if (tripletsArray.length > 3) {
			for (i = 0; i < length; i++) {
				for (j = i + 1; j < length; j++) {
					for (k = j + 1; k < length; k++) {
						// printing distinct triples (i, j, k) where a[i] + a[j] + a[k] = 0
						if (tripletsArray[i] + tripletsArray[j] + tripletsArray[k] == 0) {
							System.out.println(tripletsArray[i] + " " + tripletsArray[j] + " " + tripletsArray[k]);
							count++;
						}
					}
				}
			}
			// return number of distinct triplets (i, j, k) such that a[i] + a[j] + a[k] = 0
			return count;
		} else {
			throw new ArraySizeDoesNotSatisfyRequiredLengthException("Enter atleast 3 inputs to find triplets");
		}
	}
	
	//some of three shorts adds to zero
	/**
	 * 
	 * @param tripletsArray
	 * @return
	 * @throws ArraySizeDoesNotSatisfyRequiredLengthException
	 */
	public static int findTriplets(short tripletsArray[]) throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int length = tripletsArray.length;
		System.out.println();
		int i, j, k, count = 0;
		if (tripletsArray.length > 3) {
			for (i = 0; i < length; i++) {
				for (j = i + 1; j < length; j++) {
					for (k = j + 1; k < length; k++) {
						// printing distinct triples (i, j, k) where a[i] + a[j] + a[k] = 0
						if (tripletsArray[i] + tripletsArray[j] + tripletsArray[k] == 0) {
							System.out.println(tripletsArray[i] + " " + tripletsArray[j] + " " + tripletsArray[k]);
							count++;
						}
					}
				}
			}
			// return number of distinct triplets (i, j, k) such that a[i] + a[j] + a[k] = 0
			return count;
		} else {
			throw new ArraySizeDoesNotSatisfyRequiredLengthException("Enter atleast 3 inputs to find triplets");
		}
	}
	
	//sum of three doubles adds to zero
	/**
	 * 
	 * @param tripletsArray
	 * @return
	 * @throws ArraySizeDoesNotSatisfyRequiredLengthException
	 */
	public static int findTriplets(double tripletsArray[]) throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int length = tripletsArray.length;
		System.out.println();
		int i, j, k, count = 0;
		if (tripletsArray.length > 3) {
			for (i = 0; i < length; i++) {
				for (j = i + 1; j < length; j++) {
					for (k = j + 1; k < length; k++) {
						// printing distinct triples (i, j, k) where a[i] + a[j] + a[k] = 0
						if (tripletsArray[i] + tripletsArray[j] + tripletsArray[k] == 0) {
							System.out.println(tripletsArray[i] + " " + tripletsArray[j] + " " + tripletsArray[k]);
							count++;
						}
					}
				}
			}
			// return number of distinct triplets (i, j, k) such that a[i] + a[j] + a[k] = 0
			return count;
		} else {
			throw new ArraySizeDoesNotSatisfyRequiredLengthException("Enter atleast 3 inputs to find triplets");
		}
	}
	
	// sum of three floats adds to zero
	/**
	 * 
	 * @param tripletsArray
	 * @return
	 * @throws ArraySizeDoesNotSatisfyRequiredLengthException
	 */
	public static int findTriplets(float tripletsArray[]) throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int length = tripletsArray.length;
		System.out.println();
		int i, j, k, count = 0;
		if (tripletsArray.length > 3) {
			for (i = 0; i < length; i++) {
				for (j = i + 1; j < length; j++) {
					for (k = j + 1; k < length; k++) {
						// printing distinct triples (i, j, k) where a[i] + a[j] + a[k] = 0
						if (tripletsArray[i] + tripletsArray[j] + tripletsArray[k] == 0) {
							System.out.println(tripletsArray[i] + " " + tripletsArray[j] + " " + tripletsArray[k]);
							count++;
						}
					}
				}
			}
			// return number of distinct triplets (i, j, k) such that a[i] + a[j] + a[k] = 0
			return count;
		} else {
			throw new ArraySizeDoesNotSatisfyRequiredLengthException("Enter atleast 3 inputs to find triplets");
		}
	}
	
	//sum of three bytes adds to zero
	/**
	 * 
	 * @param tripletsArray
	 * @return
	 * @throws ArraySizeDoesNotSatisfyRequiredLengthException
	 */
	public static int findTriplets(byte tripletsArray[]) throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int length = tripletsArray.length;
		System.out.println();
		int i, j, k, count = 0;
		if (tripletsArray.length > 3) {
			for (i = 0; i < length; i++) {
				for (j = i + 1; j < length; j++) {
					for (k = j + 1; k < length; k++) {
						// printing distinct triples (i, j, k) where a[i] + a[j] + a[k] = 0
						if (tripletsArray[i] + tripletsArray[j] + tripletsArray[k] == 0) {
							System.out.println(tripletsArray[i] + " " + tripletsArray[j] + " " + tripletsArray[k]);
							count++;
						}
					}
				}
			}
			// return number of distinct triplets (i, j, k) such that a[i] + a[j] + a[k] = 0
			return count;
		} else {
			throw new ArraySizeDoesNotSatisfyRequiredLengthException("Enter atleast 3 inputs to find triplets");
		}
	}
	// Euclidean Distance
		/**
		 * static method to calculate distance by computing distance =squareRoot((x1-x2)^2+(y*y)^2)
		 * 
		 * @param x
		 * @param y
		 * @return distance value 
		 */
		public static double euclideanDistance(int x2, int y2) throws UnsupportedValuesForEuclideanDistanceCalculationException{
			if(x2 < 0 || y2 < 0) {
				throw new UnsupportedValuesForEuclideanDistanceCalculationException("input expected only in numbers");
			}
			int x1 = 0;
			int y1 = 0;
			double xSquare = Math.pow((x1-x2), 2);
			double ySquare = Math.pow((y1-y2), 2);
			return Math.sqrt(xSquare + ySquare);
			
		}
	//Quadratic Equation
		/**
		 * This function is used to calculate the real and complex roots of any quadratic equation based on the value of delta
		 * @param a
		 * @param b
		 * @param c
		 * @return
		 */
		public static double[] quadraticRootsCalculator(int a, int b, int c) throws QuadraticRootsCantBeFoundForZeroOrLessValuesError{
			int delta = b * b - 4 * a * c;

			double[] roots = new double[2];
			// checking delta is greater than or not
			if (delta >= 0 && a != 0) {
				roots[0] = (-b + Math.sqrt(delta)) / (2.0 * a);
				roots[1] = (-b - Math.sqrt(delta)) / (2.0 * a);
			} else if (delta < 0 && a != 0) {
				delta = -(delta);
				roots[0] = (-b / 2.0 * a);
				roots[1] = (Math.sqrt(delta) / (2.0 * a));
			}else {
				throw new QuadraticRootsCantBeFoundForZeroOrLessValuesError("a values cannot be zero or less than zero in order to calculate roots");
			}
			return roots;
		}
		
		// Wind Chill logic
		/**
		 * static method to find Effective temperature of wind chill
		 * 
		 * @param t
		 * @param v
		 * @return double value
		 * @throws LessThanOrGreaterThanSpecifiedRangeException 
		 *
		 */
		public static double windChillTemperatureCalculator(int t, int v) throws LessThanOrGreaterThanSpecifiedRangeException {
			// checking if t and v values are in specified range
			if ((Math.abs(t) > 50) || (v < 3 || v > 120))
				throw new LessThanOrGreaterThanSpecifiedRangeException("Number enterd does not meet the specifed range");
			else
				return 35.74 + 0.6215 + (0.4275 * t - 35.) * Math.pow(v, 0.16);
		}

}
