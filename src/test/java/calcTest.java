import org.junit.jupiter.api.Test;
import ru.ac.uniyar.mf.sevas.practic.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.ac.uniyar.mf.sevas.practic.Main.main;

public class calcTest {

    @Test
    void addition(){
        String actual = Main.calculate("1", "+", "1");
        assertEquals("2", actual);
    }

    @Test
    void division(){
        String actual = Main.calculate("10", "/", "2");
        assertEquals("5", actual);
    }

    @Test
    void multiply(){
        String actual = Main.calculate("10/2", "*", "2");
        assertEquals("10", actual);
    }

    @Test
    void substraction(){
        String actual = Main.calculate("5", "-", "2");
        assertEquals("3", actual);
    }
}
