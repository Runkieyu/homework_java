/*
*   使用二维数组和循环实现五子棋游戏棋盘的绘制
*/ 
public class Module01Exercise05 {
    public static void main(String[] args) {
		//  棋盘初始化用一维数组
        char[] coordinate = {' ','0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        int size = coordinate.length;
        //  创建五子棋棋盘的二维数组
		String[][] board = new String[size][size];
		//  棋盘符号
		String mark = "+";
		//初始化棋盘，向二维数组中添加数据
		for(int i = 0;i<size;i++){
			for(int j = 0;j<size;j++){
				if (0==i&&0==j){
                    System.out.print("");
                }
                //第一列坐标定义
				if(j == 0){
                    board[i][j] = Character.toString(coordinate[i]);
                    //第一行坐标定义
				}else if(i == 0){
					board[i][j] = Character.toString(coordinate[j]);
				}else{
					board[i][j] = mark;
				}
			}
		}
		//打印棋盘
		for(int i = 0;i<size;i++){
			for(int j = 0;j<size;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
    }
}