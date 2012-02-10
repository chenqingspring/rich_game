
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: spring
 * Date: 2012-2-9
 * Time: 18:41:21
 * To change this template use File | Settings | File Templates.
 */
public class TestPlot {

    @Test
    public void test_when_plot_type_0_drawPlot(){
        Plot plot = new Plot();
        plot.type = 0;
        plot.drawPlot(true);
        assertEquals("S",plot.showstr);
    }
     @Test
    public void test_when_plot_type_1_drawPlot(){
        Plot plot = new Plot();
        plot.type = 1;
        plot.drawPlot(true);
        assertEquals("0",plot.showstr);
    }
     @Test
    public void test_when_plot_type_2_drawPlot(){
        Plot plot = new Plot();
        plot.type = 2;
        plot.drawPlot(true);
        assertEquals("H",plot.showstr);
    }
     @Test
    public void test_when_plot_type_3_drawPlot(){
        Plot plot = new Plot();
        plot.type = 3;
        plot.drawPlot(true);
        assertEquals("T",plot.showstr);
    }
     @Test
    public void test_when_plot_type_4_drawPlot(){
        Plot plot = new Plot();
        plot.type = 4;
        plot.drawPlot(true);
        assertEquals("G",plot.showstr);
    }
     @Test
    public void test_when_plot_type_5_drawPlot(){
        Plot plot = new Plot();
        plot.type = 5;
        plot.drawPlot(true);
        assertEquals("P",plot.showstr);
    }
     @Test
    public void test_when_plot_type_6_drawPlot(){
        Plot plot = new Plot();
        plot.type = 6;
        plot.drawPlot(true);
        assertEquals("M",plot.showstr);
    }
     @Test
    public void test_when_plot_type_7_drawPlot(){
        Plot plot = new Plot();
        plot.type = 7;
        plot.drawPlot(true);
        assertEquals("$",plot.showstr);
    }

     @Test
    public void test_when_plot_type_minus_1_drawPlot(){
        Plot plot = new Plot();
        plot.type = -1;
        plot.drawPlot(true);
        assertEquals(" ",plot.showstr);
    }
   
}
