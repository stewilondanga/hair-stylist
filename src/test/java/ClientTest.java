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

  @Test
  public void client_instantiatesCorrectly_true() {
    assertEquals(true, client instanceof Client);
  }

  @Test
  public void getName_returnsNameOfClient_String() {
    assertEquals("Taraji", client.getName());
  }

  @Test
  public void getDescription_returnsDescriptionOfClient_String() {
    assertEquals("Sunflower blonde color, every 6 months", client.getDescription());
  }

  @Test
  public void equals_returnsTrueIfPropertiesAreTheSame_true() {
    Client secondClient = new Client("Taraji", "Sunflower blonde color, every 6 months", 1);
    assertTrue(client.equals(secondClient));
  }

  @Test
  public void save_saveObjectToDatabase_true(){
    client.save();
    String sql = "SELECT * FROM clients WHERE name='Taraji'";
    Client secondClient;
    try(Connection con = DB.sql2o.open()){
      secondClient = con.createQuery(sql).executeAndFetchFirst(Client.class);
    }
    assertTrue(client.equals(secondClient));
  }

  @Test
  public void getId_returnsIdOfClient_true() {
    client.save();
    assertTrue(client.getId() > 0);
  }

  
}
