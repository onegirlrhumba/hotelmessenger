import org.junit.Test;
import org.hamcrest.*;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

public class MainTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void shouldReturnCandyPaceHotelCalifornia() throws IOException {
        systemInMock.provideLines("1", "1", "**customer_name** **hotel_name**");
        assertEquals("Candy Pace Hotel California", Main.formMessage());

    }
    @Test
    public void shouldReturnLatoyaHerreraTheHeartBreakHotelMessage4() throws IOException {
        systemInMock.provideLines("3", "5", "4");
        assertEquals("Good Evening Latoya Herrera, this is an automated reminder that checkout is at 09:52 PM 02-10-2017. Thanks for staying with The Heartbreak Hotel", Main.formMessage());

    }
}
