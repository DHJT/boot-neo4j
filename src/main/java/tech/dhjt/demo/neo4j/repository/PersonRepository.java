package tech.dhjt.demo.neo4j.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import tech.dhjt.demo.neo4j.entity.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    // 你可以定义自定义的查询方法
    List<Person> findByName(String name);

}
