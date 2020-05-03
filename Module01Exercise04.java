/*
*  自定义数组扩容规则，当已存储元素数量达到总容量的 80%时，扩容 1.5 倍。 
*  例如，总容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15
*/
import java.util.Arrays;
import java.util.Scanner;
public class Module01Exercise04 {
    public static void main(String[] args)throws InterruptedException {
        //  提示用户输入数组大小
        System.out.println("输入数组的大小:");
        //  创建扫描器收集用户输入内容
        Scanner sc = new Scanner(System.in);
        //  接收输入数组的大小size
        int size = sc.nextInt();	
        //  定义一个大小为size的数组arr[]	
        int[] arr = new int[size];
        //  提示用户依次输入数组中的每个元素 
        System.out.println("依次输入数组的每个元素:");
        //  设定数组容量的 80% 为安全大小
        int limitSize = (int)(arr.length * 0.8);
        //  在安全容量之内按用户输入元素顺序赋值给数组
		for (int i = 0; i < arr.length; i++) {
            if (i <limitSize ) {
                arr[i] = sc.nextInt();	//依次输入元素到数组arr[i]
            } else {
                //  当输入达到数组的安全容量时进行扩容
                System.out.println("数组容量已占用 80% 将进行扩容，请稍候");
                arr = expand(arr);
                //  设置一定时间间隔确保方法执行完毕
                Thread.sleep(5000);
                System.out.println("数组已扩容完成，扩容后的数组大小为" + arr.length + "  请继续输入");
                //  扩容完成后继续输入原本剩下的内容
                for (int j = limitSize; j < size; j ++) {
                    arr[j] = sc.nextInt();
                }
                break;
            }
        }
        //  输出数组内元素
		System.out.println("数组的元素为:" + Arrays.toString(arr));
		sc.close();	
    }   

    public static int[] expand(int[] arr){
        //定义两个数组，将arr数组扩容到原本容量的1.5倍
        int arr2[]= new int[(int)(arr.length*1.5)];
        //将数组arr的元素循环遍历到数组arr2中
        for (int i=0;i<arr.length;i++) {
            arr2[i]=arr[i];
        }
        //  返回扩容后的数组
        return arr2;
    }
}