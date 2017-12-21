
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import longestCommonSubsequence.DynamicProgramming;
import longestCommonSubsequence.Recursive;

public class MainLCS {
	public static String generator(int nr) {
		char[] chars = "ABCD".toCharArray();
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
		PrintWriter writer = new PrintWriter("output/lcsOutput.out");

		String[] test = new String[6];
		String test2 = generator(8);
		test[0] = generator(3);
		test[1] = generator(5);
		test[2] = generator(8);
		test[3] = generator(10);
		test[4] = generator(15);
		test[5] = generator(20);

		long startTime = System.nanoTime();
		long estimatedTime = System.nanoTime() - startTime;

		for (int i = 0; i < test.length; i++) {
			writer.println("=== Test " + i + " ===");
			writer.println("String1: " + test[i]);
			writer.println("String2: " + test2);
			startTime = System.nanoTime();
			writer.println("LCS_Recursive: " + Recursive.LCS(test[i], test2));
			estimatedTime = System.nanoTime() - startTime;
			writer.println("Time: " + estimatedTime);
			startTime = System.nanoTime();
			writer.println("LCS_DynamicProgramming: "
					+ DynamicProgramming.LCS(test[i], test2));
			estimatedTime = System.nanoTime() - startTime;
			writer.println("Time: " + estimatedTime);
			writer.println("=== EndTest ===\n");
		}

		writer.close();
	}
}
