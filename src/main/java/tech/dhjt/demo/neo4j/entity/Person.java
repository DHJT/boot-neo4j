package tech.dhjt.demo.neo4j.entity;

import java.util.List;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipId;

import lombok.Builder;
import lombok.Data;

@Node
@Data
@Builder
public class Person {

    @RelationshipId
    private Long id;

    private String name;

    // 如果需要，可以定义与其他实体的关系
    @Relationship(type = "KNOWS", direction = Relationship.Direction.OUTGOING)
    private List<Person> knows;

}

// 注意：在Spring Data Neo4j 6.x中，通常不需要显式地定义关系的实体类，除非你需要对关系属性进行建模。
