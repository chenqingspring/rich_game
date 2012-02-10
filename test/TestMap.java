import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-9
 * Time: 15:15:19
 * To change this template use File | Settings | File Templates.
 */
public class TestMap {

    @Test
    public void test_plot_name(){

        Map map = new Map();
        map.Init();
        map.Render();
        assertEquals("S",map.plots[0][0].showstr);
        assertEquals("H",map.plots[0][14].showstr);
        assertEquals("T",map.plots[0][28].showstr);
        assertEquals("G",map.plots[7][28].showstr);
        assertEquals("P",map.plots[7][14].showstr);
        assertEquals("M",map.plots[7][0].showstr);
    }

    @Test
    public void test_plot_id(){
        Map map = new Map();
        map.Init();
        map.Render();
        assertEquals(0,map.plots[0][0].id);
        assertEquals(28,map.plots[0][28].id);
        assertEquals(35,map.plots[7][28].id);
        assertEquals(63,map.plots[7][0].id);
        assertEquals(69,map.plots[1][0].id);
    }


}
