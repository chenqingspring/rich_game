
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
        String s;
        map.Init();
        map.Render();

        /*player1��һ������*/
        System.out.println("������rich������Ϸ"+ "\t");
        s = input(true);
        if(s.equals("rich")){
        //player1.diaplay();
        System.out.println(player1.getName() +"->����������"+ "\t");

        s = input(true);
        if(s.equals("roll")){
        player1.roll_the_Dice();
        player1.showDiceNum();
        map.Render_after_player_walks(player1);
        System.out.println("�Ƿ���ô��յأ�"+ map.plots[player1.coor.x][player1.coor.y].price +"Ԫ��Y/N��"+ "\t");
            s = input(true);
            if(s.equals("Y")){
                  player1.money -= map.plots[player1.coor.x][player1.coor.y].price;   //��ȥplayer1���ʲ�
                  map.plots[player1.coor.x][player1.coor.y].owner = player1.playerNum;//�ѵع�ΪplayerNum����
                System.out.println("�ؿ�("+ map.plots[player1.coor.x][player1.coor.y].id + ")��"+player1.getName()+"ռ��" + "\t");
                System.out.println("ϵͳ�۳�"+player1.getName()+"��Ӧ���ʽ�"+map.plots[player1.coor.x][player1.coor.y].price+"Ԫ" + "\t");
            }
            else if (s.equals("N")){
                 System.out.println(player1.getName()+"����ռ�еؿ飨" + map.plots[player1.coor.x][player1.coor.y].id+ "��\t");
            } else if (s.equals("quit")){
                  System.out.println("��Ϸ���˳�");
                  System.exit(0);
              }

            }else if (s.equals("quit")){
             System.out.println("��Ϸ���˳�");
             System.exit(0);
            }
         }
        else if (s.equals("quit")){
             System.out.println("��Ϸ���˳�");
             System.exit(0);
         }
    }


      public static String input(boolean inputstate) {
		String num1 = null;
        boolean flag = true;

        while(flag) {
		InputStreamReader isr = new InputStreamReader(System.in);
		// ����һ��isr�Ļ�����
		BufferedReader br = new BufferedReader(isr);
		try {
			// �������ж���һ����
			num1 = br.readLine();
			if (inputstate) {
				if (!num1.equals("Y") && !num1.equals("N") && !num1.equals("roll")
                        && !num1.equals("rich")&& !num1.equals("quit"))
                   // flag = false;
					throw new IOException();
			}
		} catch (IOException ex) {
			// ����IO�쳣����
			System.out.println("�Բ���������ĸ�ʽ����ȷ,����������");
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
