
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-9
 * Time: 18:55:50
 * To change this template use File | Settings | File Templates.
 */
public class TestPlayer {

    @Test
    public void test_player_walk_at_begin(){

        Player player = new Player("钱夫人","q",1, Color.red);

        player.coor.position = 0;  //player在起始位置
        player.roll_the_Dice();

        int temp_player_position_before_walk = player.coor.position;

        player.walk();

        int temp_player_position_after_walk;
        temp_player_position_after_walk =  temp_player_position_before_walk + player.currentDiceNum < 69? temp_player_position_before_walk + player.currentDiceNum
                :69 - temp_player_position_before_walk + player.currentDiceNum;
        assertEquals(player.coor.position,temp_player_position_after_walk);
          System.out.println(player.coor.position);
          System.out.println(temp_player_position_after_walk);
    }
         @Test
     public void test_player_walk_at_middle(){

        Player player = new Player("钱夫人","q",1, Color.red);

        player.coor.position = 30;  //player在起始位置
        player.roll_the_Dice();

        int temp_player_position_before_walk = player.coor.position;

        player.walk();

        int temp_player_position_after_walk;
        temp_player_position_after_walk =  temp_player_position_before_walk + player.currentDiceNum <= 69? temp_player_position_before_walk + player.currentDiceNum
                :69 - temp_player_position_before_walk + player.currentDiceNum;
        assertEquals(player.coor.position,temp_player_position_after_walk);
          System.out.println(player.coor.position);
          System.out.println(temp_player_position_after_walk);
    }
      @Test
     public void test_player_walk_at_end(){

        Player player = new Player("钱夫人","q",1, Color.red);

        player.coor.position = 69;  //player在起始位置
        player.roll_the_Dice();

        int temp_player_position_before_walk = player.coor.position;

        player.walk();

        int temp_player_position_after_walk;
        temp_player_position_after_walk =  temp_player_position_before_walk + player.currentDiceNum <= 69? temp_player_position_before_walk + player.currentDiceNum
                :69 - temp_player_position_before_walk + player.currentDiceNum;
        assertEquals(player.coor.position,temp_player_position_after_walk);

          System.out.println(player.coor.position);
          System.out.println(temp_player_position_after_walk);
    }

}
