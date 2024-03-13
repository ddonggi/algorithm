package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : programmers
 * FileName : Q2_Main
 * Author : dglee
 * Create : 3/10/24 7:21 PM
 * Description :
 **/

public class Q2_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> names = Arrays.asList(1, 4, 53);

        int budget = Integer.parseInt(br.readLine());//지원 예산
        int n = Integer.parseInt(br.readLine());// 활동의 수


//        StringTokenizer tokenizer = new StringTokenizer(br.readLine());// 활동비
        String[] activitiesBudget = br.readLine().split(" ");// 활동비
        int[] activities = new int[n];//활동의 수만큼 배열 생성
        for (int i = 0; i < n; i++) { //배열 초기화
            activities[i] = Integer.parseInt(activitiesBudget[i]);
        }
        System.out.println(solution(budget,activities));

        br.close();
    }

    public static int solution(int budget, int[] activities) {
        boolean[] availableBudget = new boolean[budget + 1]; //최고 예산
        availableBudget[0] = true; // 0원 예산은 항상 가능
        System.out.println("availableBudget = " + Arrays.toString(availableBudget));

        // 각 활동 비용에 대해 가능한 예산 배열 업데이트
        for (int i = 0; i < activities.length; i++) { //모든 활동마다
            for (int j = budget; j >= activities[i]; j--) {//예산이 가능한지
                availableBudget[j] |= availableBudget[j - activities[i]];//true or false
            }
        }
        System.out.println("availableBudget = " + Arrays.toString(availableBudget));

        int maxCost = 0;
        // 가능한 최대 비용 찾기
        for (int i = budget; i >= 0; i--) {
            if (availableBudget[i]) {
                maxCost = i;
                break;
            }
        }

        return maxCost;
    }
}
