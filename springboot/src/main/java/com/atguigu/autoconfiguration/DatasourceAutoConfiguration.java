package com.atguigu.autoconfiguration;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * DatasourceAutoConfiguration
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/1 13:26
 **/
@Configuration
@EnableConfigurationProperties(DataProperties.class)
//@Import(DataProperties.class)
public class DatasourceAutoConfiguration {
    @Autowired
    private DataProperties datasourceProperties;

    @Bean
    @ConditionalOnProperty(value = "spring.jdbc.datasource.type",havingValue = "druid")
    public DataSource createDruidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(datasourceProperties.getDriver());
        dataSource.setUrl(datasourceProperties.getUrl());
        dataSource.setUsername(datasourceProperties.getUsername());
        dataSource.setPassword(datasourceProperties.getPassword());
        return dataSource;
    }

    @Bean
    @ConditionalOnProperty(value = "spring.jdbc.datasource.type",havingValue = "c3p0")
    public DataSource createC3p0DataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(datasourceProperties.getDriver());
        dataSource.setJdbcUrl(datasourceProperties.getUrl());
        dataSource.setUser(datasourceProperties.getUsername());
        dataSource.setPassword(datasourceProperties.getPassword());
        return dataSource;
    }
}
