import java.util.*;

public class main {
    public static String solution(String X, String Y) {
        String answer = "";
        char[] arrX = X.toCharArray();
        char[] arrY = Y.toCharArray();
        List<Integer> reverseX = new ArrayList<>();
        List<Integer> reverseY = new ArrayList<>();
        addList(reverseX,arrX);
        addList(reverseY,arrY);
        reverseX.sort(Collections.reverseOrder());
        reverseY.sort(Collections.reverseOrder());
        System.out.println(reverseX);
        System.out.println(reverseY);
        answer = compareXY(answer,reverseX,reverseY);
        System.out.println("answer:"+answer);
        return answer;
    }

    private static String compareXY(String answer,List<Integer> reverseX, List<Integer> reverseY) {
        StringBuilder answerBuilder = new StringBuilder(answer);
//        int xpoint = 0;
//        int ypoint = 0;
//        for(int i = xpoint; i<reverseX.size(); i++){
//            // System.out.println("x "+i+":"+reverseX.get(i));
//            for (int j = ypoint; j<reverseY.size(); j++) {
//                // System.out.println("y "+j+":"+reverseY.get(j));
//                if (reverseX.get(i)==reverseY.get(j)) {
//                    // System.out.println("same values! \n");
//                    answerBuilder.append(reverseX.get(i));
////                    xpoint++;
////                    ypoint++;
//                    reverseX.remove(i);
//                    reverseY.remove(j);
//                    break;
//                }
//            }
//        }
        int indexX = 0;
        int indexY = 0;
        while(indexX<reverseX.size()&&indexY<reverseY.size()){
            if(reverseX.get(indexX)==reverseY.get(indexY)) {
                answerBuilder.append(reverseX.get(indexX));
                indexX++;
                indexY++;
                if(answerBuilder.toString().equals("0"))
                    break;
            }
            else{
                if (reverseX.get(indexX)<reverseY.get(indexY))
                    indexY++;
                else{
                    indexX++;
                }
            }

        }
        if ( answerBuilder.length()==0){
            answerBuilder.append("-1");
        }
        String answerString = answerBuilder.toString();
        int answerInt = Integer.parseInt(answerString);
        answerString = String.valueOf(answerInt);
        return answerString;
    }

    public static void addList(List<Integer> reverseList, char[] arr){
        for(int i =0; i<arr.length; i++) {
            reverseList.add(Integer.parseInt(String.valueOf(arr[i])));
        }
    }


    // 2-----------------
    // want ????????? ?????? ??????
    // number ????????? ????????? ??????
    // discount ???????????? ??????

    // answer ????????? ???????????? ??? ?????? ???????????? ????????? ??? ??????

    // want map??? ?????? : (banana, 3),...
    // discount ?????? (number??? ??? ??????)
    // discountmap ??? ???????????? ????????? ??????
    // want map ??? discount map ??????
    // ???????????? ?????? ????????? ?????? length?????? ?????? ??????

    public static void main(String[] args) {
//        String x = "505765";
//        String y = "134600";
//        String x = "12321";
//        String y = "42531";
//        String answer = solution(x,y);


    }
}
