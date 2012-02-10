
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

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



    public static void main(String[] args)
    {
        String s;
        map.Init();
        map.Render();

        /*player1第一次行走*/
        System.out.println("请输入rich运行游戏"+ "\t");
        s = input(true);
        if(s.equals("rich")){
        //player1.diaplay();
        System.out.println(player1.getName() +"->待输入命令"+ "\t");

        s = input(true);
        if(s.equals("roll")){
        player1.roll_the_Dice();
        player1.showDiceNum();
        map.Render_after_player_walks(player1);
        System.out.println("是否购买该处空地，"+ map.plots[player1.coor.x][player1.coor.y].price +"元（Y/N）"+ "\t");
            s = input(true);
            if(s.equals("Y")){
                  player1.money -= map.plots[player1.coor.x][player1.coor.y].price;   //减去player1的资产
                  map.plots[player1.coor.x][player1.coor.y].owner = player1.playerNum;//把地归为playerNum所有
                System.out.println("地块("+ map.plots[player1.coor.x][player1.coor.y].id + ")被"+player1.getName()+"占有" + "\t");
                System.out.println("系统扣除"+player1.getName()+"相应的资金"+map.plots[player1.coor.x][player1.coor.y].price+"元" + "\t");
            }
            else if (s.equals("N")){
                 System.out.println(player1.getName()+"放弃占有地块（" + map.plots[player1.coor.x][player1.coor.y].id+ "）\t");
            } else if (s.equals("quit")){
                  System.out.println("游戏已退出");
                  System.exit(0);
              }

            }else if (s.equals("quit")){
             System.out.println("游戏已退出");
             System.exit(0);
            }
         }
        else if (s.equals("quit")){
             System.out.println("游戏已退出");
             System.exit(0);
         }
    }


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
