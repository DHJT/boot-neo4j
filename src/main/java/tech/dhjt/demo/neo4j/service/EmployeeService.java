package tech.dhjt.demo.neo4j.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

import tech.dhjt.demo.neo4j.entity.Employee;

@Service
public class EmployeeService {

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    public EmployeeService(Neo4jTemplate neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }

    public List<Employee> findByName(String name) {
        String cypher = "MATCH (p:Employee) WHERE p.name = $name RETURN p";
        Map<String, Object> parameters = Collections.singletonMap("name", name);
        return neo4jTemplate.findAll(cypher, parameters, Employee.class);
    }

}
