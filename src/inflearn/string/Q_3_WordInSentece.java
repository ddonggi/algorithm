package inflearn.string;

import java.util.Scanner;

public class Q_3_WordInSentece {
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
        int min = Integer.MIN_VALUE;
        int index;
        //indexOf
        while((index=sentence.indexOf(" "))!=-1){ //공백이 나오는 곳을 찾고, 해당 인덱스번호 반환
            String temp=sentence.substring(0,index); //문장에서 자른 단어
            int wordLength = temp.length(); //단어 길이
            if(wordLength>min){ //단어 길이가 최솟값보다 길 경우
                min=wordLength; //최솟값에 현재 단어 길이
                answer=temp; //정답에 현재 단어 저장
            }
            sentence=sentence.substring(index+1);//해당 인덱스부터 맨 마지막까지만 잘라서 리턴
        }
        //남은 문장? 마지막으로 잘린 단어 이것이 answer의 단어보다 길경우 이것이 정답
        if(sentence.length()>min) answer=sentence;
        return answer;
    }
    public static void main(String[] args) {
        Q_3_WordInSentece wordInSentece = new Q_3_WordInSentece();
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        System.out.println(wordInSentece.solution2(sentence));
    }
}
