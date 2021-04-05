package com.bjut.fit.sse.service.impl;

import com.bjut.fit.sse.dao.NameEntryDao;
import com.bjut.fit.sse.dao.impl.NameEntryDaoImpl;
import com.bjut.fit.sse.pojo.NameEntry;
import com.bjut.fit.sse.pojo.Page;
import com.bjut.fit.sse.service.NameEntryService;

import java.util.List;

public class NameEntryServiceImpl implements NameEntryService {

    private NameEntryDao nameEntryDao = new NameEntryDaoImpl();

    @Override
    public void register(NameEntry nameEntry) {
        nameEntryDao.saveNameEntry(nameEntry);
    }

    @Override
    public void updateNameEntry(NameEntry nameEntry) {
        nameEntryDao.updateNameEntry(nameEntry);
    }

    @Override
    public void deleteNameEntryByGuid(String guid) {
        nameEntryDao.deleteNameEntryByGuid(guid);
    }

    @Override
    public NameEntry findNameEntryByGuid(String guid) {
        return nameEntryDao.queryNameEntryByGuid(guid);
    }

    @Override
    public List<NameEntry> queryNameEntries() {
        return nameEntryDao.queryNameEntries();
    }

    @Override
    public Page<NameEntry> page(Integer pageNo, Integer pageSize) {

        Page<NameEntry> page = new Page<>();

        // 设置每页数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageCount = nameEntryDao.queryForPageCount();
        // 设置总记录数
        page.setPageCount(pageCount);
        // 求总页码
        Integer pageTotal = pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1;
        // 设置总页码
        page.setPageTotal(pageTotal);
        // 设置当前页码 == 一定要先求总页码
        page.setPageNo(pageNo);
        // 求begin的值
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        // 求当前页数据
        List<NameEntry> items = nameEntryDao.queryForPageItems(begin, page.getPageSize());
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
