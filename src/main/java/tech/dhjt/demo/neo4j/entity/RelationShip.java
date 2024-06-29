package tech.dhjt.demo.neo4j.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import lombok.Builder;
import lombok.Data;

//@RelationshipEntity(type = "relationShip")
@RelationshipProperties
@Data
@Builder
public class RelationShip {

    @RelationshipId
    private Long id;

    @StartNode
    private Dept parent;

    @EndNode
    private Dept child;

}
