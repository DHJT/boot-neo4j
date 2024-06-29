package tech.dhjt.demo.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import tech.dhjt.demo.neo4j.entity.DeptREmployee;

public interface DeptREmployeeRepository extends Neo4jRepository<DeptREmployee, Long> {

}
