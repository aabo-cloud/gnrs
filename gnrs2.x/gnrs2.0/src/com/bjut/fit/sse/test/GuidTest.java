package com.bjut.fit.sse.test;

import com.bjut.fit.sse.pojo.NameEntry;
import com.bjut.fit.sse.utils.GuidUtils;
import com.bjut.fit.sse.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class GuidTest {

    @Test
    public void test() {

        NameEntry nameEntry = new NameEntry("soul", "127.0.0.1");

        System.out.println(nameEntry.toString());

    }

    QueryRunner queryRunner = new QueryRunner();

    @Test
    public void test2() {

        for (int i = 0; i < 100; i++) {

            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn.toString());
            JdbcUtils.closeConnection(conn);
        }

    }

    @Test
    public void test3() throws Exception {

        String sql = "select `readableName`, `guid`, `ip` from t_name_entry";

        Connection connection = JdbcUtils.getConnection();

        List<NameEntry> nameEntries = queryRunner.query(connection, sql, new BeanListHandler<NameEntry>(NameEntry.class));

        JdbcUtils.closeConnection(connection);

        System.out.println(nameEntries);
    }

    @Test
    public void test4() throws Exception {

        NameEntry x = new NameEntry("soul", "127.0.0.1");
        NameEntry y = new NameEntry("x1c", "127.0.0.2");
        x.setGuid("12345678123456781234567812345678");
        System.out.println(GuidUtils.certifyGuid(x));
        System.out.println(GuidUtils.certifyGuid(y));

    }


}
