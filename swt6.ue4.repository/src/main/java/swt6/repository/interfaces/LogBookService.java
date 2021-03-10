package swt6.repository.interfaces;

import swt6.domain.*;
import java.util.Set;

public interface LogBookService {
    LogbookEntry create(LogbookEntry logbookEntry);
    Set<LogbookEntry> readAll();
    Set<LogbookEntry> readById();
    LogbookEntry update(LogbookEntry logbookEntry);
    boolean delete(LogbookEntry logbookEntry);
}
