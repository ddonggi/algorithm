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
