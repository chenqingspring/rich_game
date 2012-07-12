import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 21:49:33
 * To change this template use File | Settings | File Templates.
 */
public class Map {

    public Plot plots[][];// 地块类型

    public static Tool tool = new Tool();

    public static Gift gift = new Gift();

    public static ColorOutput cop = new ColorOutput();
    private static final int EMPTY_PLOT = 1;

    public Map() {
        plots = new Plot[8][29];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 29; j++) {
                plots[i][j] = new Plot();
            }
        }
    }

    /**
     * 初始化地图
     */
    public void init() {
        /** 坐标 按行打印数组 遍历 */
        initProperty();
        setID();
        setPoint();
        render();
    }

    private void initProperty() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 28; j++) {
                setPoint(i, j);
            }
        }
    }

    private void setPoint(int i, int j) {
        if (i == 0 && j == 0) {
            setFirstPlot(i, j);
        } else if (i == 0 && j >= EMPTY_PLOT && j <= 13) {
            setFirstArea(i, j);
        } else if (i == 0 && j >= 15 && j <= 27) {
            setSecondArea(i, j);
        } else if (i >= EMPTY_PLOT && i <= 6 && j == 28) {
            setThirdArea(i, j);
        } else if (i == 7 && j >= 15 && j <= 27) {
            setFourthArea(i, j);
        } else if (i == 7 && j >= EMPTY_PLOT && j <= 13) {
            setFifthArea(i, j);
        } else if (i == 0 && j == 14) {
            setHospital(i, j);
        } else if (i == 0 && j == 28) {
            setTools(i, j);
        } else if (i >= EMPTY_PLOT && i <= 6 && j == 0) {
            setDollarArea(i, j);
        } else if (i == 7 && j == 0) {
            setMine(i, j);
        } else if (i == 7 && j == 14) {
            setPrison(i, j);
        } else if (i == 7 && j == 28) {
            getGift(i, j);
        } else {
            setOthers(i, j);
        }
    }

    private void setOthers(int i, int j) {
        plots[i][j].type = -EMPTY_PLOT;
        plots[i][j].area = 0; // 其他地段标记为0
    }

    private void getGift(int i, int j) {
        plots[i][j].type = 4;
        plots[i][j].area = 0; // 其他地段标记为0
    }

    private void setPrison(int i, int j) {
        plots[i][j].type = 5;
        plots[i][j].area = 0; // 其他地段标记为0
    }

    private void setMine(int i, int j) {
        plots[i][j].type = 6;
        plots[i][j].area = 0; // 其他地段标记为0
    }

    private void setDollarArea(int i, int j) {
        plots[i][j].type = 7;
        plots[i][j].area = 0;
    }

    private void setTools(int i, int j) {
        plots[i][j].type = 3;
        plots[i][j].area = 0; // 其他地段标记为0
    }

    private void setHospital(int i, int j) {
        plots[i][j].type = 2;
        plots[i][j].area = 0; // 其他地段标记为0
    }

    private void setFifthArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 5;//地段五 标记为5
        plots[i][j].price = 300;
    }

    private void setFourthArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 4;//地段四 标记为4
        plots[i][j].price = 300;
    }

    private void setThirdArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 3;//地段三 标记为3
        plots[i][j].price = 500;
    }

    private void setSecondArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 2;//地段二 标记为2
        plots[i][j].price = 200;
    }

    private void setFirstArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = EMPTY_PLOT;//地段一 标记为1
        plots[i][j].price = 200;
    }

    private void setFirstPlot(int i, int j) {
        plots[i][j].type = 0;
        plots[i][j].area = 0;
    }
    /*设置plot的ID*/

    public void setID() {
        int num = 0;
        for (int j = 0; j < 29; j++) {
            plots[0][j].id = num;
//System.out.println(plots[0][j].id);
            num++;
        }

        for (int i = EMPTY_PLOT; i < 8; i++) {
            plots[i][28].id = num;
//System.out.println(plots[i][7].id);
            num++;
        }

        for (int j = 27; j >= 0; j--) {
            plots[7][j].id = num;
//System.out.println(plots[7][j].id);
            num++;
        }

        for (int i = 6; i >= EMPTY_PLOT; i--) {
            plots[i][0].id = num;
//System.out.println(plots[i][0].id);
            num++;
        }
    }


    /*设置矿地点数*/

    public void setPoint() {

        plots[EMPTY_PLOT][0].points = 60;
        plots[2][0].points = 80;
        plots[3][0].points = 40;
        plots[4][0].points = 100;
        plots[5][0].points = 80;
        plots[6][0].points = 20;

    }


