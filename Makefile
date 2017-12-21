build:
	mkdir output
	find -name "*.java" > sources
	javac @sources -d src
	rm sources

run:
	java -cp src/ MainLPS
	java -cp src/ MainLCS

clean:
	rm src/longestPalindromicSubstring/*.class
	rm src/longestCommonSubsequence/*.class
	rm src/*.class
	rm -rf output
