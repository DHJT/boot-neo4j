package tech.dhjt.demo.neo4j.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import lombok.Builder;
import lombok.Data;

@NodeEntity(label = "dept")
@Data
@Builder
public class Dept {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "deptName")
    private String deptName;

}