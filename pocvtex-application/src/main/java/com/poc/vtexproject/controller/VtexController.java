package com.poc.vtexproject.controller;

import com.poc.vtexproject.adapter.service.FindOrders;
import com.poc.vtexproject.domain.OrderDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/vtex")
public class VtexController {

    @Autowired
    private FindOrders findOrders;

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderDomain> findByOrderId(@PathVariable("orderId") String orderId) {
        return ResponseEntity.ok(findOrders.findByOrderId(orderId));
    }

}
