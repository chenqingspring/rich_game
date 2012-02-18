import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 21:53:24
 * To change this template use File | Settings | File Templates.
 */
public class Tool {

    public static Player  player = new Player();
    public static ColorOutput cop = new ColorOutput();
    
    public Tool(){

    }

      public void getTool(){

     int toolsNum = readNum();
              if(toolsNum == 1){
                  player.roadblockNum++;
                  player.money -= 50;
                  cop.println(player.getName()+"得到了1个路障：", player.color, Color.black);

            }else if(toolsNum == 2){
                  player.robotNum++;
                   player.money -= 50;
                  cop.println(player.getName()+"得到了1个机器娃娃：", player.color,Color.black);

            }else if(toolsNum == 3){
                  player.bombNum++;
                   player.money -= 50; 
                  cop.println(player.getName()+"得到了1个炸弹：", player.color,Color.black);
            }
      }

     public static int readNum() {
       String num = null;
       int toolsNum  = 0;
       try{

       InputStreamReader isr = new InputStreamReader(System.in);
		// 声明一个isr的缓冲区
		BufferedReader br = new BufferedReader(isr);
        num = br.readLine();
        try{
            toolsNum = Integer.parseInt(num);
            if(toolsNum == 1||toolsNum == 2||toolsNum == 3){

            }else{
                System.out.println("对不起，您输入编号123");
                 toolsNum = readNum();
            }
        }catch(NumberFormatException n) {
          System.out.println("对不起，您输入编号123");
          toolsNum = readNum();
        }
       } catch(IOException e){
          System.out.println("对不起，您输入编号123");
           toolsNum = readNum();
       }
        return toolsNum;
    }
}
