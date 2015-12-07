Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

public class Solution {
    public int[] plusOne(int[] digits) {
      int size = digits.length;
		int carries = 1;
		for (int i = size - 1; i >= 0 && carries > 0; i--) {
			int sum = digits[i] + carries;
			digits[i] = sum % 10;
			carries = sum / 10;
		}

		if (carries == 0) {
			return digits;
		} else {
			
			int[] temp = shift(digits);
			return temp;
		}
	}

	public int[] shift(int[] digits) {
		int size = digits.length;
		int[] newdigits = new int[size + 1];
		for (int i = size - 1; i >= 0; i--) {
			newdigits[i + 1] = digits[i];
		}
		newdigits[0] = 1;
		return newdigits;
	}

}
