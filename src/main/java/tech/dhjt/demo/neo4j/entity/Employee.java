package tech.dhjt.demo.neo4j.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;

import lombok.Builder;
import lombok.Data;

@Node(labels = "employee")
@Data
@Builder
public class Employee {

    @RelationshipId
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
