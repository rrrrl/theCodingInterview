package theCodingInterview1;

import java.util.Scanner;

public class Question3 {
	
	public static String charToStr(char[] arr) {
		String str = "";
		for(char c:arr) {
			if(c == 0)
				break;
			str += Character.toString(c);
		}
		return str;
	}
	
	public static void replaceSpaces(char[] arr, int trueLength) {
		int spaceCnt = 0, index = 0;
		for(int i=0 ; i<trueLength ; i++) {
			if(arr[i] == ' ') {
				spaceCnt++;
			}
		}
		
		index = trueLength + spaceCnt * 2;
		if(trueLength < arr.length)	arr[trueLength] = '\0';
		
		for(int i=trueLength-1 ; i>=0 ; i--) {
			if(arr[i] == ' ') {
				arr[index-1] = '0';
				arr[index-2] = '2';
				arr[index-3] = '%';
				index -= 3;
			} else {
				arr[index-1] = arr[i];
				index -= 1;
			}
		}
	}
	
	public static int findLastCharacter(char[] arr) {
		for(int i=arr.length -1 ; i>=0 ; i--) {
			if(arr[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
		str = scan.nextLine();
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, trueLength);	
		System.out.println("\"" + charToStr(arr) + "\"");
	}
}
