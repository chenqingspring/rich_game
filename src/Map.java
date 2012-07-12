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

    public Plot plots[][];// �ؿ�����

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
     * ��ʼ����ͼ
     */
    public void init() {
        /** ���� ���д�ӡ���� ���� */
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
        plots[i][j].area = 0; // �����ضα��Ϊ0
    }

    private void getGift(int i, int j) {
        plots[i][j].type = 4;
        plots[i][j].area = 0; // �����ضα��Ϊ0
    }

    private void setPrison(int i, int j) {
        plots[i][j].type = 5;
        plots[i][j].area = 0; // �����ضα��Ϊ0
    }

    private void setMine(int i, int j) {
        plots[i][j].type = 6;
        plots[i][j].area = 0; // �����ضα��Ϊ0
    }

    private void setDollarArea(int i, int j) {
        plots[i][j].type = 7;
        plots[i][j].area = 0;
    }

    private void setTools(int i, int j) {
        plots[i][j].type = 3;
        plots[i][j].area = 0; // �����ضα��Ϊ0
    }

    private void setHospital(int i, int j) {
        plots[i][j].type = 2;
        plots[i][j].area = 0; // �����ضα��Ϊ0
    }

    private void setFifthArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 5;//�ض��� ���Ϊ5
        plots[i][j].price = 300;
    }

    private void setFourthArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 4;//�ض��� ���Ϊ4
        plots[i][j].price = 300;
    }

    private void setThirdArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 3;//�ض��� ���Ϊ3
        plots[i][j].price = 500;
    }

    private void setSecondArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = 2;//�ضζ� ���Ϊ2
        plots[i][j].price = 200;
    }

    private void setFirstArea(int i, int j) {
        plots[i][j].type = EMPTY_PLOT;
        plots[i][j].area = EMPTY_PLOT;//�ض�һ ���Ϊ1
        plots[i][j].price = 200;
    }

    private void setFirstPlot(int i, int j) {
        plots[i][j].type = 0;
        plots[i][j].area = 0;
    }
    /*����plot��ID*/

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


    /*���ÿ�ص���*/

    public void setPoint() {

        plots[EMPTY_PLOT][0].points = 60;
        plots[2][0].points = 80;
        plots[3][0].points = 40;
        plots[4][0].points = 100;
        plots[5][0].points = 80;
        plots[6][0].points = 20;

    }


