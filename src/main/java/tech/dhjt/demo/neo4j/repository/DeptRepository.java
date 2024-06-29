package tech.dhjt.demo.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import tech.dhjt.demo.neo4j.entity.Dept;

public interface DeptRepository extends Neo4jRepository<Dept, Long> {

}