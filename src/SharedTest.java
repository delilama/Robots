import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SharedTest {

    @Test
    public void testPing() throws Exception {
        Shared shared = new Shared();
        String result = shared.Ping();
        Assert.assertNotNull(result, "Ping result was null");
        Assert.assertEquals(result, "I am alright.", "Ping result did not match");
        //Reporter.log("Test completed.", true);
        //Reporter.getOutput();
        System.out.println("Test is completed");
    }

    @Test
    public void testGetKeyPressDtoFromString() throws Exception {
        Shared shared = new Shared();
        String input = "\t";
        Shared.KeyPressDto expectedDto = new Shared.KeyPressDto();
        expectedDto.ModifierKey = -1;
        expectedDto.VKey = KeyEvent.VK_TAB;

        Shared.KeyPressDto actualDto = shared.GetKeyPressDtoFromString(input);

        Assert.assertEquals(actualDto.ModifierKey, expectedDto.ModifierKey, "ModifierKey did not match for input of " + input);
        Assert.assertEquals(actualDto.VKey, expectedDto.VKey, "VKey did not match input of " + input);

        //with modifier
        input = "A";
        expectedDto.ModifierKey = KeyEvent.VK_SHIFT;
        expectedDto.VKey = KeyEvent.VK_A;

        actualDto = shared.GetKeyPressDtoFromString(input);

        Assert.assertEquals(actualDto.ModifierKey, expectedDto.ModifierKey, "ModifierKey did not match for input of " + input);
        Assert.assertEquals(actualDto.VKey, expectedDto.VKey, "VKey did not match input of " + input);
    }

    @Test
    public void testConvertStringToKeyPressDtos() throws Exception{
        Shared shared = new Shared();
        String input = "Hi!\t";

        List<Shared.KeyPressDto> expectedList = new ArrayList<Shared.KeyPressDto>();
        expectedList.add(new Shared.KeyPressDto(KeyEvent.VK_SHIFT, KeyEvent.VK_H));
        expectedList.add(new Shared.KeyPressDto(-1, KeyEvent.VK_I));
        expectedList.add(new Shared.KeyPressDto(KeyEvent.VK_SHIFT, KeyEvent.VK_1));
        expectedList.add(new Shared.KeyPressDto(-1, KeyEvent.VK_TAB));

        List<Shared.KeyPressDto> actualList = shared.ConvertStringToKeyPressDtos(input);
        
        Assert.assertEquals(actualList.size(), expectedList.size(), "List size did not match");
        for (int i = 0; i < expectedList.size(); i++) {
            Shared.KeyPressDto expectedDto = expectedList.get(i);
            Shared.KeyPressDto actualDto = actualList.get(i);
            Assert.assertEquals(actualDto.ModifierKey, expectedDto.ModifierKey, "ModifierKey did not match");
            Assert.assertEquals(actualDto.VKey, expectedDto.VKey, "VKey did not match");
        }
    }
}