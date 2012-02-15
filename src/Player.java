import java.awt.*;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 21:52:26
 * To change this template use File | Settings | File Templates.
 */
public class Player {

   // src.src.Coordinate.src.Main_Game MG;

    //src.src.Coordinate.src.Map map;

    private String name = "";// 玩家姓名

    public String nameForStort = "";

    public int playerNum = 0;

    public Color color; //颜色输出属性

    public boolean is_Selected = false;
    
	public int money = 10000;// 玩家金钱

    public int points = 0;  //玩家点数

    public Coordinate coor = new Coordinate();// 玩家上次位置

    public int currentDiceNum;

	//public  int position = 0;

    public  int myBuildings[];

    public  int bombNum = 0;

    public  int roadblockNum = 0;

    public int robotNum = 0;

    	public Player(String name,String nameForStort,int playerNum,Color color) {
		this.name = name;
        this.nameForStort = nameForStort;
        this.playerNum = playerNum;
        this.color = color;
	}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*掷骰子*/


    public void roll_the_Dice(){
        Random random = new Random();

        int DiceNum =  Math.abs(random.nextInt(6) + 1);

         currentDiceNum = DiceNum;
    }



    public void showDiceNum(){

         System.out.println(this.getName() + "摇出的骰子点数是 "
							+ currentDiceNum + " 点");
    }

    
    public void walk(){

        int walkDist = currentDiceNum;
        if(coor.position < 69)
            coor.position =  coor.position +  walkDist;
        else if(coor.position >= 69)
            coor.position = 69 - coor.position +  walkDist;
	}



    public void diaplay() {
		System.out.println("当前玩家:");
		System.out.println(name + "\t");
		System.out.println(name + "的金钱:       " + "\t" + money);
        System.out.println(name + "的点数:       " + "\t" + points);
       // System.out.println(name + "的房屋数: " + "\t" + myBuildings.length);
        System.out.println(name + "的炸弹数:     " + "\t" + bombNum);
        System.out.println(name + "的路障数:     " + "\t" + roadblockNum);
        System.out.println(name + "的机器娃娃数: " + "\t" + robotNum);

	}


    

}
