import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  Stylist stylist;
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setUp(){
    stylist = new Stylist("Tyra", "Straightforward, elegant style");
  }

  @Test
  public void stylist_instantiatesCorrectly_true() {
    assertTrue(stylist instanceof Stylist);
  }

  @Test
  public void getName_returnsNameOfStylist_String() {
    assertEquals("Tyra", stylist.getName());
  }

  @Test
  public void getDescription_returnsDescriptionOfStylist_String() {
    assertEquals("Straightforward, elegant style", stylist.getDescription());
  }

  
}
