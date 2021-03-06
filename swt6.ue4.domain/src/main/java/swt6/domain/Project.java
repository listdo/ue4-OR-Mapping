package swt6.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private Long     id;
  private String   name;
  
  public Long getId() {
    return id;
  }

  public Project() { }
  
  public Project(String name) {
    this.name = name;  
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
}
