/**
 * 
 */
package com.shettar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pradeep.Shettar
 *
 */
public class ChocolateProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer testCaseCount = Integer.parseInt(scanner.nextLine());

		for (int index = 0; index < testCaseCount; index++) {
			String peopleAndBoxCount = scanner.nextLine();
			Integer boxCount = Integer.parseInt(peopleAndBoxCount.split(" ")[1]);
			int max = 0;
			String sharedChocs = scanner.nextLine();
			String[] sharedChocsArr = sharedChocs.split(" ");
			List<Integer> sharedChocList = new ArrayList<>();
			for (String string : sharedChocsArr) {
				sharedChocList.add(Integer.parseInt(string));
			}
			for (int sharedChocIndex = 0; sharedChocIndex < sharedChocList.size() - 1; sharedChocIndex++) {
				int sum = sharedChocList.get(sharedChocIndex);
				if (sum % boxCount == 0 && max < sum / boxCount) {
					max = sum / boxCount;
				}
				for (int sharedChocNextIndex = sharedChocIndex + 1; sharedChocNextIndex < sharedChocList
						.size(); sharedChocNextIndex++) {
					sum = sum + sharedChocList.get(sharedChocNextIndex);
					if (sum % boxCount == 0 && max < sum / boxCount) {
						max = sum / boxCount;
					}
				}
			}
			System.out.println(max);
		}

	}

}
