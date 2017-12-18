import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private String name;
  private String description;
  private int id;
  private int stylist_id;

  public Client(String name, String description, int stylist_id) {
    this.name = name;
    this.description = description;
    this.stylist_id = stylist_id;
  }

  public String getName() {
    return name;
  }

  
}
