package theCodingInterview1;

public class Question1 {
	public static boolean isUniqueChars(String str) {
		if(str.length() > 128)
			return false;
		
		boolean[] char_set = new boolean[128];
		
		for(int i=0 ; i<str.length() ; i++) {
			int c = str.charAt(i);
			if(char_set[c])	return false;
			char_set[c] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for(String word : words)
			System.out.println(word + ": "+isUniqueChars(word));
		
	}

}

// ASCII 코드 문자열 개수 : 128개(공백포함)