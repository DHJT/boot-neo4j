package tech.dhjt.demo.neo4j.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;

import lombok.Builder;
import lombok.Data;

@Node(labels = "dept")
@Data
@Builder
public class Dept {

    @RelationshipId
    private Long id;

    @Property(name = "deptName")
    private String deptName;

}