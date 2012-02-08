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

        map.Init();
        map.Render();
        /*player1第一次行走*/
        //player1.diaplay();
        System.out.println(player1.getName() +"->待输入命令"+ "\t");

        String s = input(true);
        if(s.equals("Roll")){
        player1.roll_the_Dice();
        player1.showDiceNum();
        map.Render_after_player_walks(player1);
        }
        /*player1第二次行走*/
        //player1.roll_the_Dice();
        //player1.showDiceNum();
        //map.Render_after_player_walks(player1);

    }


      public static String input(boolean inputstate) {
		String num1 = null;

		InputStreamReader isr = new InputStreamReader(System.in);
		// 声明一个isr的缓冲区
		BufferedReader br = new BufferedReader(isr);
		try {
			// 从命令行读入一行字
			num1 = br.readLine();
			if (inputstate) {
				if (!num1.equals("Y") && !num1.equals("N") && !num1.equals("Roll"))
					throw new IOException();
			}
		} catch (IOException ex) {
			// 程序IO异常处理
			System.out.println("对不起，您输入的格式不正确");

			// System.exit(0);

		}
		return num1;
	}


}
