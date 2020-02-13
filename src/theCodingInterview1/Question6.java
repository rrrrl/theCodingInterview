package theCodingInterview1;

public class Question6 {
	
	public static String compressBad(String str) {
	
		//String resultStr = "";
		StringBuilder resultStr = new StringBuilder();
		int strCnt = 0;
		
		for(int i=0 ; i<str.length() ; i++) {
			strCnt++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				//resultStr += "" + str.charAt(i) + strCnt;
				resultStr.append(str.charAt(i));
				resultStr.append(strCnt);
				strCnt = 0;
			}
		}
		
		return (resultStr.length() > str.length()) ? str : resultStr.toString();
		
	}
	
	public static void main(String[] args) {
		String str = "aaaaabbbbaaaabbddc";
		System.out.println(str);
		System.out.println(compressBad(str));
	}

}
