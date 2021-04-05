package com.bjut.fit.sse.dao.impl;

import com.bjut.fit.sse.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();


    /**
     * 执行 insert, update, delete 语句
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return -1;
    }

    /**
     * 查找一个bean对象的select语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryOne(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    /**
     * 执行返回多个bean对象的select语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryList(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    /**
     * 执行只需要返回某列数据的select语句
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
//            ScalarHandler用来获得聚合函数的值
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

}
