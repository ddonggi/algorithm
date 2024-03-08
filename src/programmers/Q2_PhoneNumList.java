package programmers;

import java.util.*;

/**
 * PackageName : programmers
 * FileName : Q2_PhoneNumList
 * Author : dglee
 * Create : 3/8/24 12:50 AM
 * Description :
 **/

public class Q2_PhoneNumList {
    /*1. 문제
    전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
    전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

    구조대 : 119
    박준영 : 97 674 223
    지영석 : 11 9552 4421
    전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때
    어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록
    solution 함수를 작성해주세요.
    */

    /*2. 제한사항
    * phone_book 의 길이는 1 이상 1,000,000 이하 입니다.
    * 각 전화번호의 길이는 1 이상 20 이하입니다.
    * 같은 전화번호가 중복해서 들어있지 않습니다.
    */

    /*입출력 예제
    phone_book	                        |return
    --------------------------------------------
    ["119", "97674223", "1195524421"]	|false
    ["123","456","789"]	                |true
    ["12","123","1235","567","88"]	    |false

    입출력 예 설명
    입출력 예 #1 앞에서 설명한 예와 같습니다.
    입출력 예 #2 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
    입출력 예 #3 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
    */

    /*3. 내 풀이*/
    /* (어떤 자료구조나 알고리즘을 쓸 것인지, 근거)
    * 배열 내 다른 번호가 포함되면 접두사
    * 효율성에 대해서 아직 감이 잡히지 않음
    * 자료형이 String -> 형변환 ? or contains?
    */
    public static void main(String[] args) {
        Q2_PhoneNumList main = new Q2_PhoneNumList();
        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book1 = {"123","456","789"};
        String[] phone_book2 = {"12","123","1235","567","88"};
        List<String[]> phone_list = new ArrayList<>();
        phone_list.add(phone_book);
        phone_list.add(phone_book1);
        phone_list.add(phone_book2);
        phone_list.forEach(res->System.out.println(main.solution(res)));
//        System.out.println(main.solution(phone_book));
    }
/*    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int last = phone_book.length-1;

        Arrays.sort(phone_book);
        for(int i =0; i<phone_book.length; i++){
//            if(phone_book[i].length()==phone_book[i+1].length())
//                continue;
            if(phone_book[last].contains(phone_book[i])) {//접두사일때
                answer = false;
                break;
            }

        }
        //for문으로 하면, 시간낭비가 너무 심하다. Map으로 어떻게 할 수 있을까?
        return answer;
    }*/


    //문제를 완전히 파악하지 못했다. index 0 과 1 서로서로 포함되는지 확인해야했는데, 한 방향으로만 생각하였다.
    // 느낀점
    /*4. 다른 풀이*/
    //Loop 을 이용 -> X
    //Sorting / Loop 이용
/*    public boolean solution(String[] phone_book){
        boolean answer=true;
        //1. phone_book 을 정렬한다.
        Arrays.sort(phone_book);
        //2. 1중 loop 를 돌면서 앞번호가 뒷번호의 접두어 인지 확인한다.
        for(int i=0; i< phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) { //뒷번호가 앞번호로 시작하면
                return false;
            }
        }
        //3. 여기까지 오지 못했다면 접두어가 없는 것이다.
        return answer;
    }*/
    //Hash 를 이용
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        //1. HashMap을 만든다
        HashMap<String, Integer> map = new HashMap<>();
        // Map 에 전화번호를 넣는다
        for(String number:phone_book) {
            map.put(number,1);
        }
        //전화번호를 돌면서 해당 번호의 처음부터 맨뒤의 앞까지 자르면서 get으로 접두어가 있는지 찾아본다.
        for(int i =0; i< phone_book.length; i++){
            map.get(phone_book[i]);
            //해당 번호
            for(int j=0;j<phone_book[i].length()-1;j++){
                //만약 있다면 false 를 반환한다
//                if(map.get(phone_book[i].substring(0,j+1))!=null)
                if(map.containsKey(phone_book[i].substring(0,j+1)))
                    answer=false;
            }
        }
        //여기까지 왔다면 접두어가 없는 것이다.
        return answer;
    }


    // 느낀점 : Hash 에 대해 Key 에 충돌했던 적 없이 적재만 해봤어서 이러한 사고능력을 가지지 못한 것 같다.
}
