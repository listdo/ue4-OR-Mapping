package swt6.repository.interfaces;

import swt6.domain.*;
import java.util.Set;

public interface ProjectService {
    Project create(Project project);
    Set<Project> readAll();
    Set<Project> readById();
    Project update(Project project);
    boolean delete(Project project);
}
