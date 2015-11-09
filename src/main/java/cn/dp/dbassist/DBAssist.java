package cn.dp.dbassist;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 用来直接操作数据库的框架
 */
public class DBAssist {
    private final DataSource dataSource;

    public DBAssist(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //执行增删改操作
    public void update(String sql, Object... args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ParameterMetaData parameterMetaData = ps.getParameterMetaData();
            int count = parameterMetaData.getParameterCount();
            if (count > 0) {
                if (args == null) {
                    throw new IllegalArgumentException("有占位符,但未传入参数");
                }
                if (args.length != count) {
                    throw new IllegalArgumentException("传入的参数个数有误");
                }
                for (int i = 0; i < count; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            release(conn, ps, rs);
        }
    }

    public Object query(String sql, ResultSetHandler resultSetHandler, Object... args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ParameterMetaData parameterMetaData = ps.getParameterMetaData();
            int count = parameterMetaData.getParameterCount();
            if (count > 0) {
                if (args == null) {
                    throw new IllegalArgumentException("有占位符,但未传入参数");
                }
                if (args.length != count) {
                    throw new IllegalArgumentException("传入的参数个数有误");
                }
                for (int i = 0; i < count; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //处理结果集
            rs = ps.executeQuery();
            return resultSetHandler.handle(rs);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            release(conn, ps, rs);
        }
    }

    private void release(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
