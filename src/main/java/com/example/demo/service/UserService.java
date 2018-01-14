package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.jpa.UserEntity;
import com.example.demo.data.jpa.UserEntityJpaRepository;
import com.example.demo.data.neo4j.UserNode;
import com.example.demo.data.neo4j.UserNodeNeo4jRepository;

@Component
public class UserService {

    @Autowired
    UserEntityJpaRepository userJpaRepository;

    @Autowired
    UserNodeNeo4jRepository userNeo4jRepository;

    @Transactional
    public void create(Long id, String name) {
        this.createInternal(id, name);
    }

    @Transactional
    public void createError(Long id, String name) {
        this.createInternal(id, name);
        throw new RuntimeException();
    }

    public void createErrorNoTx(Long id, String name) {
        this.createInternal(id, name);
        throw new RuntimeException();
    }

    void createInternal(Long id, String name) {
        UserEntity e = new UserEntity();
        e.setId(id);
        e.setName(name);
        UserNode n = new UserNode();
        //n.setId(id);
        n.setName(name);
        userJpaRepository.save(e);
        userNeo4jRepository.save(n);
    }

}
