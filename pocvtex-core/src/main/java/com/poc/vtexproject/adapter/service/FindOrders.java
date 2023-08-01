package com.poc.vtexproject.adapter.service;

import com.poc.vtexproject.domain.OrderDomain;

public interface FindOrders {

    OrderDomain findByOrderId(String orderId);

}