/*画出地图内容*/

    private void render() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 29; j++) {
                if (j != 28) {
                    plots[i][j].drawPlot(false);
                }
                if (j == 28) {
                    plots[i][j].drawPlot(true);
                }
//                String something = plots[i][j].getSomething();
//                plots[i][j].getOutputColor();
//                System.out.println(something);
            }
        }
    }


    public void Render_after_player_walks(Player player) {
        player.walk();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 29; j++) {
                if (plots[i][j].id == player.coor.position) {
                    int temp_type = plots[i][j].type;
                    player.coor.x = i;
                    player.coor.y = j;
                    plots[i][j].type = 10;
                    plots[i][j].showstr = player.nameForStort;
                    render();
                    plots[i][j].type = temp_type;
                    //i = 8;j = 29;
                }
            }
        }
    }


    public void playerTurn(Player player) {
        boolean flag = true;
        while (flag) {
            showHelpInfomation(player);
            String inputString = input();
            if (inputString.equals("roll")) {
                flag = playerRoll(player, flag);
            } else if (inputString.equals("quit")) {
                quitGame();
            } else if (inputString.equals("query")) {
                player.diaplayStatus();
                flag = true;
            }
        }
    }

    private void quitGame() {
        System.out.println("游戏已退出");
        System.exit(0);
    }

    private boolean playerRoll(Player player, boolean flag) {
        player.roll_the_Dice();
        player.showDiceNum();
        Render_after_player_walks(player);
        if (isEmptyPlot(player)) {
            boolean flag1 = flag;
            if (canBuy(player)) {
                if (canBeUpgraded(player)) {
                    flag1 = buyPlotOrUpgradePlot(player, flag1);
                } else
                    cop.println("摩天楼已升满级", player.color, Color.black);
            } else {
                flag1 = payFine(player);
            }
            flag = flag1;
        } else if (plots[player.coor.x][player.coor.y].type == 0) {

            cop.println(player.getName() + "走到了起点", player.color, Color.black);
            flag = false;


        } else if (plots[player.coor.x][player.coor.y].type == 2) {
            cop.println(player.getName() + "走到了医院", player.color, Color.black);
            flag = false;
        } else if (plots[player.coor.x][player.coor.y].type == 3) {
            cop.println(player.getName() + "欢迎光临道具屋， 请选择您所需要的道具：", player.color, Color.black);
            cop.println("1.路障 50 #；2.机器娃娃 50 空格；3.炸弹 50 @", player.color, Color.black);
            tool.getTool();
            flag = false;
        } else if (plots[player.coor.x][player.coor.y].type == 4) {
            cop.println(player.getName() + "欢迎光临礼品屋，请选择一件您 喜欢的礼品：", player.color, Color.black);
            cop.println("1.奖金2000；2.点数200；3.神符", player.color, Color.black);
            gift.getGift();
            flag = false;
        } else if (plots[player.coor.x][player.coor.y].type == 5) {

            cop.println("走到监狱，扣留两天", player.color, Color.black);

        } else if (plots[player.coor.x][player.coor.y].type == 6) {

            cop.println("欢迎来到魔法屋！可惜咱无魔法。。", player.color, Color.black);

        } else if (plots[player.coor.x][player.coor.y].type == 7) {

            player.points += plots[player.coor.x][player.coor.y].points;

            cop.println(player.getName() + "获得点数：" + plots[player.coor.x][player.coor.y].points, player.color, Color.black);

        }
        return flag;
    }

    private boolean isEmptyPlot(Player player) {
        return plots[player.coor.x][player.coor.y].type == EMPTY_PLOT;
    }

    private boolean canBeUpgraded(Player player) {
        return plots[player.coor.x][player.coor.y].roomLevel <= 3;
    }

    private boolean canBuy(Player player) {
        return plots[player.coor.x][player.coor.y].owner == 0 || plots[player.coor.x][player.coor.y].owner == player.playerNum;
    }

    private boolean payFine(Player player) {
        boolean flag;
        player.money -= plots[player.coor.x][player.coor.y].change;
        cop.println("走到别人地块，扣除相应金钱" + plots[player.coor.x][player.coor.y].change, player.color, Color.black);//判断土地所有者是谁
        plots[player.coor.x][player.coor.y].type = EMPTY_PLOT;
        plots[player.coor.x][player.coor.y].showstr = String.valueOf(plots[player.coor.x][player.coor.y].roomLevel);
        flag = false;
        return flag;
    }

    private boolean buyPlotOrUpgradePlot(Player player, boolean flag) {
        String inputString;
        cop.println("是否购买(升级)该处空地，" + plots[player.coor.x][player.coor.y].price + "元（Y/N）" + "\t", player.color, Color.black);
        inputString = input();
        if (inputString.equals("Y")) {
            flag = buyOrUpgradePlot(player);
        } else if (inputString.equals("N")) {
            cop.println(player.getName() + "放弃占有（升级）地块（" + plots[player.coor.x][player.coor.y].id + "）\t", player.color, Color.black);
            flag = false;
        } else if (inputString.equals("quit")) {
            quitGame();
        }
        return flag;
    }

    private boolean buyOrUpgradePlot(Player player) {
        boolean flag;
        player.money -= plots[player.coor.x][player.coor.y].price;   //减去player1的资产
        plots[player.coor.x][player.coor.y].owner = player.playerNum;//把地归为playerNum所有
        plots[player.coor.x][player.coor.y].change += plots[player.coor.x][player.coor.y].price / 2;
        //if(plots[player.coor.x][player.coor.y].roomLevel<=3)
        plots[player.coor.x][player.coor.y].roomLevel++;
        plots[player.coor.x][player.coor.y].showstr = String.valueOf(plots[player.coor.x][player.coor.y].roomLevel);

        cop.println("地块(" + plots[player.coor.x][player.coor.y].id + ")被" + player.getName() + "占有" + "\t", player.color, Color.black);
        cop.println("系统扣除" + player.getName() + "相应的资金" + plots[player.coor.x][player.coor.y].price + "元" + "\t", player.color, Color.black);
        flag = false;
        return flag;
    }

    private void showHelpInfomation(Player player) {
        cop.println(player.getName() + "->待输入命令(help 提示)" + "\t", player.color, Color.black);
    }

    public static String input() {
        String num1 = null;
        boolean flag = true;

        while (flag) {
            InputStreamReader isr = new InputStreamReader(System.in);
            // 声明一个isr的缓冲区
            BufferedReader br = new BufferedReader(isr);
            try {
                // 从命令行读入一行字
                num1 = br.readLine();

                if (!num1.equals("Y") && !num1.equals("N") && !num1.equals("roll")
                        && !num1.equals("rich") && !num1.equals("quit") && !num1.equals("query")
                        || num1.equals("help"))
                    // flag = false;
                    throw new IOException();

            } catch (IOException ex) {
                // 程序IO异常处理
                if (num1.equals("help")) {
                    cop.println("roll           掷骰子命令，行走1~6步。步数由随即算法产生", Color.white, Color.black);
                    System.out.println("block n        玩家拥有路障后，可将路障放置到离当前位置前后10步的距离，任一玩家经过路障，都将被拦截。该道具一次有效。n 前后的相对距离，负数表示后方");
                    System.out.println("bomb n         可将路障放置到离当前位置前后10步的距离，任一玩家经过在该位置，将被炸伤，送往医院，住院三天。n 前后的相对距离，负数表示后方");
                    System.out.println("robot          使用该道具，可清扫前方路面上10步以内的其它道具，如炸弹、路障");
                    System.out.println("sell x         出售自己的房产，x 地图上的绝对位置，即地产的编号");
                    System.out.println("sellTool x     出售道具，x 道具编号");
                    System.out.println("query          显示自家资产信息   ");
                    System.out.println("help           查看命令帮助  ");
                    System.out.println("quit           强制退出  ");
                } else System.out.println("对不起，您输入的格式不正确,请重新输入");
                flag = true;
                // System.exit(0);
            }
            if (num1.equals("Y") || num1.equals("N") || num1.equals("roll")
                    || num1.equals("rich") || num1.equals("quit") || num1.equals("query"))
                flag = false;
            // return num1;
        }
        return num1;
    }

    public String getIConByPosition(int row, int col) {
        return plots[row][col].showstr;
    }



}

