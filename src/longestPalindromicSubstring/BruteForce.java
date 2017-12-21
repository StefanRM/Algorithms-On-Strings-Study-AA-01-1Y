package longestPalindromicSubstring;

public class BruteForce {
	// O(n^3)
	public static String GetLongestPalindrome(String input) {
		// Variable to keep max length of palindrome so far
		int lengthSofar = 0;
		// Variable to keep longest palindrome so far
		String resultstring = "";

		// Loop to get substring which starts with i char
		for (int i = 0; i < input.length(); i++) {
			String substring = "" + input.charAt(i);
			for (int j = i + 1; j < input.length(); j++) {
				substring += input.charAt(j);
				// Check is the substring is palindrome or not
				if (IsPalindrome(substring)) {
					if (lengthSofar < substring.length()) {
						lengthSofar = substring.length();
						resultstring = substring;
					}
				}
			}
		}
		if (!input.equals("") && resultstring.equals("")) {
			resultstring = "" + input.charAt(0);
		}

		return resultstring;
	}

	// Method to check whether string is palindrome or not
	public static boolean IsPalindrome(String input) {
		if (input == null)
			return false;

		if (input.length() == 1)
			return true;

		int halflen = input.length() / 2;
		int len = input.length() - 1;

		// Basically it compares the first char and last char until it reached
		// the halflength of the string
		for (int i = 0; i < halflen; i++) {
			if (input.charAt(i) != input.charAt(len)) {
				return false;
			}
			len--;
		}
		return true;

	}
}
