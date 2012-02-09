/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-1
 * Time: 21:49:33
 * To change this template use File | Settings | File Templates.
 */
public class Map {

    public  Plot plots[][];// 地块类型

    public Map() {
		plots = new Plot[8][29];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 29; j++) {
				plots[i][j] = new Plot();
			}
		}
	}
    
    	/** 初始化地图 */
	public void Init() {
		/** 坐标 按行打印数组 遍历 */
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 28; j++) {
				if (i == 0 && j == 0) {
					plots[i][j].type = 0;
                    plots[i][j].area = 0; // 其他地段标记为0

				} else if (i == 0 && j >= 1 && j <= 13) {
					plots[i][j].type = 1;
                    plots[i][j].area = 1;//地段一 标记为1
                    plots[i][j].price = 200;

               } else if (i == 0 && j >= 15 && j <= 27) {
					plots[i][j].type = 1;
                    plots[i][j].area = 2;//地段二 标记为2
                     plots[i][j].price = 200;
               }else if (i >= 1 && i<=6 && j == 28) {
					plots[i][j].type = 1;
                    plots[i][j].area = 3;//地段三 标记为3
                    plots[i][j].price = 500;

              } else if (i == 7 && j >= 15 && j <= 27) {
					plots[i][j].type = 1;
                    plots[i][j].area = 4;//地段四 标记为4
                    plots[i][j].price = 300;

                } else if (i == 7 && j >= 1 && j <= 13) {
					plots[i][j].type = 1;
                    plots[i][j].area = 5;//地段五 标记为5
                    plots[i][j].price = 300;

				} else if (i == 0 && j == 14) {
					plots[i][j].type = 2;
                    plots[i][j].area = 0; // 其他地段标记为0

                } else if (i == 0 && j == 28) {
					plots[i][j].type = 3;
                    plots[i][j].area = 0; // 其他地段标记为0

				}else if (i >= 1 && i<=6 && j == 0) {
					plots[i][j].type = 7;
                    plots[i][j].area = 0; // 其他地段标记为0

                }else if (i == 7 && j == 0) {
					plots[i][j].type = 6;
                    plots[i][j].area = 0; // 其他地段标记为0

                }else if (i == 7 && j == 14) {
					plots[i][j].type = 5;
                    plots[i][j].area = 0; // 其他地段标记为0

                }else if (i == 7 && j == 28) {
					plots[i][j].type = 4;
                    plots[i][j].area = 0; // 其他地段标记为0
				}
				else {
					plots[i][j].type = -1;
                    plots[i][j].area = 0; // 其他地段标记为0
				}


			}
		}

            setID();
            setPoint();

	}
       /*设置plot的ID*/

    public void setID(){
        int num = 0;
        for(int j = 0;j < 29; j++){
            plots[0][j].id = num;
//System.out.println(plots[0][j].id);
            num++;
        }

        for(int i = 1;i < 8;i++ ) {
            plots[i][7].id = num;
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


    /*设置矿地点数*/

    public void setPoint(){

        plots[1][0].points = 60;
        plots[2][0].points = 80;
        plots[3][0].points = 40;
        plots[4][0].points = 100;
        plots[5][0].points = 80;
        plots[6][0].points = 20;

    }



/*画出地图内容*/

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

}



    

