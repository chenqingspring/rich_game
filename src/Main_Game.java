import java.awt.*;
import java.io.BufferedReader;
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

    public static ColorOutput cop = new ColorOutput();

    public static Player player1 = new Player("Ǯ����","q",1,Color.red);
    public static Player player2 = new Player("������","a",2,Color.green);
    public static Player player3 = new Player("��С��","x",3,Color.blue);
    public static Player player4 = new Player("�𱴱�","j",4,Color.yellow);



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
          System.out.println("�����ʼ�ʽ�   ");
          String str = readString6();
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
         System.out.println("��ѡ��2~4λ���ظ���ң������ż��ɡ�");
            cop.print("(1.",Color.white,Color.black);
            cop.print(player1.getName(),player1.color,Color.black);
            cop.print("  ; 2.",Color.white,Color.black);
            cop.print(player2.getName(),player2.color,Color.black);
            cop.print("  ; 3.",Color.white,Color.black);
            cop.print(player3.getName(),player3.color,Color.black);
            cop.print("  ; 4.",Color.white,Color.black);
            cop.print(player4.getName(),player4.color,Color.black);
            cop.println("  ): ������12:",Color.white,Color.black);

             cop.print("��������ұ�ţ�",Color.white,Color.black);
            
                String str = readString6();

            int[] intarry=new int[str.length()];
                  for(int i=0;i<str.length();i++){
                        intarry[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
                  }
                   for(int i=0;i<intarry.length;i++){
                       if(player1.playerNum == intarry[i]){
                           player1.is_Selected = true;
                          cop.print(player1.getName() +"  ",player1.color,Color.black);
                       }
                       if(player2.playerNum == intarry[i]){
                           player2.is_Selected = true;
                           cop.print(player2.getName() +"  ",player2.color,Color.black);
                       }
                       if(player3.playerNum == intarry[i]){
                           player3.is_Selected = true;
                           cop.print(player3.getName() +"  ",player3.color,Color.black);
                       }
                       if(player4.playerNum == intarry[i]){
                           player4.is_Selected = true;
                           cop.print(player4.getName() +"  ",player4.color,Color.black);
                       }
                   }
                            cop.println("��ѡ��",Color.white,Color.black);
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

    private static String readString6() {
       String num = null;
       try{

       InputStreamReader isr = new InputStreamReader(System.in);
		// ����һ��isr�Ļ�����
		BufferedReader br = new BufferedReader(isr);
        num = br.readLine();
        try{
            int totalMoney = Integer.parseInt(num);
        }catch(NumberFormatException n) {
          System.out.println("�Բ���������ĸ�ʽ����ȷ,����������");
          num = readString6();
        }
       } catch(IOException e){
          System.out.println("�Բ���������ĸ�ʽ����ȷ,����������");
          num = readString6();
       }
        return num;
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
