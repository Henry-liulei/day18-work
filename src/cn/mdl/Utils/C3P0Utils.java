package cn.mdl.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0Utils {
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
    public static DataSource getDateSource(){
        return dataSource;
    }
}
