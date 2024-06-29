package tech.dhjt.demo.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
public class Neo4jApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Neo4jApplication.class, args);
    }

}
