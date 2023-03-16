package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

//@Configuration 当SpringConfiguration中使用import注解时，本类中不用Configuration注解
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRunner对象
     * 把当前方法的返回值作为bean对象存入ioc容器中
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
    @Scope(value="prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name="dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(this.driver);
            dataSource.setJdbcUrl(this.url);
            dataSource.setUser(this.user);
            dataSource.setPassword(this.password);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
