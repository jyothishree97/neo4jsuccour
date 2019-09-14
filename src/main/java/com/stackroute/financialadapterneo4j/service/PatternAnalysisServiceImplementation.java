package com.stackroute.financialadapterneo4j.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.financialadapterneo4j.domain.CardDetails;
import com.stackroute.financialadapterneo4j.domain.IPAddress;
import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.TransactionDetails;
import com.stackroute.financialadapterneo4j.repositories.PatternAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;
import java.util.List;

import static org.neo4j.driver.v1.Config.build;

@Service
public class PatternAnalysisServiceImplementation implements PatternAnalysisService {
    private PatternAnalysis patternAnalysis;

    @Autowired
    public PatternAnalysisServiceImplementation(PatternAnalysis patternAnalysis) {
        this.patternAnalysis = patternAnalysis;
    }

    @Override
    public Collection<Item> findByno_of_items(String no_of_items) {
        System.out.println("inside service method********" + patternAnalysis.findByno_of_items(no_of_items));
        return patternAnalysis.findByno_of_items(no_of_items);
    }

    @Override
    public Collection<IPAddress> findByName(String transaction_holder_name){
        return patternAnalysis.fingByName(transaction_holder_name);
    }

    @Override
    public List<TransactionDetails> findTransactions(){
        List<TransactionDetails> details=patternAnalysis.findTransactions();

        ObjectMapper mapper = new ObjectMapper();
//        List<TransactionDetails> user = mapper.readValue(details,TransactionDetails.class);
        if(details.contains("Jayashree")){
            System.out.println(details);
            return details;
        }
        else{
            return null;
        }

//
//        WebClient client= WebClient.builder()
//                .baseUrl("https://tools.keycdn.com/geo.json?host")
//                .build();

    }

    @Override
    public List<CardDetails> findCardDetails() {
        return patternAnalysis.findCardDetails();
    }

    @Override
    public TransactionDetails saveTransaction(TransactionDetails transactionDetails) {
      return patternAnalysis.save(transactionDetails);
    }
}
