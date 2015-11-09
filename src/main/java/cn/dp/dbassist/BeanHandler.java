package cn.dp.dbassist;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 此实现类用来封装单个数据对象
 */
public class BeanHandler implements ResultSetHandler {

    private Class clazz;

    public BeanHandler(Class clazz) {
        this.clazz = clazz;
    }

    public Object handle(ResultSet rs) {
        try {
            if (rs.next()) {
                Object bean = clazz.newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int count = rsmd.getColumnCount();
                for (int i = 0; i < count; i++) {
                    String fieldName = rsmd.getColumnName(i + 1);
                    Object fieldValue = rs.getObject(i + 1);
                    Field f = clazz.getDeclaredField(fieldName);
                    f.setAccessible(true);
                    f.set(bean, fieldValue);
                }
                return bean;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("数据封装失败");
        }

    }
}
