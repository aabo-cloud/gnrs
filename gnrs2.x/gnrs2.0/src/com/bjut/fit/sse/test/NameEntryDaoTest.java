package com.bjut.fit.sse.test;

import com.bjut.fit.sse.dao.NameEntryDao;
import com.bjut.fit.sse.dao.impl.NameEntryDaoImpl;
import com.bjut.fit.sse.pojo.NameEntry;
import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class NameEntryDaoTest {

    private NameEntryDao nameEntryDao = new NameEntryDaoImpl();

    @Test
    public void saveNameEntry() {
        nameEntryDao.saveNameEntry(new NameEntry("xyz", "1.1.1.1"));
    }

    @Test
    public void updateNameEntry() {
//        nameEntryDao.updateNameEntry(new NameEntry("xyzzz", "4c764bb3ae0d35cf031b4a148511c663","255.255.255.255"));
    }

    @Test
    public void deleteNameEntryByGuid() {
        nameEntryDao.deleteNameEntryByGuid("8785d1c8ec540d24eecd8d5614a612f3");
    }

    @Test
    public void queryNameEntries() {
//        nameEntryDao.queryNameEntries().forEach(new Consumer<NameEntry>() {
//            @Override
//            public void accept(NameEntry nameEntry) {
//                System.out.println(nameEntry);
//            }
//        });
//        nameEntryDao.queryNameEntries().forEach((NameEntry nameEntry) -> { System.out.println(nameEntry);});
//        nameEntryDao.queryNameEntries().forEach(nameEntry -> System.out.println(nameEntry));
        nameEntryDao.queryNameEntries().forEach(System.out::println);
    }

    @Test
    public void queryNameEntryByGuid() {
        System.out.println(nameEntryDao.queryNameEntryByGuid("d8ea6c931c4fcbf0527f55890e0f10ff"));
    }

    @Test
    public void queryNameEntryByReadableName() {
        System.out.println(nameEntryDao.queryNameEntryByReadableName("localhost"));
    }

    @Test
    public void queryNameEntryByIp() {
        System.out.println(nameEntryDao.queryNameEntryByIp("1.1.1.1"));
    }
}