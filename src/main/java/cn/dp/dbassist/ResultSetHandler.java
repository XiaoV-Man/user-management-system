package cn.dp.dbassist;

import java.sql.ResultSet;

public interface ResultSetHandler {
    /**
     * 用于把结果集封装成对象
     * @param rs 结果集
     * @return 封装好的对象
     */
    Object handle(ResultSet rs);
}
