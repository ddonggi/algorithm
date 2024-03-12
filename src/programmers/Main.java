package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : programmers
 * FileName : main
 * Author : dglee
 * Create : 3/10/24 5:46 PM
 * Description :
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        String input = br.readLine();
        main.solution(input,br);
    }
    public int solution(String input,BufferedReader br) throws IOException {
        String[] n = input.split(" ");
        int balance = Integer.parseInt(n[0]);
        int transactionCount = Integer.parseInt(n[1]);
        System.out.println("balance = " + balance);
        System.out.println("transactionCount = " + transactionCount);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<transactionCount; i++){
           input = br.readLine();
           String[] splitArray = input.split(" ");
           int value = Integer.parseInt(splitArray[1]);
            System.out.println("value = " + value);
            System.out.println("type = " + splitArray[0]);
            switch (splitArray[0]){
                case "deposit":
                    balance+=value;
                    break;
                case "pay":
                    if(balance>=value)balance-=value;
                    break;
                case "reservation":
/*                    if(!queue.isEmpty() ||balance<value){
                        System.out.println("put in queue!!");
                        queue.add(value);
                    }else{
                        balance-=value;
                    }*/
                    if(!queue.isEmpty()){
                        queue.add(value);
                        System.out.println("not empty put in queue!!");
                    }
                    else if(balance<value){
                        queue.add(value);
                        System.out.println("put in queue!!");
                    }
                    else balance-=value;
                    break;
            }
            System.out.println("balance = " + balance);
        }
        while (!queue.isEmpty()&&balance>=queue.peek()){
            System.out.println("queue.peek() = " + queue.peek());
            balance-=queue.poll();
            System.out.println("balance = " + balance);
        }
        return balance;
    }
}
