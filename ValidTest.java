package SkypeName;

import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Анна
 * Date: 18.08.13
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class ValidTest {

    @Test
    public void Test() throws Exception {
        CesheSkypeStatusRequester logCh = new CesheSkypeStatusRequester(new SkypeStatusRequester());
        assertFalse(logCh.validate(""));
        assertFalse(logCh.validate("Вася585"));
        assertFalse(logCh.validate("ValentinaTemofeevnaReznicova88888888888"));
        assertFalse(logCh.validate("Haya"));
        assertTrue(logCh.validate("sunny3548"));
        assertFalse(logCh.validate("sunny00000000000"));
    }

}


