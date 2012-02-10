
/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 22:04:36
 * To change this template use File | Settings | File Templates.
 */
public class Plot {

    //public src.src.Coordinate.src.Main_Game mg;

	public  int id = -1;// 地块编号

    public  int area = 0;//地段编号

    public Coordinate coor = new Coordinate();//地段在地图的位置

    public int owner = 0;

	public  int type = 0;// 绘制地图类型

	public  int price = 0;// 地块价格

	public  int roomLevel = 0;// 房屋等级

	public  int change;// 过路买地价格

	public String showstr = "";// 显示字符

    public int points = 0;


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
        if (!isEnd)// 结束
			System.out.print(showstr);
		else
			System.out.println(showstr);
    }

    }
