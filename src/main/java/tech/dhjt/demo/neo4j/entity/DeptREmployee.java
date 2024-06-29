package tech.dhjt.demo.neo4j.entity;


import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import lombok.Builder;
import lombok.Data;

//@RelationshipProperties(type = "deptREmployee")
@RelationshipProperties
@Data
@Builder
public class DeptREmployee {

    @RelationshipId
    private Long id;

    @StartNode
    private Dept parent;

    @EndNode
    private Employee child;

}
