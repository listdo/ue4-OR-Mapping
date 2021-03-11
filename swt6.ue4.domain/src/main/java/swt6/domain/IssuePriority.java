package swt6.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issue_status_priority")
public enum IssuePriority {
    LOW, NORMAL, HIGH;

    @Id
    public String name = toString();
}
