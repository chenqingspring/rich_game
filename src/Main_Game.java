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

    public static Player player1 = new Player("Ǯ����","q",1);
    public static Player player2 = new Player("������","a",2);
    public static Player player3 = new Player("��С��","x",3);
    public static Player player4 = new Player("�𱴱�","j",4);



    public static void main(String[] args) throws IOException {
        String s;
        map.Init();
        map.Render();

        /*player1��һ������*/
        System.out.println("������rich������Ϸ"+ "\t");
        s = input(true);
        if(s.equals("rich")){
          System.out.println("������ҳ�ʼ�ʽ𣬷�Χ1000��50000��Ĭ��10000��"+ "\t");
          boolean flag1 = true;
          int totalMoney = 10000;
          while(flag1){
          String str = readString6("�����ʼ�ʽ�");  
            totalMoney = Integer.parseInt(str);
            player1.money = totalMoney;
            player2.money = totalMoney;
            player3.money = totalMoney;
            player4.money = totalMoney;
            if(totalMoney<1000 ||totalMoney>50000){
                 System.out.println("������ڹ涨��Χ������������!"+ "\t");
                 flag1 = true;

            }
              else if(totalMoney>=1000 && totalMoney<=50000)
                flag1 = false;
          }
         System.out.println("��ѡ��2~4λ���ظ���ң������ż��ɡ�"+"\n"+
                 "(1.Ǯ����; 2.������; 3.��С��; 4.�𱴱�):������12"+ "\t");

                String str = readString6("������ұ�ţ�");

            int[] intarry=new int[str.length()];
                  for(int i=0;i<str.length();i++){
                        intarry[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
                  }
                   for(int i=0;i<intarry.length;i++){
                       if(player1.playerNum == intarry[i]){
                           player1.is_Selected = true;
                           System.out.print("Ǯ���� ");
                       }
                       if(player2.playerNum == intarry[i]){
                           player2.is_Selected = true;
                           System.out.print("������ ");
                       }
                       if(player3.playerNum == intarry[i]){
                           player3.is_Selected = true;
                             System.out.print("��С�� ");
                       }
                       if(player4.playerNum == intarry[i]){
                           player4.is_Selected = true;
                             System.out.print("�𱴱� ");
                       }
                   }
                            System.out.println("��ѡ��");

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
             System.out.println("��Ϸ���˳�");
             System.exit(0);
         }

    }





    /*����̨�������ֵķ���*/

    private static String readString6(String prompt) {
        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("����ʹ�ÿ���̨");
        }
        return console.readLine(prompt);
    } 

    /*����̨��������ķ���*/
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
