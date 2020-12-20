package com.spring.batch;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public class DataSourceConfig {
    private static Logger logger =
            LoggerFactory.getLogger(DataSourceConfig.class);

/*    @Bean
    public DataSource dataSourceH2() {
        try {
            EmbeddedDatabaseBuilder dbBuilder =
                    new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:"
                                    + "/org/springframework/batch/core/schema-h2.sql",
                            "classpath:support/singer.sql").build();
        } catch(Exception e){
                logger.error("Embedded DataSource bean cannot "
                        + "bå created!", e);
                return null;
            }
        }

    @Bean
    public DataSource dataSourceSqlite() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:repository.sqlite");
        return dataSource;
    }*/

    @Bean
    public DataSource dataSourceMysql() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/spring5probook?serverTimezone=EST5EDT");
        dataSource.setUsername("root");
        dataSource.setPassword("qwert");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("org/springframework/batch/core/schema-drop-mysql.sql"));
        databasePopulator.addScript(new ClassPathResource("org/springframework/batch/core/schema-mysql.sql"));
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        return dataSource;
    }

}
