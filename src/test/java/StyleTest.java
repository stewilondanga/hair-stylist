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

  @Test
  public void equals_returnsTrueIfPropertiesAreTheSame_true() {
    Stylist secondStylist = new Stylist("Tyra", "Straightforward, elegant style");
    assertTrue(stylist.equals(secondStylist));
  }

  @Test
  public void save_saveObjectToDatabase_true(){
    stylist.save();
    String sql = "SELECT * FROM stylists WHERE name='Tyra'";
    Stylist secondStylist;
    try(Connection con = DB.sql2o.open()){
      secondStylist = con.createQuery(sql).executeAndFetchFirst(Stylist.class);
    }
    assertTrue(stylist.equals(secondStylist));
  }

  @Test
  public void getId_returnsIdOfStylist_true() {
    stylist.save();
    assertTrue(stylist.getId() > 0);
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true(){
    stylist.save();
    Stylist secondStylist = new Stylist("Hulk", "Specializes in wavy layers");
    secondStylist.save();
    assertTrue(Stylist.all().contains(stylist));
    assertTrue(Stylist.all().contains(secondStylist));
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    stylist.save();
    Stylist secondStylist = new Stylist("Hulk", "Specializes in wavy layers");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
  public void getClients_retrievesAllClientsWithStylistId_ClientList(){
    stylist.save();
    Client client = new Client("Boxer", "Bowlcut trim every 2 weeks", stylist.getId());
    client.save();
    Client secondClient = new Client("Lala", "Lala", stylist.getId());
    secondClient.save();
    Client[] clients = new Client[] {client, secondClient};
    assertTrue(stylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void updateName_updatesStylistName_true() {
    stylist.save();
    stylist.updateName("Alicia");
    assertEquals("Alicia", Stylist.find(stylist.getId()).getName());
  }

  @Test
  public void updateDescription_updatesStylistDescription_true() {
    stylist.save();
    stylist.updateDescription("Blunt bangs");
    assertEquals("Blunt bangs", Stylist.find(stylist.getId()).getDescription());
  }

  @Test
  public void delete_deleteStylist_true() {
    stylist.save();
    int stylistId = stylist.getId();
    stylist.delete();
    assertEquals(null, Stylist.find(stylistId));
  }

  @Test
  public void getUnassociatedClients_retrievesListOfClientsWhoseStylistIdsAreZero_true() {
    stylist.save();
    Client client = new CLient("Boxer", "Bowlcut trim every 2 weeks", stylist.getId());
    client.save();
    stylist.delete();
    assertTrue(Stylist.getUnassociatedClients().contains(client));
  }

}