/*������ͼ����*/

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
        System.out.println("��Ϸ���˳�");
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
                    cop.println("Ħ��¥��������", player.color, Color.black);
            } else {
                flag1 = payFine(player);
            }
            flag = flag1;
        } else if (plots[player.coor.x][player.coor.y].type == 0) {

            cop.println(player.getName() + "�ߵ������", player.color, Color.black);
            flag = false;


        } else if (plots[player.coor.x][player.coor.y].type == 2) {
            cop.println(player.getName() + "�ߵ���ҽԺ", player.color, Color.black);
            flag = false;
        } else if (plots[player.coor.x][player.coor.y].type == 3) {
            cop.println(player.getName() + "��ӭ���ٵ����ݣ� ��ѡ��������Ҫ�ĵ��ߣ�", player.color, Color.black);
            cop.println("1.·�� 50 #��2.�������� 50 �ո�3.ը�� 50 @", player.color, Color.black);
            tool.getTool();
            flag = false;
        } else if (plots[player.coor.x][player.coor.y].type == 4) {
            cop.println(player.getName() + "��ӭ������Ʒ�ݣ���ѡ��һ���� ϲ������Ʒ��", player.color, Color.black);
            cop.println("1.����2000��2.����200��3.���", player.color, Color.black);
            gift.getGift();
            flag = false;
        } else if (plots[player.coor.x][player.coor.y].type == 5) {

            cop.println("�ߵ���������������", player.color, Color.black);

        } else if (plots[player.coor.x][player.coor.y].type == 6) {

            cop.println("��ӭ����ħ���ݣ���ϧ����ħ������", player.color, Color.black);

        } else if (plots[player.coor.x][player.coor.y].type == 7) {

            player.points += plots[player.coor.x][player.coor.y].points;

            cop.println(player.getName() + "��õ�����" + plots[player.coor.x][player.coor.y].points, player.color, Color.black);

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
        cop.println("�ߵ����˵ؿ飬�۳���Ӧ��Ǯ" + plots[player.coor.x][player.coor.y].change, player.color, Color.black);//�ж�������������˭
        plots[player.coor.x][player.coor.y].type = EMPTY_PLOT;
        plots[player.coor.x][player.coor.y].showstr = String.valueOf(plots[player.coor.x][player.coor.y].roomLevel);
        flag = false;
        return flag;
    }

    private boolean buyPlotOrUpgradePlot(Player player, boolean flag) {
        String inputString;
        cop.println("�Ƿ���(����)�ô��յأ�" + plots[player.coor.x][player.coor.y].price + "Ԫ��Y/N��" + "\t", player.color, Color.black);
        inputString = input();
        if (inputString.equals("Y")) {
            flag = buyOrUpgradePlot(player);
        } else if (inputString.equals("N")) {
            cop.println(player.getName() + "����ռ�У��������ؿ飨" + plots[player.coor.x][player.coor.y].id + "��\t", player.color, Color.black);
            flag = false;
        } else if (inputString.equals("quit")) {
            quitGame();
        }
        return flag;
    }

    private boolean buyOrUpgradePlot(Player player) {
        boolean flag;
        player.money -= plots[player.coor.x][player.coor.y].price;   //��ȥplayer1���ʲ�
        plots[player.coor.x][player.coor.y].owner = player.playerNum;//�ѵع�ΪplayerNum����
        plots[player.coor.x][player.coor.y].change += plots[player.coor.x][player.coor.y].price / 2;
        //if(plots[player.coor.x][player.coor.y].roomLevel<=3)
        plots[player.coor.x][player.coor.y].roomLevel++;
        plots[player.coor.x][player.coor.y].showstr = String.valueOf(plots[player.coor.x][player.coor.y].roomLevel);

        cop.println("�ؿ�(" + plots[player.coor.x][player.coor.y].id + ")��" + player.getName() + "ռ��" + "\t", player.color, Color.black);
        cop.println("ϵͳ�۳�" + player.getName() + "��Ӧ���ʽ�" + plots[player.coor.x][player.coor.y].price + "Ԫ" + "\t", player.color, Color.black);
        flag = false;
        return flag;
    }

    private void showHelpInfomation(Player player) {
        cop.println(player.getName() + "->����������(help ��ʾ)" + "\t", player.color, Color.black);
    }

    public static String input() {
        String num1 = null;
        boolean flag = true;

        while (flag) {
            InputStreamReader isr = new InputStreamReader(System.in);
            // ����һ��isr�Ļ�����
            BufferedReader br = new BufferedReader(isr);
            try {
                // �������ж���һ����
                num1 = br.readLine();

                if (!num1.equals("Y") && !num1.equals("N") && !num1.equals("roll")
                        && !num1.equals("rich") && !num1.equals("quit") && !num1.equals("query")
                        || num1.equals("help"))
                    // flag = false;
                    throw new IOException();

            } catch (IOException ex) {
                // ����IO�쳣����
                if (num1.equals("help")) {
                    cop.println("roll           �������������1~6�����������漴�㷨����", Color.white, Color.black);
                    System.out.println("block n        ���ӵ��·�Ϻ󣬿ɽ�·�Ϸ��õ��뵱ǰλ��ǰ��10���ľ��룬��һ��Ҿ���·�ϣ����������ء��õ���һ����Ч��n ǰ�����Ծ��룬������ʾ��");
                    System.out.println("bomb n         �ɽ�·�Ϸ��õ��뵱ǰλ��ǰ��10���ľ��룬��һ��Ҿ����ڸ�λ�ã�����ը�ˣ�����ҽԺ��סԺ���졣n ǰ�����Ծ��룬������ʾ��");
                    System.out.println("robot          ʹ�øõ��ߣ�����ɨǰ��·����10�����ڵ��������ߣ���ը����·��");
                    System.out.println("sell x         �����Լ��ķ�����x ��ͼ�ϵľ���λ�ã����ز��ı��");
                    System.out.println("sellTool x     ���۵��ߣ�x ���߱��");
                    System.out.println("query          ��ʾ�Լ��ʲ���Ϣ   ");
                    System.out.println("help           �鿴�������  ");
                    System.out.println("quit           ǿ���˳�  ");
                } else System.out.println("�Բ���������ĸ�ʽ����ȷ,����������");
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

