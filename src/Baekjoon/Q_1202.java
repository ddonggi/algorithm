package Baekjoon;

/**
 * PackageName : Baekjoon
 * FileName : Q_1202
 * Author : dglee
 * Create : 2/12/24 2:53 PM
 * Description :
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1202 {
    /*보석 N개 있다.
각 보석은 무게 Mi와 가격 Vi를 가지고 있다.
가방 K개 각 가방에 담을 수 있는 최대 무게는 Ci이다.최대 한 개의 보석만 넣을 수 있다.

상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000) ( 보석, 가방 갯수)

다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000) ( 보석의 무게 및 가격)

다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000) (가방의 최대무게)

모든 숫자는 양의 정수이다.

보석 가격의 합의 최대값*/
//K만큼 반복
// 보석을 가방의 이하 인 무게만 뽑아서 내림차순 정렬, 다시 가격 내림차순으로 정렬

    /* 우선 순위 큐를 쓰지 않아 시간 초과*/
    public int solution(int N, int K,Scanner scan) {
        Map<Integer,Integer> diamondInfoMap = new HashMap<>();
        List<Integer> bagInfo = new ArrayList<>();
        for(int i=1; i<=N; i++){
//            System.out.println(N+"개 중"+i+"번째 보석의 무게 M 및 가격 V를 입력해 주세요");
            String[] MV = scan.nextLine().split(" ");
            int M = Integer.parseInt(MV[0]);
            int V = Integer.parseInt(MV[1]);
//            System.out.println("보석 무게 M = " + M);
//            System.out.println("보석 가격 V = " + V);
            diamondInfoMap.put(M,V);
        }
        for(int i=1;i<=K;i++){
//            System.out.println(K+"개 중"+i+"번째 가방의 최대무게 C를 입력해 주세요");
            int C = scan.nextInt();
//            System.out.println("가방무게 C = " + C);
            bagInfo.add(C);
        }
//        System.out.println("diamondInfoMap = " + diamondInfoMap);
//        System.out.println("bagInfo = " + bagInfo);

        List<Integer> priceList = new ArrayList<>();
        int totalPrice = 0;
//        Queue<Integer> diamondQueue = new PriorityQueue<>();
//        System.out.println("diamondInfo.keySet (weight list) = " + diamondInfoMap.keySet());
        int bagCount = bagInfo.size();
//        for(int bagWeightLimit:bagInfo){
        for(int j=0; j<bagCount; j++){
//            System.out.println("--------"+(j)+"번째 가방 시작--------");
//            System.out.println("bagCount = " + bagCount);
            int bagWeightLimit=bagInfo.get(j);
            Iterator<Integer> diamondIterator = diamondInfoMap.keySet().iterator();
            int diamondWeight;
            while(diamondIterator.hasNext()) {
                //                int diamondPrice = diamondInfo.get(diamondWeight);
                diamondWeight = diamondIterator.next();
//                System.out.println("diamondWeight = " + diamondWeight);
//                System.out.println("bagWeightLimit = " + bagWeightLimit);
                if (bagWeightLimit >= diamondWeight) { //가방의 무게가 다이아몬드의 무게보다 클 경우만 가격 담기
//                    System.out.println("가방의 무게"+bagWeightLimit+"가 다이아몬드의 무게"+diamondWeight+"보다 큽니다.");
                    priceList.add(diamondInfoMap.get(diamondWeight));
                }
                //diamondQueue.(diamondWeight);
            }
//            System.out.println("priceList = " + priceList);
//            System.out.println("diamondInfo.values() = " + diamondInfo.values());
            //값 중에 제일 큰 숫자 더하기

//            Collections.reverse(priceList);
            priceList.sort(Comparator.reverseOrder());
//            System.out.println("sorted price list = " +priceList);
            //가장 큰 가격의 보석을 담은 후 보석 맵에서 제거
            int sortedPrice = priceList.get(0);
//            System.out.println("sortedPrice = " + sortedPrice);
            totalPrice += sortedPrice;
//            System.out.println("Bf diamondInfoMap.keySet() = " + diamondInfoMap.keySet());
            Map<Integer,Integer> copyMap = new HashMap<>();
            copyMap = diamondInfoMap;
            for(int i=0;i<copyMap.keySet().size();i++){
                int key = (int) copyMap.keySet().toArray()[i];
                if(copyMap.get(key)==sortedPrice) {
                    diamondInfoMap.remove(key);
                }
            }
//            System.out.println("Af diamondInfoMap.keySet() = " + diamondInfoMap.keySet());
            priceList.clear();
//            System.out.println("diamondInfo = " + diamondInfo);
//            System.out.println("--------------");

        }

        return totalPrice;
//        System.out.println("diamondQueue = " + diamondQueue);
//        diamondQueue.stream().sorted().
//        int value = 2;
//        return value;
    }

    /* 우선 순위 큐 사용 */
    public int solution2(int N, int K,BufferedReader br) throws IOException {
        Map<Integer,Integer> diamondInfoMap = new HashMap<>();
        List<Integer> bagInfo = new ArrayList<>();
        for(int i=1; i<=N; i++){
//            System.out.println(N+"개 중"+i+"번째 보석의 무게 M 및 가격 V를 입력해 주세요");
            String[] MV = br.readLine().split(" ");
            int M = Integer.parseInt(MV[0]);
            int V = Integer.parseInt(MV[1]);
//            System.out.println("보석 무게 M = " + M);
//            System.out.println("보석 가격 V = " + V);
            diamondInfoMap.put(M,V);
        }
        for(int i=1;i<=K;i++){
//            System.out.println(K+"개 중"+i+"번째 가방의 최대무게 C를 입력해 주세요");
            int C = Integer.parseInt(br.readLine());
//            System.out.println("가방무게 C = " + C);
            bagInfo.add(C);
        }
//        System.out.println("diamondInfoMap = " + diamondInfoMap);
//        System.out.println("bagInfo = " + bagInfo);

        List<Integer> priceList = new ArrayList<>();
        int totalPrice = 0;
//        Queue<Integer> diamondQueue = new PriorityQueue<>();
//        System.out.println("diamondInfo.keySet (weight list) = " + diamondInfoMap.keySet());
        int bagCount = bagInfo.size();
//        for(int bagWeightLimit:bagInfo){
        for(int j=0; j<bagCount; j++){
//            System.out.println("--------"+(j)+"번째 가방 시작--------");
//            System.out.println("bagCount = " + bagCount);
            int bagWeightLimit=bagInfo.get(j);
            Iterator<Integer> diamondIterator = diamondInfoMap.keySet().iterator();
            int diamondWeight;
            while(diamondIterator.hasNext()) {
                //                int diamondPrice = diamondInfo.get(diamondWeight);
                diamondWeight = diamondIterator.next();
//                System.out.println("diamondWeight = " + diamondWeight);
//                System.out.println("bagWeightLimit = " + bagWeightLimit);
                if (bagWeightLimit >= diamondWeight) { //가방의 무게가 다이아몬드의 무게보다 클 경우만 가격 담기
//                    System.out.println("가방의 무게"+bagWeightLimit+"가 다이아몬드의 무게"+diamondWeight+"보다 큽니다.");
                    priceList.add(diamondInfoMap.get(diamondWeight));
                }
                //diamondQueue.(diamondWeight);
            }
//            System.out.println("priceList = " + priceList);
//            System.out.println("diamondInfo.values() = " + diamondInfo.values());
            //값 중에 제일 큰 숫자 더하기

//            Collections.reverse(priceList);
            priceList.sort(Comparator.reverseOrder());
//            System.out.println("sorted price list = " +priceList);
            //가장 큰 가격의 보석을 담은 후 보석 맵에서 제거
            int sortedPrice = priceList.get(0);
//            System.out.println("sortedPrice = " + sortedPrice);
            totalPrice += sortedPrice;
//            System.out.println("Bf diamondInfoMap.keySet() = " + diamondInfoMap.keySet());
            Map<Integer,Integer> copyMap = new HashMap<>();
            copyMap = diamondInfoMap;
            for(int i=0;i<copyMap.keySet().size();i++){
                int key = (int) copyMap.keySet().toArray()[i];
                if(copyMap.get(key)==sortedPrice) {
                    diamondInfoMap.remove(key);
                }
            }
//            System.out.println("Af diamondInfoMap.keySet() = " + diamondInfoMap.keySet());
            priceList.clear();
//            System.out.println("diamondInfo = " + diamondInfo);
//            System.out.println("--------------");

        }
        br.close();
        return totalPrice;
    }

/*
3 2
1 65
5 23
2 99
10
2
=164
*/
    public static void main(String[] args) throws IOException {
/*        Scanner scan = new Scanner(System.in);
//        System.out.println("보석 갯수 N 과 가방갯수 K 를 입력해 주세요.");
        String NKinput = scan.nextLine();
//        System.out.println("NK = " + NKinput);
        String[] NK = NKinput.split(" ");
        int N = Integer.parseInt(NK[0]);
//        System.out.println("N = " + N);
        int K = Integer.parseInt(NK[1]);
//        System.out.println("K = " + K);*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

//        Q_1202 question = new Q_1202();
        Q_1202 main = new Q_1202();

//        int solution = question.solution(NK,scan);
//        int price = question.solution(N,K,scan);
//        int price = main.solution(N,K,scan);
        int price = main.solution2(N,K,br);
//        System.out.println("price >>");
        System.out.println(price);
    }
}
