package swt6.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum IssuePriority {
    LOW, NORMAL, HIGH;

    @Id
    public String name = toString();
}
