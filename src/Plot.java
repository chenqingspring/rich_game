import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 22:04:36
 * To change this template use File | Settings | File Templates.
 */
public class Plot {

    //public src.src.Coordinate.src.Main_Game mg;
    public Main_Game mg;
    
	public  int id = -1;// �ؿ���

    public  int area = 0;//�ضα��

    public Coordinate coor = new Coordinate();//�ض��ڵ�ͼ��λ��

    public int owner = 0;

	public  int type = 0;// ���Ƶ�ͼ����

	public  int price = 0;// �ؿ�۸�

	public  int roomLevel = 0;// ���ݵȼ�

	public  int change;// ��·��ؼ۸�

	public String showstr = "";// ��ʾ�ַ�

    public int points = 0;

    public ColorOutput cop = new ColorOutput();


    public Plot(){
    }
    
    public void drawPlot(boolean isEnd){

        switch (type) {

		case 0:
			showstr = "S";
			break;
		case 1:
			showstr = "0";
			break;
		case 2:
			showstr = "H";
			break;
		case 3:
			showstr = "T";
			break;
		case 4:
			showstr = "G";
            break;
		case 5:
			showstr = "P";
			break;
		case 6:
			showstr = "M";
			break;
		case 7:
			showstr = "$";
			break;
        case -1:
			showstr = " ";
			break;
        case 10:
            showstr = this.showstr;
            break;

    }
        if (!isEnd){// ����
            if(owner == 1||showstr == "q"){

                cop.print(showstr, Color.red,Color.black );

            }else if(owner == 2||showstr == "a"){
                 cop.print(showstr, Color.green,Color.black );

            }else if(owner == 3||showstr == "x"){

                cop.print(showstr, Color.blue,Color.black );

            }else if(owner == 4||showstr == "j"){

                cop.print(showstr, Color.yellow,Color.black );

            }
            else cop.print(showstr, Color.white,Color.black );
			//System.out.print(showstr);
        }

		else{
            if(owner == 1||showstr == "q"){

                cop.println(showstr, Color.red,Color.black );

            }else if(owner == 2||showstr == "a"){
                 cop.println(showstr, Color.green,Color.black );

            }else if(owner == 3||showstr == "x"){

                cop.println(showstr, Color.blue,Color.black );

            }else if(owner == 4||showstr == "j"){

                cop.println(showstr, Color.yellow,Color.black );

            }
            cop.println(showstr, Color.white,Color.black );
			//System.out.println(showstr);
        }
    }

    }
