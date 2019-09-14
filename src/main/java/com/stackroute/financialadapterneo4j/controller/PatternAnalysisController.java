package com.stackroute.financialadapterneo4j.controller;

import com.stackroute.financialadapterneo4j.domain.CardDetails;
import com.stackroute.financialadapterneo4j.domain.IPAddress;
import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.TransactionDetails;
import com.stackroute.financialadapterneo4j.service.ItemService;
import com.stackroute.financialadapterneo4j.service.PatternAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PatternAnalysisController {

    private PatternAnalysisService patternAnalysisService;
    private ItemService itemService;

    @Autowired
    public PatternAnalysisController(PatternAnalysisService patternAnalysisService,ItemService itemService){
        this.patternAnalysisService=patternAnalysisService;
        this.itemService=itemService;
    }

    @GetMapping("item")
    public ResponseEntity<Iterable<Item>>  getByNo_Of_Items (String no_of_items){
        System.out.println(no_of_items);
        System.out.println("inside controller method*******");
        Iterable<Item> items = patternAnalysisService.findByno_of_items(no_of_items);
        System.out.println(items);
        return new ResponseEntity<>(patternAnalysisService.findByno_of_items(no_of_items),HttpStatus.OK);
    }

    @GetMapping("transaction")
    public ResponseEntity<List<TransactionDetails>>  getTransactions(){
        List<TransactionDetails> transactionDetails = patternAnalysisService.findTransactions();
        System.out.println(transactionDetails);
        return new ResponseEntity<>(patternAnalysisService.findTransactions(),HttpStatus.OK);
    }

    @GetMapping("transaction/{transaction_holder_name}")
    public ResponseEntity<Iterable<IPAddress>>  getByName(@PathVariable("transaction_holder_name") String transaction_holder_name) {

        Iterable<IPAddress> transactionDetails=patternAnalysisService.findByName(transaction_holder_name);
        System.out.println(transactionDetails);
        return new ResponseEntity<>(patternAnalysisService.findByName(transaction_holder_name),HttpStatus.OK);
    }

    @GetMapping("carddetails")
    public ResponseEntity<Iterable<CardDetails>> getCardDetails(String card_no){
        Iterable<CardDetails> cardDetails=patternAnalysisService.findCardDetails();
        System.out.println(cardDetails);
        return new ResponseEntity<>(patternAnalysisService.findCardDetails(),HttpStatus.OK);
    }

//    @PostMapping("items")
//    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
//        Item obj = itemService.saveItem(item);
//        System.out.println(obj);
//        return new ResponseEntity<Item>(obj, HttpStatus.OK);
//    }

    @PostMapping("transactions")
    public ResponseEntity<TransactionDetails> saveTransactions(@RequestBody TransactionDetails transactionDetails)
    {
        System.out.println(transactionDetails);
        TransactionDetails obj=patternAnalysisService.saveTransaction(transactionDetails);
        System.out.println(obj);
        return new ResponseEntity<TransactionDetails>(obj,HttpStatus.OK);
    }
}
