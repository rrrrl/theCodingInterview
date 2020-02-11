package theCodingInterview1;

public class Question4 {
	
	public static boolean palidrome(String str) {
		char[] arr = str.toCharArray();
		int[] cnt = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		int val_z = Character.getNumericValue('z');
		int val_a = Character.getNumericValue('a');
		
		for(char c : arr) {
			int ic = Character.getNumericValue(c);
			if(val_z >= ic && val_a <= ic) {
				cnt[ic - val_a]++;
			}
		}
		
		int oddCnt = 0;
		
		for(int i : cnt) {
			if(i % 2 == 1) {
				oddCnt++;
				
				if(oddCnt > 1) {
					return false;
				}
			}
		}
				
		return true;
	}
	
	public static void main(String[] args) {
		String str = "Rats live on no evil starzq";
		System.out.println(palidrome(str));
	}

}

/*
 * 회문순열
 * 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절
 * */
