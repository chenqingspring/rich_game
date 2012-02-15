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

    public  Plot plots[][];// �ؿ�����

    public static ColorOutput cop = new ColorOutput();

    public Map() {
		plots = new Plot[8][29];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 29; j++) {
				plots[i][j] = new Plot();
			}
		}
	}
    
    	/** ��ʼ����ͼ */
	public void Init() {
		/** ���� ���д�ӡ���� ���� */
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 28; j++) {
				if (i == 0 && j == 0) {
					plots[i][j].type = 0;
                    plots[i][j].area = 0; // �����ضα��Ϊ0

				} else if (i == 0 && j >= 1 && j <= 13) {
					plots[i][j].type = 1;
                    plots[i][j].area = 1;//�ض�һ ���Ϊ1
                    plots[i][j].price = 200;

               } else if (i == 0 && j >= 15 && j <= 27) {
					plots[i][j].type = 1;
                    plots[i][j].area = 2;//�ضζ� ���Ϊ2
                     plots[i][j].price = 200;
               }else if (i >= 1 && i<=6 && j == 28) {
					plots[i][j].type = 1;
                    plots[i][j].area = 3;//�ض��� ���Ϊ3
                    plots[i][j].price = 500;

              } else if (i == 7 && j >= 15 && j <= 27) {
					plots[i][j].type = 1;
                    plots[i][j].area = 4;//�ض��� ���Ϊ4
                    plots[i][j].price = 300;

                } else if (i == 7 && j >= 1 && j <= 13) {
					plots[i][j].type = 1;
                    plots[i][j].area = 5;//�ض��� ���Ϊ5
                    plots[i][j].price = 300;

				} else if (i == 0 && j == 14) {
					plots[i][j].type = 2;
                    plots[i][j].area = 0; // �����ضα��Ϊ0

                } else if (i == 0 && j == 28) {
					plots[i][j].type = 3;
                    plots[i][j].area = 0; // �����ضα��Ϊ0

				}else if (i >= 1 && i<=6 && j == 0) {
					plots[i][j].type = 7;
                    plots[i][j].area = 0; // �����ضα��Ϊ0

                }else if (i == 7 && j == 0) {
					plots[i][j].type = 6;
                    plots[i][j].area = 0; // �����ضα��Ϊ0

                }else if (i == 7 && j == 14) {
					plots[i][j].type = 5;
                    plots[i][j].area = 0; // �����ضα��Ϊ0

                }else if (i == 7 && j == 28) {
					plots[i][j].type = 4;
                    plots[i][j].area = 0; // �����ضα��Ϊ0
				}
				else {
					plots[i][j].type = -1;
                    plots[i][j].area = 0; // �����ضα��Ϊ0
				}


			}
		}

            setID();
            setPoint();

	}
       /*����plot��ID*/

    public void setID(){
        int num = 0;
        for(int j = 0;j < 29; j++){
            plots[0][j].id = num;
//System.out.println(plots[0][j].id);
            num++;
        }

        for(int i = 1;i < 8;i++ ) {
            plots[i][28].id = num;
//System.out.println(plots[i][7].id);
            num++;
        }

        for(int j = 27;j >= 0; j--){
            plots[7][j].id = num;
//System.out.println(plots[7][j].id);
            num++;
        }

        for(int i = 6;i >= 1; i-- ) {
            plots[i][0].id = num;
//System.out.println(plots[i][0].id);
            num++;
        }
    }


    /*���ÿ�ص���*/

    public void setPoint(){

        plots[1][0].points = 60;
        plots[2][0].points = 80;
        plots[3][0].points = 40;
        plots[4][0].points = 100;
        plots[5][0].points = 80;
        plots[6][0].points = 20;

    }



