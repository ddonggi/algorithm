package inflearn.string;

import java.util.Scanner;

/**
 * 2. 대소문자 변환
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 *
 * 예시 입력 1
 * StuDY
 * 예시 출력 1
 * sTUdy
 */
/*public class ToUpperToLower {
    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        for (char x : sentence.toCharArray()) {
            if (Character.isLowerCase(x))
                x = Character.toUpperCase(x);
            else
                x = Character.toLowerCase(x);
            answer.append(x);
        }
        return answer.toString();
    }

    public String ASCIISolution(String sentence) {
        StringBuilder answer = new StringBuilder();
        for (char x : sentence.toCharArray()) {
            if (65 <= x && x <= 90)//대문자일 경우
                answer.append((char) (x + 32));// 32를 더해줘서 소문자로 바꿔준다
            else
                answer.append((char) (x - 32));//아닌경우(소문자일경우) 32를 빼줘서 대문자로 바꿔준다
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        ToUpperToLower toUpperToLower = new ToUpperToLower();
        Scanner scan = new Scanner(System.in);
        String sentence = scan.next();
        System.out.println(toUpperToLower.ASCIISolution(sentence));
    }
}*/


/*
 *
 * 2. 대소문자 변환
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 *
 * 예시 입력 1
 * StuDY
 * 예시 출력 1
 * sTUdy
 * 2024/02/28
 * 나의 풀이
 * 소문자는 대문자로/ 대문자는 소문자로
 *
 * */
public class Q_2_ToUpperToLower {
    public String solution(String sentence){
        String solution="";
        for (char c : sentence.toCharArray()){
            if(Character.isLowerCase(c)){
                solution+=Character.toUpperCase(c);
            }else{
                solution+=Character.toLowerCase(c);
            }
        }
        return solution;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
//대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
        Q_2_ToUpperToLower tl = new Q_2_ToUpperToLower();
        System.out.println(tl.solution(sentence));
    }
}


