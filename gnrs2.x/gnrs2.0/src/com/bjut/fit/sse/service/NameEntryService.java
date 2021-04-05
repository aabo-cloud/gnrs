package com.bjut.fit.sse.service;

import com.bjut.fit.sse.pojo.NameEntry;
import com.bjut.fit.sse.pojo.Page;

import java.util.List;

public interface NameEntryService {

    /**
     * 注册名字
     *
     * @param nameEntry
     */
    public void register(NameEntry nameEntry);

    /**
     * 更新名字条目
     * @param nameEntry
     */
    public void updateNameEntry(NameEntry nameEntry);

    /**
     * 删除名字条目
     * @param guid
     */
    public void deleteNameEntryByGuid(String guid);

    /**
     * 通过guid查找名字
     * @param guid
     * @return
     */
    public NameEntry findNameEntryByGuid(String guid);

    /**
     * 查询所有名字
     * @return
     */
    public List<NameEntry> queryNameEntries();

    /**
     * 获得分页数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<NameEntry> page(Integer pageNo, Integer pageSize);

}
