
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import longestPalindromicSubstring.BruteForce;
import longestPalindromicSubstring.CleverApproach;
import longestPalindromicSubstring.DynamicProgramming;
import longestPalindromicSubstring.Manacher;

public class MainLPS {
	public static String generator(int nr) {
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < nr; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String ex = sb.toString();
		return ex;
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("output/lpsOutput.out");

		String[] test = new String[10];
		test[0] = generator(10);
		test[1] = generator(50);
		test[2] = generator(100);
		test[3] = generator(500);
		test[4] = generator(750);
		test[5] = generator(1000);
		test[6] = generator(2500);
		test[7] = generator(5000);
		test[8] = generator(7500);
		test[9] = generator(10000);

		long startTime = System.nanoTime();
		long estimatedTime = System.nanoTime() - startTime;

		for (int i = 0; i < test.length; i++) {
			writer.println("=== Test " + i + " ===");
			writer.println("Input: " + test[i]);
			startTime = System.nanoTime();
			writer.println("LPS_BruteForce: "
					+ BruteForce.GetLongestPalindrome(test[i]));
			estimatedTime = System.nanoTime() - startTime;
			startTime = System.nanoTime();
			writer.println("Time: " + estimatedTime);
			startTime = System.nanoTime();
			writer.println("LPS_DynamicProgramming: "
					+ DynamicProgramming.longestPalindromeDP(test[i]));
			estimatedTime = System.nanoTime() - startTime;
			writer.println("Time: " + estimatedTime);
			startTime = System.nanoTime();
			writer.println("LPS_CleverApproach: "
					+ CleverApproach.longestPalindromeSimple(test[i]));
			estimatedTime = System.nanoTime() - startTime;
			writer.println("Time: " + estimatedTime);
			startTime = System.nanoTime();
			writer.println(
					"LPS_Manacher: " + Manacher.findLongestPalindrome(test[i]));
			estimatedTime = System.nanoTime() - startTime;
			writer.println("Time: " + estimatedTime);
			writer.println("=== EndTest ===\n");
		}

		writer.close();
	}

}
