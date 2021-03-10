package swt6.repository.interfaces;

import swt6.domain.*;
import java.util.Set;

public interface IssueService {
    Issue create(Issue issue);
    Set<Issue> readAll();
    Set<Issue> readById();
    Issue update(Issue issue);
    boolean delete(Issue issue);
}
