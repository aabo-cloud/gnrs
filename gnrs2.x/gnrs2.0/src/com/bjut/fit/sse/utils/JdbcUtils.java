package com.bjut.fit.sse.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    public static DruidDataSource dataSource;

    static {
        try {
            // 创建属性配置类
            Properties properties = new Properties();
            // 读取jdbc.properties
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载键值对
            properties.load(resourceAsStream);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据库连接池中获得一条连接
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;

        // 从数据库连接池中获得连接
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭一条连接 / 放回数据库连接池中
     * @param conn
     */
    public static void closeConnection(Connection conn) {

        if (conn != null) {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
