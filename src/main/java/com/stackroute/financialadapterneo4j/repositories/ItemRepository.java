package com.stackroute.financialadapterneo4j.repositories;

import com.stackroute.financialadapterneo4j.domain.Item;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ItemRepository extends Neo4jRepository<Item,String> {
}
