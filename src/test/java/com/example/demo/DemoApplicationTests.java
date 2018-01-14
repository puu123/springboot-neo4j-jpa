package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.data.jpa.UserEntityJpaRepository;
import com.example.demo.data.neo4j.UserNodeNeo4jRepository;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserEntityJpaRepository userJpaRepository;

    @Autowired
    UserNodeNeo4jRepository userNeo4jRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        userService.create(1L, "ほげ");
        log.info("u count.{}", "" + userJpaRepository.count());
        log.info("n count.{}", "" + userNeo4jRepository.count());
    }

    @Test
    public void testError() {
        try {
            userService.createError(1L, "ほげ");
        } catch (Exception e) {
            log.error("e.", e);
        }
        log.info("u count.{}", "" + userJpaRepository.count());
        log.info("n count.{}", "" + userNeo4jRepository.count());
    }

    @Test
    public void testErrorNoTx() {
        try {
            userService.createErrorNoTx(1L, "ほげ");
        } catch (Exception e) {
            log.error("e.", e);
        }
        log.info("u count.{}", "" + userJpaRepository.count());
        log.info("n count.{}", "" + userNeo4jRepository.count());
    }


}
