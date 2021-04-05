package com.bjut.fit.sse.dao.impl;

import com.bjut.fit.sse.dao.NameEntryDao;
import com.bjut.fit.sse.pojo.NameEntry;

import java.util.List;

public class NameEntryDaoImpl extends BaseDao implements NameEntryDao {


    @Override
    public int saveNameEntry(NameEntry nameEntry) {
        String sql = "insert into t_name_entry(`readableName`,`guid`,`ip`) values(?,?,?)";
        return update(sql, nameEntry.getReadableName(), nameEntry.getGuid(), nameEntry.getIp());
    }

    @Override
    public int updateNameEntry(NameEntry nameEntry) {
        String sql = "update t_name_entry set `readableName`=?,`ip`=? where guid=?";
        return update(sql, nameEntry.getReadableName(), nameEntry.getIp(), nameEntry.getGuid());
    }

    @Override
    public int deleteNameEntryByGuid(String guid) {
        String sql = "delete from t_name_entry where guid=?";
        return update(sql, guid);
    }

    @Override
    public List<NameEntry> queryNameEntries() {
        String sql = "select `readableName`,`guid`,`ip` from t_name_entry";
        return queryList(NameEntry.class, sql);
    }

    @Override
    public NameEntry queryNameEntryByGuid(String guid) {
        String sql = "select `readableName`,`guid`,`ip` from t_name_entry where guid = ?";
        return queryOne(NameEntry.class, sql, guid);
    }

    @Override
    public NameEntry queryNameEntryByReadableName(String readableName) {
        String sql = "select `readableName`,`guid`,`ip` from t_name_entry where readableName = ?";
        return queryOne(NameEntry.class, sql, readableName);
    }

    @Override
    public NameEntry queryNameEntryByIp(String ip) {
        String sql = "select `readableName`,`guid`,`ip` from t_name_entry where ip = ?";
        return queryOne(NameEntry.class, sql, ip);
    }

    @Override
    public Integer queryForPageCount() {
        String sql = "select count(*) from t_name_entry";
        return new Integer(queryForSingleValue(sql).toString());
    }

    @Override
    public List<NameEntry> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select `readableName`,`guid`,`ip` from t_name_entry limit ?, ?";
        return queryList(NameEntry.class, sql, begin, pageSize);
    }

}
