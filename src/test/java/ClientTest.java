import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CLient Test {
  CLient client;
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setUp(){
    client = new Client("Taraji", "Sunflower blonde color, every 6 months", 1);
  }

  
}
