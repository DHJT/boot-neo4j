// package tech.dhjt.demo.neo4j.service;

// @Service
// public class EmployeeService {
//
// @Autowired
// private Neo4jTemplate neo4jTemplate;
//
// // public PersonService(Neo4jTemplate neo4jTemplate) {
// // this.neo4jTemplate = neo4jTemplate;
// // }
//
// public List<Employee> findByName(String name) {
// String cypher = "MATCH (p:Employee) WHERE p.name = $name RETURN p";
// Map<String, Object> parameters = Collections.singletonMap("name", name);
// return neo4jTemplate.findAll(cypher, parameters, Employee.class);
// }
//
// }
