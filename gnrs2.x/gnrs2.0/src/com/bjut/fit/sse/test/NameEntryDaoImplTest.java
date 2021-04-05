package com.bjut.fit.sse.test;

import com.bjut.fit.sse.dao.NameEntryDao;
import com.bjut.fit.sse.dao.impl.NameEntryDaoImpl;
import com.bjut.fit.sse.service.NameEntryService;
import com.bjut.fit.sse.service.impl.NameEntryServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameEntryDaoImplTest {

    NameEntryDao dao = new NameEntryDaoImpl();

    @Test
    public void queryForPageCount() {
        System.out.println(dao.queryForPageCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(dao.queryForPageItems(1, 3));
    }
}