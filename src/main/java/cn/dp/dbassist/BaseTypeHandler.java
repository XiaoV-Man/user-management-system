package cn.dp.dbassist;

import java.sql.ResultSet;

/**
 * 此实现类用来封装单个数据对象
 */
public class BaseTypeHandler implements ResultSetHandler {



    public Object handle(ResultSet rs) {
        try {
            if (rs.next()) {
                return rs.getObject(1);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("数据封装失败");
        }

    }
}
