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

    public static Player player1 = new Player("Ǯ����","q",1);
    public static Player player2 = new Player("������","a",2);
    public static Player player3 = new Player("��С��","x",3);
    public static Player player4 = new Player("�𱴱�","j",4);



    public static void main(String[] args)
    {

        map.Init();
        map.Render();
        /*player1��һ������*/
        //player1.diaplay();
        System.out.println(player1.getName() +"->����������"+ "\t");

        String s = input(true);
        if(s.equals("Roll")){
        player1.roll_the_Dice();
        player1.showDiceNum();
        map.Render_after_player_walks(player1);
        }
        /*player1�ڶ�������*/
        //player1.roll_the_Dice();
        //player1.showDiceNum();
        //map.Render_after_player_walks(player1);

    }


      public static String input(boolean inputstate) {
		String num1 = null;

		InputStreamReader isr = new InputStreamReader(System.in);
		// ����һ��isr�Ļ�����
		BufferedReader br = new BufferedReader(isr);
		try {
			// �������ж���һ����
			num1 = br.readLine();
			if (inputstate) {
				if (!num1.equals("Y") && !num1.equals("N") && !num1.equals("Roll"))
					throw new IOException();
			}
		} catch (IOException ex) {
			// ����IO�쳣����
			System.out.println("�Բ���������ĸ�ʽ����ȷ");

			// System.exit(0);

		}
		return num1;
	}


}
