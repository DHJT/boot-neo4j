package tech.dhjt.demo.neo4j.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Builder;
import lombok.Data;

@Node(labels = "employee")
@Data
@Builder
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "eNo")
    private String eNo;

    @Property(name = "title")
    private String title;

    @Property(name = "name")
    private String name;

    @Property(name = "group")
    private String group;

}
