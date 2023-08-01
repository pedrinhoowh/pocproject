package com.poc.vtexproject.service;

import com.poc.vtexproject.adapter.service.FindOrders;
import com.poc.vtexproject.domain.OrderDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class FindOrdersService implements FindOrders {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${vtex.url}")
    private String vtexUrl;

    @Value("${vtex.appkey}")
    private String vtexAppkey;

    @Value("${vtex.apptoken}")
    private String vtexApptoken;

    @Override
    public OrderDomain findByOrderId(String orderId) {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("X-VTEX-API-AppKey", vtexAppkey);
        headers.add("X-VTEX-API-AppToken", vtexApptoken);

        ResponseEntity<OrderDomain> responseEntity = restTemplate.exchange(
                vtexUrl + "/orders/" + orderId, HttpMethod.GET, new HttpEntity<>(headers),
                OrderDomain.class);

        return responseEntity.getBody();
    }

}
