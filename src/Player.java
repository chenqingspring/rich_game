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

    private String name = "";// �������

    public String nameForStort = "";

    public int playerNum = 0;

    public Color color; //��ɫ�������

    public boolean is_Selected = false;
    
	public int money = 10000;// ��ҽ�Ǯ

    public int points = 0;  //��ҵ���

    public Coordinate coor = new Coordinate();// ����ϴ�λ��

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

/*������*/


    public void roll_the_Dice(){
        Random random = new Random();

        int DiceNum =  Math.abs(random.nextInt(6) + 1);

         currentDiceNum = DiceNum;
    }



    public void showDiceNum(){

         System.out.println(this.getName() + "ҡ�������ӵ����� "
							+ currentDiceNum + " ��");
    }

    
    public void walk(){

        int walkDist = currentDiceNum;
        if(coor.position < 69)
            coor.position =  coor.position +  walkDist;
        else if(coor.position >= 69)
            coor.position = 69 - coor.position +  walkDist;
	}



    public void diaplay() {
		System.out.println("��ǰ���:");
		System.out.println(name + "\t");
		System.out.println(name + "�Ľ�Ǯ:       " + "\t" + money);
        System.out.println(name + "�ĵ���:       " + "\t" + points);
       // System.out.println(name + "�ķ�����: " + "\t" + myBuildings.length);
        System.out.println(name + "��ը����:     " + "\t" + bombNum);
        System.out.println(name + "��·����:     " + "\t" + roadblockNum);
        System.out.println(name + "�Ļ���������: " + "\t" + robotNum);

	}


    

}
