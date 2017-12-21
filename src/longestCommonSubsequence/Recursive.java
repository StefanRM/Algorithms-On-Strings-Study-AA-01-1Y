package longestCommonSubsequence;

public class Recursive {
	// O(2^n)
	public static String LCS(String A, String B) {
		if (A.length() == 0 || B.length() == 0) {
			return "";
		}
		int lenA = A.length();
		int lenB = B.length();
		// check if last characters are same
		if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
			// Add 1 to the result and remove the last character from both
			// the strings and make recursive call to the modified strings.
			return LCS(A.substring(0, lenA - 1), B.substring(0, lenB - 1))
					+ A.charAt(lenA - 1);
		} else {
			// Remove the last character of String 1 and make a recursive
			// call and remove the last character from String 2 and make a
			// recursive and then return the max from returns of both recursive
			// calls
			if (LCS(A.substring(0, lenA - 1), B.substring(0, lenB))
					.length() >= LCS(A.substring(0, lenA),
							B.substring(0, lenB - 1)).length()) {
				return LCS(A.substring(0, lenA - 1), B.substring(0, lenB));
			} else {
				return LCS(A.substring(0, lenA), B.substring(0, lenB - 1));
			}
		}
	}
}
