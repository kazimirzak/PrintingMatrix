public class printingMatrix {
	
	public String toString() {
		String result = "[";
		int[] maxNumberOfDigits = getMaxNumberOfIntegerDigitsInColumns(matrix);
		for(int i = 0; i < matrix.length; i++) {
			if(i != 0)
				result = result + " [";
			else
				result = result + "[";
			for(int j = 0; j < matrix[i].length; j++) {
				result = result + spaces((int) maxNumberOfDigits[j] - getNumberOfDigits(matrix[i][j]));
				result = result + (matrix[i][j] >= 0 ? " " : "");
				result = result + String.format("%.3f", matrix[i][j]); // Will round specified by the default locale
				if(j != matrix[i].length - 1)
					result = result + ", ";
			}
			if(i != matrix.length - 1)
				result = result + "],\n";
			else
				result = result + "]";
		}
		result = result + "]";
		return result;
	}

	private static int[] getMaxNumberOfIntegerDigitsInColumns(double[][] matrix) {
		int[] result = new int[matrix[0].length];
		for(int i = 0; i < matrix[0].length; i++) {
				for(int j = 0; j < matrix.length; j++) {
					int numberOfIntegerDigits = getNumberOfDigits(matrix[j][i]);
					if(numberOfIntegerDigits > result[i])
						result[i] = numberOfIntegerDigits;
				}
		}
		return result;
	}

	private static int getNumberOfDigits(double d) {
		int count;
		if(d < 1 && d >= 0)
			count = 1;
		else {
			if(d < 0)
				d = -1 * d;
			count = 0;
			while(d >= 1.0) {
				d = d / 10;
				count++;
			}
		}
		return count;
	}

	private static String spaces(int i) {
		String result = "";
		while(i > 0) {
			result += " ";
			i--;
		}
		return result;
	}
}
