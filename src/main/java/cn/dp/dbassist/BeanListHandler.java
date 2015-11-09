package cn.dp.dbassist;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 此实现类用来封装数据对象到一个list集合中
 */
public class BeanListHandler implements ResultSetHandler {

    private Class clazz;

    public BeanListHandler(Class clazz) {
        this.clazz = clazz;
    }

    public List handle(ResultSet rs) {
        try {
            List list = new ArrayList();
            while (rs.next()) {
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
                list.add(bean);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("数据封装失败");
        }

    }
}
