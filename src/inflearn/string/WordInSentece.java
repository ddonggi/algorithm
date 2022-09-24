package inflearn.string;

import java.util.Scanner;

public class WordInSentece {
    /*
    * 3. 문장 속 단어
    설명
    한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
    문장속의 각 단어는 공백으로 구분됩니다.

    입력
    첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.

    출력
    첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
    단어를 답으로 합니다.

    예시 입력 1
    it is time to study
    예시 출력 1
    study
* */
    public String solution (String sentence) {
        String answer="";
        //공백으로 구분
        for(String word : sentence.split(" ")){
            if(word.length()>answer.length()) answer=word;
        }

        return answer;

    }
    public String solution2(String sentence){
        String answer="";
        int m = Integer.MIN_VALUE,pos;
        while((pos=sentence.indexOf(" "))!=1){
            String temp=sentence.substring(0,pos);
            int length = temp.length();
            if(length>m){
                m=length;
                answer=temp;
            }
            sentence=sentence.substring(pos+1);
        }
        if(sentence.length()>m) answer=sentence;
        return answer;
    }
    public static void main(String[] args) {
        WordInSentece wordInSentece = new WordInSentece();
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        System.out.println(wordInSentece.solution2(sentence));
    }
}
