package com.bjut.fit.sse.dao;

import com.bjut.fit.sse.pojo.NameEntry;

import java.util.List;

public interface NameEntryDao {

    /**
     * 保存名字
     * @param nameEntry
     * @return
     */
    public int saveNameEntry(NameEntry nameEntry);

    /**
     * 修改名字条目
     * @param nameEntry
     * @return
     */
    public int updateNameEntry(NameEntry nameEntry);

    /**
     * 删除名字条目
     * @param guid
     * @return
     */
    public int deleteNameEntryByGuid(String guid);

    /**
     * 查询全部名字条目
     * @return
     */
    public List<NameEntry> queryNameEntries();

    /**
     * 根据guid查询
     * @param guid
     * @return
     */
    public NameEntry queryNameEntryByGuid(String guid);

    /**
     * 根据可读名查询
     * @param readableName
     * @return
     */
    public NameEntry queryNameEntryByReadableName(String readableName);


    /**
     * 根据ip地址查询
     * @param ip
     * @return
     */
    public NameEntry queryNameEntryByIp(String ip);

    /**
     * 获得名字总数
     * @return
     */
    public Integer queryForPageCount();

    /**
     * 获得分页的数据
     * @param begin
     * @param pageSize
     * @return
     */
    public List<NameEntry> queryForPageItems(Integer begin, Integer pageSize);



//    public Integer queryForPageCountByPrice(Integer min, Integer max);
//
//
//    public List<NameEntry> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max);




}
