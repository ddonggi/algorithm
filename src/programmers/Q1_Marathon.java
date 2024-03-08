package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : programmers
 * FileName : Q1_Marathon
 * Author : dglee
 * Create : 3/6/24 12:53 AM
 * Description :
 **/

public class Q1_Marathon {
    /*완주 하지 못한 선수*/
    /* 한 선수만 완주하지 못했다.
    * 단 한명의 선수를 제외하고는 모든 선수가 마라톤을 완주했습니다.
    *
    * 그 한명을 찾아라
    * 마라톤에 참여한 선수들의 이름이 담긴 배열 Participant
    * 완주한 선수들의 이름이 담긴 배열 completion 이 주어질 때,
    * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
    *
    * 제한사항
    * 마라톤 경기에 참여한 선수의 수는 1명 이상, 100,000명 이하 입니다.
    * completion 의 길이는 participant 의 길이보다 1 작습니다.
    * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    * 동명이인이 있을 수 있습니다.
    * */

    /* 원본 문제 */
/*    public String solution(String[] participant, String[] completion){
        String answer="";
        return answer;
    }

    public static void main(String[] args) {
        String[] part = {"let","kiki","eden"};
        String[] comp = {"eden","kiki"};
        Q1_Marathon q1Marathon = new Q1_Marathon();
        System.out.println(q1Marathon.solution(part,comp));
    }*/

    /* 내 풀이 및 생각 */
    // 이름순으로 정렬 후 비교?
    //오름차순으로 정렬 후, 각 인덱스를 순회하면서 비교하고, 다를 경우 리턴한다
    /* 문제 단순화 하기 */
    public String solution(String[] participant, String[] completion){
        /* ------------------내 풀이 -----------------------*/
        // 참여 선수 participant
        // 완주 선수 completion
        // completion.length == participant.length-1
/*        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer="";
        for(int i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
            }else{
                answer = participant[participant.length-1];
            }
        }
        return answer;*/

        /* --------------------해시를 활용한 풀이 ---------*/
        String answer="";
        Map<String,Integer> map = new HashMap<>();
        //각 선수에 1, 동명이인이 있을경우 +1로 넣고 / 완주한 사람은 -1 한다. 없는 사람일 경우 1이 나오게 될 것
        //1. participant map을 만들고, 넣는다
        for(String player : participant){
            //getOrDefault key로 가져오는 값이 없으면, 기본값을 0으로 넣는다 거기에 +1 값을 준다
            //동명이인이 있을 수 있으니, 동명이인은 덮어씌워지지 않게 +1 로 넣는다
            map.put(player,map.getOrDefault(player,0)+1);
        }
        //2.completion map의 값들을 뺀다
        for(String player : completion){
            map.put(player, map.get(player)-1);
        }
        System.out.println("map = " + map);
        //value 가 0이 아닌 주자를 찾는다
        for(String key:map.keySet()){
            if(map.get(key)!=0)
                answer=key;
        }
        System.out.println("map = " + map);

        return answer;
    }

    public static void main(String[] args) {
        String[] part = {"leo","kiki","eden","kiki"};
        String[] comp = {"eden","kiki","kiki"};
        Q1_Marathon q1Marathon = new Q1_Marathon();
        System.out.println(q1Marathon.solution(part,comp));
    }
}
