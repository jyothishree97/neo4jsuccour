package com.stackroute.financialadapterneo4j.domain;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@NodeEntity
public class SellerDetails {

    @Id
    private String seller_id;
    private String seller_name;
    private String seller_address;
    private String  seller_email;
    private String seller_phone;
    @Relationship(type = "HAS_A",direction = Relationship.OUTGOING)
    private Item item;
}
