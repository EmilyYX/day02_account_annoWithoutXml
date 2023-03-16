package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 配置类，作用和bean.xml一样
 */
@Configuration
@ComponentScan(basePackages = {"com.yanxia.study"})//大括号可以拿走
public class SpringConfiguration {
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
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/easy");
            dataSource.setUser("root");
            dataSource.setPassword("test");
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
