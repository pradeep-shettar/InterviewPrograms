/**
 * 
 */
package com.shettar.problem;

/**
 * @author Pradeep.Shettar
 *
 *         Given a number N, find the smallest number D such that D is divisible
 *         by N D is not equal to N sum of digits in D is equal to N
 * 
 */
public class NumberFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 40;
		for (int index = 2;; index++) {
			if (isSumOfDigitsEqualsInput((input * index), input)) {
				System.out.println(input * index);
				return;
			}
		}
	}

	/**
	 * @param dividend
	 * @param input
	 * @return
	 */
	private static boolean isSumOfDigitsEqualsInput(int possibleNumber, int input) {
		int dividend = possibleNumber;
		int sum = 0;
		int lastDigit = 0;
		while (dividend >= 10) {
			lastDigit = dividend % 10;
			sum = sum + lastDigit;
			dividend = dividend / 10;
		}
		sum = sum + dividend;
		return sum == input;
	}

}
