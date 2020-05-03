/*
*   提示用户输入年月日信息，判断这一天是这一年中的第几天并打印
*   解题思路：
*   1. 提示用户按yyyy-MM-dd格式输入日期
*   2. 检查日期的合法性，包括日期格式是否正确或是否输入了不存在的日期
*   若不合法则报错并结束程序执行
*   3. 将合法的日期按年月日进行分解，并进入计算流程
*   4. 输出计算结果
*/ 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Module01Exercise01 {
    public static void main(String[] args) {
        //  提示用户按yyyy-MM-dd格式输入日期
        System.out.println("请输入年月日信息(2020-05-02)");
        //  创建扫描器并收集用户输入日期
        Scanner sc = new Scanner(System.in);
        String inputDate = sc.next();
        //  检查输入日期的合法性，若输入日期非法则报错并结束程序
        if (!checkInputDate(inputDate)) {
            System.out.println("您输入了错误的日期格式或不存在的日期，清重新输入");
            sc.close();
            return;
        } 
        //  按年月日分解用户输入日期        
        String[] dateInfo = inputDate.split("-");
        //  定义年月日变量并赋值
        int year = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int day = Integer.parseInt(dateInfo[2]);
        sc.close();
        //  输出计算结果  
        System.out.println("今天是"+year+"年的第"+analysis(year,month,day)+"天");
    }
    /**
     * @param inputDate 用户输入日期
     * @return  dateFlag 日期合法性判断结果
     */
    public static boolean checkInputDate(String inputDate) {
        //  合法日期的正规表达式
        String vaildDate = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        boolean dateFlag = true;
        //  合法日期判断
        Pattern pattern = Pattern.compile(vaildDate);
        Matcher matcher = pattern.matcher(inputDate);
        //  正则表达式的匹配结果
        dateFlag = matcher.matches();
        //  日期格式定义
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        try{  
            //  严格控制输入日期
            format.setLenient(false);
            format.parse(inputDate);
        }catch(final Exception e){
            //  产生一场视为日期非法并返回false
            dateFlag = false;
        }
        // 返回日期合法性检查结果
        return dateFlag;
    }
    /**
     *
     * @param year 日期分解后的年份
     * @param month 日期分解后的月份
     * @param day 日期分解后的天数
     * @return  这一年中的第几天计算结果
     */
    public static int analysis(int year, int month, int day){
        //  除当月天数以外的总天数
        int sumDay = 0;
        //  各月份的天数
        int[] month_date = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //  根据闰年平年决定2月的天数
        if((year%400)==0 || ((year%4)==0)&&((year%100)!=0)) {
            month_date[1] = 29;
        }
        //  计算除当月天数以外的总天数
        for (int i=0;i<month-1;i++) {
            sumDay += month_date[i];
        }
        //  返回总天数
        return sumDay+day;
        }
}