/*
*   找出 1000 以内的所有完数并打印出来
*   解题思路：
*   1. 1000以内循环
*   2. 判断能否整除
*/ 
public class Module01Exercise02 {
    public static void main(String[] args) {
        System.out.print("1000以内的完数:");
        for (int i = 2; i < 1000; i++) {
            int sum=0;
            for (int j = 1; j < i; j++) {
                if(i%j==0){
                    sum+=j;
                }
            }
            if(i==sum){
                System.out.print(i+" ");
            }
        }
    }
}