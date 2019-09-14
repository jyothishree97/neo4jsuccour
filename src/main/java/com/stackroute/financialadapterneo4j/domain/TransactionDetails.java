package com.stackroute.financialadapterneo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@NodeEntity(label = "Transaction")

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id",scope=TransactionDetails.class)

public class TransactionDetails {

    @Id
    public String transaction_id;
    public String transaction_holder_name;
    public String timestamp;
    public String transaction_holder_email;
    public String transaction_holder_phn_no;
    public String amount;
//    @Relationship(type = "IS_SHIPPING_ADDRESS",direction = Relationship.OUTGOING)
//    private ShippingDetails shippingDetails;
//    @Relationship(type = "IS_BILLING_ADDRESS",direction = Relationship.OUTGOING)
//    private BillingDetails billingDetails;
//    @Relationship(type = "IS_CONSISTS_OF",direction = Relationship.INCOMING)
//    private Item item;
//    @Relationship(type = "HAS_A_TRANSACTION",direction = Relationship.INCOMING)
//    private CardDetails cardDetails;
//    @Relationship(type = "IS_USED_FOR",direction = Relationship.INCOMING)
//    private IPAddress ipAddress;
}
