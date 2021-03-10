package swt6.repository.impl;

import swt6.domain.*;
import swt6.repository.interfaces.LogBookService;

import java.util.Set;

public class LogBookDao implements LogBookService {
    @Override
    public LogbookEntry create(LogbookEntry logbookEntry) {
        return null;
    }

    @Override
    public Set<LogbookEntry> readAll() {
        return null;
    }

    @Override
    public Set<LogbookEntry> readById() {
        return null;
    }

    @Override
    public boolean delete(LogbookEntry logbookEntry) {
        return false;
    }

    @Override
    public LogbookEntry update(LogbookEntry logbookEntry) {
        return null;
    }
}
