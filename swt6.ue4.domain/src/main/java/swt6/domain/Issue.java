package swt6.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Duration;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Issue {
    @Id
    private Long id;

    @ManyToOne
    private IssueStatus status;

    @ManyToOne
    private IssuePriority priority;

    @Min(0)
    @Max(100)
    private Duration processingTime;

    @ManyToOne
    private Project project;

    public Issue() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    public Duration getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Duration processingTime) {
        this.processingTime = processingTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
