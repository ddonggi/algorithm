package programmers;

/**
 * PackageName : programmers
 * FileName : Q4_NewIdeaRecommend
 * Author : dglee
 * Create : 3/8/24 5:18 PM
 * Description :
 **/

public class Q4_NewIdeaRecommend {
    public static void main(String[] args) {
        Q4_NewIdeaRecommend main = new Q4_NewIdeaRecommend();
//        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String new_id = "z-+.^.";
        main.solution(new_id);
    }
    /**1. 문제설명
     * 카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다.
     * "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서
     * 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
     * 다음은 카카오 아이디의 규칙입니다.
     *
     * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
     * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
     * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
     * "네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
     * 신규 유저가 입력한 아이디가 new_id 라고 한다면,
     *
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     *
     * 예를 들어, new_id 값이 "...!@BaT#*..y.abcdefghijklm" 라면, 위 7단계를 거치고 나면 new_id는 아래와 같이 변경됩니다.
     *
     * 1단계 대문자 'B'와 'T'가 소문자 'b'와 't'로 바뀌었습니다.
     * "...!@BaT#*..y.abcdefghijklm" → "...!@bat#*..y.abcdefghijklm"
     *
     * 2단계 '!', '@', '#', '*' 문자가 제거되었습니다.
     * "...!@bat#*..y.abcdefghijklm" → "...bat..y.abcdefghijklm"
     *
     * 3단계 '...'와 '..' 가 '.'로 바뀌었습니다.
     * "...bat..y.abcdefghijklm" → ".bat.y.abcdefghijklm"
     *
     * 4단계 아이디의 처음에 위치한 '.'가 제거되었습니다.
     * ".bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
     *
     * 5단계 아이디가 빈 문자열이 아니므로 변화가 없습니다.
     * "bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
     *
     * 6단계 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거되었습니다.
     * "bat.y.abcdefghijklm" → "bat.y.abcdefghi"
     *
     * 7단계 아이디의 길이가 2자 이하가 아니므로 변화가 없습니다.
     * "bat.y.abcdefghi" → "bat.y.abcdefghi"
     *
     * 따라서 신규 유저가 입력한 new_id가 "...!@BaT#*..y.abcdefghijklm"일 때, 네오의 프로그램이 추천하는 새로운 아이디는 "bat.y.abcdefghi" 입니다.
     */

    /**
     * [문제]
     * 신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
     */

    /**2. 제한사항
     * new_id는 길이 1 이상 1,000 이하인 문자열입니다.
     * new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
     * new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
    */

    /**3. 입출력예제
     *
     * no	new_id	result
     * 예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
     * 예2	"z-+.^."	"z--"
     * 예3	"=.="	"aaa"
     * 예4	"123_.def"	"123_.def"
     * 예5	"abcdefghijklmn.p"	"abcdefghijklmn"
     * 입출력 예 #1
     * 문제의 예시와 같습니다.
     *
     * 입출력 예 #2
     * 7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.
     *
     * 1단계 변화 없습니다.
     * 2단계 "z-+.^." → "z-.."
     * 3단계 "z-.." → "z-."
     * 4단계 "z-." → "z-"
     * 5단계 변화 없습니다.
     * 6단계 변화 없습니다.
     * 7단계 "z-" → "z--"
     *
     * 입출력 예 #3
     * 7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.
     *
     * 1단계 변화 없습니다.
     * 2단계 "=.=" → "."
     * 3단계 변화 없습니다.
     * 4단계 "." → "" (new_id가 빈 문자열이 되었습니다.)
     * 5단계 "" → "a"
     * 6단계 변화 없습니다.
     * 7단계 "a" → "aaa"
     *
     * 입출력 예 #4
     * 1단계에서 7단계까지 거치는 동안 new_id("123_.def")는 변하지 않습니다. 즉, new_id가 처음부터 카카오의 아이디 규칙에 맞습니다.
     *
     * 입출력 예 #5
     * 1단계 변화 없습니다.
     * 2단계 변화 없습니다.
     * 3단계 변화 없습니다.
     * 4단계 변화 없습니다.
     * 5단계 변화 없습니다.
     * 6단계 "abcdefghijklmn.p" → "abcdefghijklmn." → "abcdefghijklmn"
     * 7단계 변화 없습니다.
     */
    /**4. 내 풀이
            (어떤 자료구조나 알고리즘을 쓸 것인지, 근거)
     */

    public String solution(String new_id) {
        String answer = "";
        //아이디의 길이는 3자 이상 15자 이하여야 합니다.
        //아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
        //마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
        System.out.println("new_id = " + new_id);
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
//        System.out.println("1. new_id = " + new_id);
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String regex = "[^a-z0-9-_.]"; //제외할 패턴
        new_id = new_id.replaceAll(regex,"");
//        System.out.println("2. new_id = " + new_id);
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//        while (new_id.contains("..")){
//            new_id = new_id.replace("..",".");
//        }
        //정규식, .이 하나보다 많은 경우
        new_id = new_id.replaceAll("[.]+",".");
//        System.out.println("3. new_id = " + new_id);
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//        if(new_id.startsWith(".")) new_id=new_id.substring(1);
//        if(new_id.endsWith(".")) new_id=new_id.substring(0,new_id.length()-1);
        //.으로 시작하거나, .으로 끝나는 것
        new_id = new_id.replaceAll("^[.]|[.]$","");

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.isEmpty()) new_id="a";
        System.out.println("5. new_id = " + new_id);

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(new_id.length()>15) new_id=new_id.substring(0,15);
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.endsWith(".")) new_id=new_id.substring(0,new_id.length()-1);
        new_id = new_id.replaceAll("[.]$","");
//        System.out.println("6. new_id = " + new_id+ " legnth:"+new_id.length());

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length()<=2){
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while (!(2< new_idBuilder.length())) {
                new_idBuilder.append(new_idBuilder.substring(new_idBuilder.length() - 1));
            }
            new_id = new_idBuilder.toString();
            System.out.println("7. new_id = " + new_id);
        }
        answer =new_id;
        return answer;
    }


    /**5. 다른사람 풀이 */
/*    public String solution(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }*/


    /**6. 느낀점
     * 간결하고 효율적으로 짜는 고민을 많이 해야 할 것 같다.
     *
     * */
}
