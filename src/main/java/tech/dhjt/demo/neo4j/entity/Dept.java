package tech.dhjt.demo.neo4j.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Builder;
import lombok.Data;

@Node(labels = "dept")
@Data
@Builder
public class Dept {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "deptName")
    private String deptName;

}