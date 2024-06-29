package tech.dhjt.demo.neo4j.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import tech.dhjt.demo.neo4j.entity.Employee;

public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {

    List<Employee> findByName(String name);

    /**
     * 自定义的Cypher查询
     *
     * @param eNo
     * @return
     */
    @Query("MATCH (p:Employee) WHERE p.eNo = $eNo RETURN p")
    List<Employee> findByENo(@Param("eNo") String eNo);

    @Query("MATCH (p:Employee) WHERE p.name = $name RETURN p")
    List<Employee> findByNameUsingCypher(@Param("name") String name);

}