package inflearn.string;

import java.util.Scanner;

/**
 * 문자 찾기
 * 한 개의 문자열을 입력 받고, 특정 문자를 입력 받아 해당 특정 문자가 입력 받은 문자열에 몇 개 존재하는지
 * 알아내는 프로그램을 작성하시오
 * 대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 입력
 *  첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어 진다.
 *  문자열은 영어 알파벳으로만 구성되어 있다.
 *
 * 출력
 *  첫 줄에 해당 문자의 개수를 출력한다.
 *
 * 예시
 *  Computercooler
 *  c
 *  2
*/
/*
public class Find {
    public int solution(String sentence, char text){
//        char[] characters = sentence.toCharArray();
        int count = 0;
        text = Character.toLowerCase(text);
        for(char alphabet:sentence.toCharArray()){
            if(alphabet==text){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Find find = new Find();
        Scanner scan = new Scanner(System.in);
        System.out.println("please type your sentence");
        String sentence = scan.nextLine().toLowerCase();
        System.out.println("sentence = " + sentence);
        System.out.println("please type your alphabet");
        char text = scan.next().charAt(0);
        System.out.println("text = " + text);
        System.out.println(find.solution(sentence,text));
    }
}
*/



/**
 * 문자 찾기
 * 한 개의 문자열을 입력 받고, 특정 문자를 입력 받아 해당 특정 문자가 입력 받은 문자열에 몇 개 존재하는지
 * 알아내는 프로그램을 작성하시오
 * 대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 입력
 *  첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어 진다.
 *  문자열은 영어 알파벳으로만 구성되어 있다.
 *
 * 출력
 *  첫 줄에 해당 문자의 개수를 출력한다.
 *
 * 예시
 * 입력
 *  Computercooler
 *  c
 *  출력
 *  2
 */
/*** 나의 풀이
* 대소문자 구분 x (ignore case로 통일) 길이 100 제한
* charAt 으로 char 받기
* 문자열 String 을 toCharArray로 배열로 변경
 * 순환하면서 체크
 * String class 메소드 : String.toLowerCase() / toUpperCase() / toCharArray()
 * Character class 메소드 : Character.toLowerCase(char c)
* */

public class Q_1_Find {
    public int solution(String str, char t){
        int answer=0;
        for(char target : str.toCharArray()){
            if(target==t) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Q_1_Find T = new Q_1_Find();
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine().toLowerCase();
        char t = Character.toLowerCase(scanner.next().charAt(0));
        System.out.println(T.solution(sentence,t));
    }
}