/*������ͼ����*/

       public void Render() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 29; j++) {
				if (j != 28) {
					plots[i][j].drawPlot(false);
				}
				if (j == 28) {
					plots[i][j].drawPlot(true);
				}
			}
		}
       }


     public void Render_after_player_walks(Player player){
         player.walk();
        for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 29; j++) {
				if (plots[i][j].id == player.coor.position){
                        int temp_type =  plots[i][j].type;
                        player.coor.x = i;
                        player.coor.y = j;
                        plots[i][j].type = 10;
                        plots[i][j].showstr = player.nameForStort;
                        Render();
                        plots[i][j].type = temp_type;
                        i = 8;j = 29;
                }
			}
		}
     }


    public void playerWalk(Player player){

        boolean flag = true;
        while(flag){
        cop.println(player.getName() +"->����������(help ��ʾ)"+ "\t", player.color,Color.black );
        //System.out.println(player.getName() +"->����������"+ "\t");
        String s;
        s = input(true);
        if(s.equals("roll")){
        player.roll_the_Dice();
        player.showDiceNum();
        Render_after_player_walks(player);
        cop.println("�Ƿ���ô��յأ�"+ plots[player.coor.x][player.coor.y].price +"Ԫ��Y/N��"+ "\t", player.color,Color.black);
            s = input(true);
            if(s.equals("Y")){
                  player.money -= plots[player.coor.x][player.coor.y].price;   //��ȥplayer1���ʲ�
                  plots[player.coor.x][player.coor.y].owner = player.playerNum;//�ѵع�ΪplayerNum����
                cop.println("�ؿ�("+ plots[player.coor.x][player.coor.y].id + ")��"+player.getName()+"ռ��" + "\t", player.color,Color.black);
                cop.println("ϵͳ�۳�"+player.getName()+"��Ӧ���ʽ�" + plots[player.coor.x][player.coor.y].price+"Ԫ" + "\t", player.color,Color.black);
                flag = false;
            }
            else if (s.equals("N")){
                 cop.println(player.getName()+"����ռ�еؿ飨" + plots[player.coor.x][player.coor.y].id+ "��\t", player.color,Color.black);
                 flag = false;
            } else if (s.equals("quit")){
                  System.out.println("��Ϸ���˳�");
                  System.exit(0);
              }

            }else if (s.equals("quit")){
             System.out.println("��Ϸ���˳�");
             System.exit(0);
            }else if (s.equals("query")){
             player.diaplay();
             flag = true;
            }

        }
    }

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
                        && !num1.equals("rich")&& !num1.equals("quit")&& !num1.equals("query")
                        || num1.equals("help"))
                   // flag = false;
					throw new IOException();
			}
		} catch (IOException ex) {
			// ����IO�쳣����
            if(num1.equals("help")){
                cop.println("roll           �������������1~6�����������漴�㷨����",Color.white, Color.black);
                System.out.println("block n        ���ӵ��·�Ϻ󣬿ɽ�·�Ϸ��õ��뵱ǰλ��ǰ��10���ľ��룬��һ��Ҿ���·�ϣ����������ء��õ���һ����Ч��n ǰ�����Ծ��룬������ʾ��");
                System.out.println("bomb n         �ɽ�·�Ϸ��õ��뵱ǰλ��ǰ��10���ľ��룬��һ��Ҿ����ڸ�λ�ã�����ը�ˣ�����ҽԺ��סԺ���졣n ǰ�����Ծ��룬������ʾ��");
                System.out.println("robot          ʹ�øõ��ߣ�����ɨǰ��·����10�����ڵ��������ߣ���ը����·��");
                System.out.println("sell x         �����Լ��ķ�����x ��ͼ�ϵľ���λ�ã����ز��ı��");
                System.out.println("sellTool x     ���۵��ߣ�x ���߱��");
                System.out.println("query          ��ʾ�Լ��ʲ���Ϣ   ");
                System.out.println("help           �鿴�������  ");
                System.out.println("quit           ǿ���˳�  ");
            }
			else System.out.println("�Բ���������ĸ�ʽ����ȷ,����������");
            flag = true;
        	// System.exit(0);
		}
        if(num1.equals("Y") || num1.equals("N") || num1.equals("roll")
                        || num1.equals("rich") || num1.equals("quit")|| num1.equals("query"))
                flag = false;
           // return num1;
	  }
            return num1;
    }



}



    

