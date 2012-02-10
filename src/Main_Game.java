import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 21:52:10
 * To change this template use File | Settings | File Templates.
 */

public class Main_Game
{
    public static Map map = new Map();

	public static Plot plots = new Plot();

    public static Player player1 = new Player("钱夫人","q",1);
    public static Player player2 = new Player("阿土伯","a",2);
    public static Player player3 = new Player("孙小美","x",3);
    public static Player player4 = new Player("金贝贝","j",4);



    public static void main(String[] args) throws IOException {
        String s;
        map.Init();
        map.Render();

        /*player1第一次行走*/
        System.out.println("请输入rich运行游戏"+ "\t");
        s = input(true);
        if(s.equals("rich")){
          System.out.println("设置玩家初始资金，范围1000～50000（默认10000）"+ "\t");
          boolean flag1 = true;
          int totalMoney = 10000;
          while(flag1){
          String str = readString6("请输初始资金：");  
            totalMoney = Integer.parseInt(str);
            player1.money = totalMoney;
            player2.money = totalMoney;
            player3.money = totalMoney;
            player4.money = totalMoney;
            if(totalMoney<1000 ||totalMoney>50000){
                 System.out.println("输入金额不在规定范围，请重新输入!"+ "\t");
                 flag1 = true;

            }
              else if(totalMoney>=1000 && totalMoney<=50000)
                flag1 = false;
          }
         System.out.println("请选择2~4位不重复玩家，输入编号即可。"+"\n"+
                 "(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):如输入12"+ "\t");

                String str = readString6("请输玩家编号：");

            int[] intarry=new int[str.length()];
                  for(int i=0;i<str.length();i++){
                        intarry[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
                  }
                   for(int i=0;i<intarry.length;i++){
                       if(player1.playerNum == intarry[i]){
                           player1.is_Selected = true;
                           System.out.print("钱夫人 ");
                       }
                       if(player2.playerNum == intarry[i]){
                           player2.is_Selected = true;
                           System.out.print("阿土伯 ");
                       }
                       if(player3.playerNum == intarry[i]){
                           player3.is_Selected = true;
                             System.out.print("孙小美 ");
                       }
                       if(player4.playerNum == intarry[i]){
                           player4.is_Selected = true;
                             System.out.print("金贝贝 ");
                       }
                   }
                            System.out.println("被选中");

        //player1.diaplay();
            while(true){
                if(player1.is_Selected == true){                 
                    map.playerWalk(player1);
                }
                if(player2.is_Selected == true){
                    map.playerWalk(player2);
                }
                if(player3.is_Selected == true){
                    map.playerWalk(player3);
                }
                if(player4.is_Selected == true){
                    map.playerWalk(player4);
                }
            }
         }
        else if (s.equals("quit")){
             System.out.println("游戏已退出");
             System.exit(0);
         }

    }





    /*控制台读入数字的方法*/

    private static String readString6(String prompt) {
        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("不能使用控制台");
        }
        return console.readLine(prompt);
    } 

    /*控制台读入命令的方法*/
      public static String input(boolean inputstate) {
		String num1 = null;
        boolean flag = true;

        while(flag) {
		InputStreamReader isr = new InputStreamReader(System.in);
		// 声明一个isr的缓冲区
		BufferedReader br = new BufferedReader(isr);
		try {
			// 从命令行读入一行字
			num1 = br.readLine();
			if (inputstate) {
				if (!num1.equals("Y") && !num1.equals("N") && !num1.equals("roll")
                        && !num1.equals("rich")&& !num1.equals("quit"))
                   // flag = false;
					throw new IOException();
			}
		} catch (IOException ex) {
			// 程序IO异常处理
			System.out.println("对不起，您输入的格式不正确,请重新输入");
            flag = true;
        	// System.exit(0);
		}
        if(num1.equals("Y") || num1.equals("N") || num1.equals("roll")
                        || num1.equals("rich") || num1.equals("quit"))
                flag = false;
           // return num1;
	  }
            return num1;
    }
}
