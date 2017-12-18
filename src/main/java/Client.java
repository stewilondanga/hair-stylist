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

  public String getDescription() {
    return description;
  }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylist_id;
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) && this.getDescription().equals(newClient.getDescription());
    }
  }

  
}
