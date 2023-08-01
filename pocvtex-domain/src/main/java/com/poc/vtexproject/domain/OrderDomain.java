package com.poc.vtexproject.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderDomain {

    private String orderId;

    private String sequence;

    private String marketplaceOrderId;

    private String marketplaceServicesEndpoint;

    private String sellerOrderId;

    private String origin;

    private String affiliateId;

    private String salesChannel;

    private String merchantName;

}
