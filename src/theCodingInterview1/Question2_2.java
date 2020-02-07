package theCodingInterview1;

public class Question2_2 {
	
	public static boolean permutation(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		int[] cnt = new int[128];
		
		for(int i=0 ; i<s.length() ; i++) {
			cnt[s.charAt(i)]++;
		}
		
		for(int i=0 ; i<t.length() ; i++) {
			cnt[t.charAt(i)]--;
			if(cnt[t.charAt(i)] < 0)	return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}
