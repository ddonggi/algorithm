package inflearn.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
    * 4. 단어 뒤집기
        설명
        N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

        입력
        첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
        두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.

        출력
        N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.

        예시 입력 1
        3
        good
        Time
        Big

        예시 출력 1
        doog
        emiT
        giB
    * */
public class ReverseWord {
    public void solution(String[] wordArray){
        int wordLength=0;
        for (String word : wordArray) { // 단어 하나씩 순회
            StringBuilder reverseWord = new StringBuilder();
            wordLength = word.length();
            for (int j = wordLength; j > 0; j--) {
                char[] chars = word.toCharArray();
                reverseWord.append(chars[j - 1]);
            }
            System.out.println(reverseWord);
        }
    }
    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        Scanner scan = new Scanner(System.in);
        System.out.println("몇 개의 단어를 입력하실 건가요?");
        int n = scan.nextInt();
        String[] wordArray = new String[n];
        for(int i=0; i<n;i++){
            System.out.println((i+1)+"번째 단어를 입력해 주세요");
            wordArray[i]=scan.next();
        }
        reverseWord.solution(wordArray);
    }
}
