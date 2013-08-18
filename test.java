package SkypeName;

import org.junit.Test;

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

        @Test (expected = Exception.class)
        public void NullName() throws Exception {
            LoginCheck logCh = new LoginCheck();
             logCh.validate("");
        }

    @Test
    public void RussianName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        assertFalse(logCh.validate("Вася585"));
    }

    @Test
    public void LongName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        assertFalse(logCh.validate("ValentinaTemofeevnaReznicova88888888888"));
    }
    @Test
    public void ShortName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        assertFalse(logCh.validate("Haya"));
    }
    @Test
    public void OccupiedName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        assertTrue(logCh.validate("sunny3548"));
    }
    @Test
    public void NotOccupiedName() throws Exception {
        LoginCheck logCh = new LoginCheck();
        assertFalse(logCh.validate("sunny00000000000"));
    }

    }


