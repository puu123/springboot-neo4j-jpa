package com.example.demo.data.neo4j;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NodeEntity(label="User")
@Data
@NoArgsConstructor
public class UserNode {

    @GraphId
    Long id;

    String name;

}
