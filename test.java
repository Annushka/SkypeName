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
public class test {
    HashMap<String, Boolean> kesh = new HashMap<String, Boolean>();
    String name = "";

    @Test(expected = Exception.class)
    public void NullName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        name = "";
        if (kesh.containsKey(name)) {
            kesh.get(name);
        } else {
            boolean result = logCh.validate(name);
            kesh.put(name, result);
        }


    }

    @Test
    public void RussianName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        name = "Вася585";
        if (kesh.containsKey(name)) {
            assertFalse(kesh.get(name));
        } else {
            boolean result = logCh.validate(name);
            kesh.put(name, result);
            assertFalse(result);
        }
    }

    @Test
    public void LongName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        name = "ValentinaTemofeevnaReznicova88888888888";
        if (kesh.containsKey(name)) {
            assertFalse(kesh.get(name));
        } else {
            boolean result = logCh.validate(name);
            kesh.put(name, result);
            assertFalse(result);
        }
    }

    @Test
    public void ShortName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        name = "Haya";
        if (kesh.containsKey(name)) {
            assertFalse(kesh.get(name));
        } else {
            boolean result = logCh.validate(name);
            kesh.put(name, result);
            assertFalse(result);
        }

    }

    @Test
    public void OccupiedName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        name = "sunny3548";
        if (kesh.containsKey(name)) {
            assertTrue(kesh.get(name));
        } else {
            boolean result = logCh.validate(name);
            kesh.put(name, result);
            assertTrue(result);
        }

    }

    @Test
    public void NotOccupiedName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        name = "sunny00000000000";
        if (kesh.containsKey(name)) {
            assertFalse(kesh.get(name));
        } else {
            boolean result = logCh.validate(name);
            kesh.put(name, result);
            assertFalse(result);
        }


    }

}


