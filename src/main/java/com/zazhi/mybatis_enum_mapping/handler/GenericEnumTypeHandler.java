package com.zazhi.mybatis_enum_mapping.handler;

import com.zazhi.mybatis_enum_mapping.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericEnumTypeHandler<E extends Enum<E> & BaseEnum<T>, T> extends BaseTypeHandler<E> {

	// 保存当前处理的枚举类型的 `Class` 对象，用于反射调用。
    private final Class<E> type;  
  
    public GenericEnumTypeHandler(Class<E> type) {  
        if (type == null) throw new IllegalArgumentException("Type argument cannot be null");  
        this.type = type;  
    }  
  
    @Override  
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getCode());  
    }  
  
    @Override  
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object value = rs.getObject(columnName);  
        return valueOf((T) value);  
    }  
  
    @Override  
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {  
        Object value = rs.getObject(columnIndex);  
        return valueOf((T) value);  
    }  
  
    @Override  
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object value = cs.getObject(columnIndex);  
        return valueOf((T) value);  
    }  
  
    private E valueOf(T value) {  
        if (value == null) {  
            return null;  
        }  
        try {  
            Method method = type.getMethod("fromCode", value.getClass());
            return (E) method.invoke(null, value);  
        } catch (Exception e) {  
            throw new RuntimeException("Cannot convert value to enum: " + value, e);  
        }  
    }  
}