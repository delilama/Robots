import java.awt.*;

public class TestRobot {

    public static void main(String[] args){
        try{
            Shared robotShared = new Shared();
            robotShared.PressWindowsKey();
            robotShared.WaitForTimeToElapse(500);
            robotShared.TypeThis("abdcABD%|");
        }
        catch (AWTException ae){
            ae.printStackTrace();
        }
    }



}
