package com.example.dbengin.config;

import com.example.dbengin.converter.BooleanToIntegerConverter;
import com.example.dbengin.converter.IntegerToBooleanConverter;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Optional;

@Configuration
//@EnableJdbcRepositories
public class ApplicationConfig extends AbstractJdbcConfiguration {

    //用Repository操作时，底层会用EntityRowMapper来映射数据库和JavaBean属性值，如果类型不一致且没有转换器会报异常
    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Arrays.asList(new BooleanToIntegerConverter(), new IntegerToBooleanConverter()));
    }


    //    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//    public HikariConfig hikariConfig() {
//        return new HikariConfig();
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        return new HikariDataSource(hikariConfig());
//    }
//    @Bean
//    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
//        return new NamedParameterJdbcTemplate(dataSource);
//    }
//
//    @Bean
//    TransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
