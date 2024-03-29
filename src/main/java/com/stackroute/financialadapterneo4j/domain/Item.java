package com.stackroute.financialadapterneo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@NodeEntity(label = "Item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@JsonIdentityInfo(generator = JSONGenerator.class, property = "item_id")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id",scope=Item.class)
public class Item  {
    @Id
    private String item_id;
    private String item_name;
    private int item_price;
    private int no_of_items;
    private String parent_id;

}
