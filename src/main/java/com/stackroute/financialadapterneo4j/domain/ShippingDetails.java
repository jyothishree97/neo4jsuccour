package com.stackroute.financialadapterneo4j.domain;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@NodeEntity
public class ShippingDetails {

    @Id
    private String shipping_id;
    private String shipping_address;
}
