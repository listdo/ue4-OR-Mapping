package swt6.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issue_status_types")
public enum IssueStatus {
    NEW, OPEN, RESOLVED, CLOSED, REJECTED;
    @Id
    public String name = toString();
}
