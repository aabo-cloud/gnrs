package com.bjut.fit.sse.test;

import com.bjut.fit.sse.pojo.NameEntry;
import com.bjut.fit.sse.service.NameEntryService;
import com.bjut.fit.sse.service.impl.NameEntryServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameEntryServiceImplTest {

    NameEntryService nameEntryService = new NameEntryServiceImpl();

    @Test
    public void register() {
        nameEntryService.register(new NameEntry("xyz", "1.1.1.1"));
    }

    @Test
    public void updateNameEntry() {
    }

    @Test
    public void deleteNameEntryByGuid() {
    }

    @Test
    public void findNameEntryByGuid() {
    }

    @Test
    public void queryNameEntries() {
    }
}