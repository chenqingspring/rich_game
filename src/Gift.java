import java.awt.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 21:54:54
 * To change this template use File | Settings | File Templates.
 */
public class Gift {

    public static Player  player = new Player();
    public static ColorOutput cop = new ColorOutput();

    public Gift(){

    }

      public void getGift(){

     int giftNum = readNum();
              if(giftNum == 1){
                  player.money+=2000;
                  cop.println(player.getName()+"�õ���2000���", player.color, Color.black);

            }else if(giftNum == 2){
                  player.points+=200;
                  cop.println(player.getName()+"�õ���200���� ��", player.color,Color.black);

            }else if(giftNum == 3){

                  cop.println(player.getName()+"�õ��������", player.color,Color.black);
            }
      }

     public static int readNum() {
       String num = null;
       int toolsNum  = 0;
       try{

       InputStreamReader isr = new InputStreamReader(System.in);
		// ����һ��isr�Ļ�����
		BufferedReader br = new BufferedReader(isr);
        num = br.readLine();
        try{
            toolsNum = Integer.parseInt(num);
            if(toolsNum == 1||toolsNum == 2||toolsNum == 3){

            }else{
                System.out.println("�Բ�����������123");
                 toolsNum = readNum();
            }
        }catch(NumberFormatException n) {
          System.out.println("�Բ�����������123");
          toolsNum = readNum();
        }
       } catch(IOException e){
          System.out.println("�Բ�����������123");
           toolsNum = readNum();
       }
        return toolsNum;
    }

    
}
