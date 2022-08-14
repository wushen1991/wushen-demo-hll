package com.example.wushendemo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("db1.datasource")
    public DataSourceProperties db1DataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource db1DataSource(){
        DataSourceProperties dataSourceProperties = db1DataSourceProperties();
        log.info("db1 url:{}",dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager db1TransactionManager(DataSource db1DataSource){
        return new DataSourceTransactionManager(db1DataSource);
    }




//    @Bean(name = "PrimarySqlSessionFactory")
//    @Primary
//    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("db1DataSource") DataSource datasource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(datasource);
//        bean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));
//        return bean.getObject();// 设置mybatis的xml所在位置
//    }
//
//
//    @Bean("PrimarySqlSessionTemplate")
//    // 表示这个数据源是默认数据源
//    @Primary
//    public SqlSessionTemplate primarySqlSessionTemplate(
//            @Qualifier("PrimarySqlSessionFactory") SqlSessionFactory sessionfactory) {
//        return new SqlSessionTemplate(sessionfactory);
//    }



    @Bean
    @ConfigurationProperties("db2.datasource")
    public DataSourceProperties db2DataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource db2DataSource(){
        DataSourceProperties dataSourceProperties = db2DataSourceProperties();
        log.info("db2 url:{}",dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public PlatformTransactionManager db2TransactionManager(DataSource db2DataSource){
        return new DataSourceTransactionManager(db2DataSource);
    }

}
