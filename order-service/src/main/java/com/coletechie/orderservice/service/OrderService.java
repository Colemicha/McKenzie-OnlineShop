package com.coletechie.orderservice.service;

import com.coletechie.orderservice.dto.OrderRequest;

public interface OrderService {
    String placeOrder (OrderRequest orderRequest);
}
