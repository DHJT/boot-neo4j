package tech.dhjt.demo.neo4j.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import lombok.Builder;
import lombok.Data;

@NodeEntity(label = "employee")
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
