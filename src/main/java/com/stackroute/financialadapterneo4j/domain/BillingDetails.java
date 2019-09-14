package com.stackroute.financialadapterneo4j.domain;

import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NodeEntity
public class BillingDetails {

    private String billing_address;
    private String bill_id;

}
