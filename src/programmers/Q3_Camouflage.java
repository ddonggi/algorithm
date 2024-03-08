package programmers;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

/**
 * PackageName : programmers
 * FileName : Q3_Camouflage
 * Author : dglee
 * Create : 3/8/24 4:12 PM
 * Description :
 **/

public class Q3_Camouflage {
    public static void main(String[] args) {
        Q3_Camouflage main = new Q3_Camouflage();
//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        String[][] clothes = {{"crow_mask", "headgear"}, {"blue_sunglasses", "eyewear"}, {"smoky_makeup", "face"},{"smoky_makeup", "upper"}};
        main.solution(clothes);
    }
 /**   1. 문제설명
    코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
    예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
    다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.

    종류	|이름
    ---------
    얼굴	|동그란 안경, 검정 선글라스
    상의	|파란색 티셔츠
    하의	|청바지
    겉옷	|긴 코트
    코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다.
    예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
    착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
    코니는 하루에 최소 한 개의 의상은 입습니다.
    코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

  */
/** 2. 제한사항
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 */

/** 3. 입출력예제
 * clothes                                                                                      |	return
 * [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]   |	5
 * [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	            |   3
 * 입출력 예 설명
 * 예제 #1
 * headgear에 해당하는 의상이 yellow_hat, green_turban이고
 * eyewear에 해당하는 의상이 blue_sunglasses 이므로 아래와 같이 5개의 조합이 가능합니다.
 * 1. yellow_hat
 * 2. blue_sunglasses
 * 3. green_turban
 * 4. yellow_hat + blue_sunglasses
 * 5. green_turban + blue_sunglasses
 * 예제 #2
 * face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
 * 1. crow_mask
 * 2. blue_sunglasses
 * 3. smoky_makeup
 */

/**4. 내 풀이
 * (어떤 자료구조나 알고리즘을 쓸 것인지, 근거)
 */
/*    public int solution(String[][] clothes) {
        int answer = 0;
        //카테고리 별로 map 에 넣는다
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            //clothes[i][1]//의상의 카테고리
                map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);// 처음 넣는거면 0넣고+1/ 있으면거기에 +1
        }
        System.out.println("map = " + map.entrySet());
        //카테고리의 총 value 를 더한다
        for(int value : map.values()){
            answer+=value;
            System.out.println("answer="+answer);
        }
        //카테고리별로 곱셈을 한다
        int gop=1;
        for(int value : map.values()){
            if(map.values().size()>1) {//카테고리가 1 이상 일때만
                gop *= value;
                System.out.println("gop = " + gop);
            }
        }
        // 둘을 더한다.
//        if(map.values().size()>1)
        if(gop>1)
            answer=answer+gop;
        System.out.println("answer="+answer);
        return answer;
    }*/
/*    public int solution(String[][] clothes) {
        int answer = 1;
        //카테고리 별로 map 에 넣는다
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            //clothes[i][1]//의상의 카테고리
                map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);// 처음 넣는거면 0넣고+1/ 있으면거기에 +1
        }
        System.out.println("map = " + map.entrySet());
        //카테고리별로 안입는 경우를 추가한다.
        for(String key : map.keySet())
            map.put(key,map.get(key)+1);

        //카테고리별로 곱해준다
        for(int value : map.values())
            answer*=value;

        //마지막 전부 입지 않는 경우를 뺀다
        return answer-1;
    }*/

/**5. 다른사람 풀이
 * 문제 단순화 하기
 * 조합 찾기 : 옷을 종류별로 구분하여 몇 개의 조합이 가능한지 계산한다
 * 1.종류별로 분류 - 여러 옷을 종류별로 분류
 * 2.입지 않는 경우 추가 - 종류별로 하나씩 입지 않아도 되니, 입지 않아도 되는 경우를 추가한다.
 * 3.전체 조합 - 전체 조합을 계산하고, 아무것도 입지 않는 경우를 빼준다.
 * */
/*public int solution(String[][] clothes) {
    int answer=1;

    return answer -1;
}*/

    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                //각 옷의 종류를 기준으로 그룹화하고, 각 그룹 내에서는 종류별로 옷의 개수를 세어 맵으로 만든다.
                //이를 통해 각 옷 종류별로 몇 가지의 옷이 있는지를 파악할 수 있다.
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()//맵의 값들을 가져온다.
                .stream()
                //각 옷 종류별로 옷을 입는 경우의 수를 계산
                //각 옷 종류별로 옷을 입지 않는 경우도 고려해야 하므로, 각 값을 1씩 증가
                //이를 위해 reducing 함수를 사용하여 각 옷 종류별로 (옷의 개수 + 1)을 곱한다
                .reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1; //모든 옷을 입지 않는 경우도 고려해야 하므로 1을 뺀다
    }


/*
느낀점 : 아무것도 입지 않는 경우를 생각을 하지 못했다.
내가 짠 코드는 전체 카테고리 중 최소 1개씩은 다 입는 구조로 짜버렸다.
stream 을 잘 활용하는 사람이 많다.
*/
}
