import java.util.Arrays;

/*
*   实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。 
*   其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。 
*   其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。 
*/ 
public class Module01Exercise03 {
    public static void main(String[] args) {
        //  创建一个 1~33 的一维数组 redBalls 用于存放所有红球
        int[] redBalls = new int[33];
        for(int i=0;i<33;i++){
            redBalls[i]=i+1;
        }
        //  创建一个长度为 7 的一维数组 selectedBalls 用于存放随机生成的号码
        int[] selectedBalls=new int[7];  
        int j=0;
        //  创建一个长度为 33 的布尔型一维数组 flags 用于存放随机生成的号码的状态以判断是否重复出现
        boolean[] flags = new boolean[33];
        int index;
        for(int i=0;i<6;i++){
            do{
                //  产生随机数
                index = (int)(Math.random()*33+1);
                //  未重复出现的号码被赋值给 selectedBalls 来存放有效红球
                if(flags[index]==false){
                     selectedBalls[j++]=redBalls[index];
                    //  有效红球的生成状态变为 true 防止重复出现
                     flags[index]=true;
                     break;
                    }
                }while(flags[index]); 
            }
            //  随机生成一个 1~6 的蓝色球号码并存入 selectedBalls 的最后一位
            selectedBalls[6]=(int)(Math.random()*16+1);   
            //  输出生成的号码
            System.out.println("生成的双色球号码为： " + Arrays.toString(selectedBalls));
    }
}