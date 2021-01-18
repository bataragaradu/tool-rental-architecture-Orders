package com.rbinnovative.orders.service;

import com.rbinnovative.orders.model.dto.OrdersDTO;
import com.rbinnovative.orders.model.request.OrderRequest;
import com.rbinnovative.orders.exception.OrderException;

import java.util.List;

public interface TransactionProcessor {
    OrdersDTO processOneQuery(Integer id) throws OrderException;

    List<OrdersDTO> processAllQuery();

    OrdersDTO createOrder(OrderRequest orderRequest);

    //    @Override
    //    public OrderDTO updateParameter(Integer id, OrderRequest invoiceRequest) throws OrderException, BillerException {
    //        Optional<Order> requestUpdateId = Optional.empty();
    //        if (id != null) {
    //            requestUpdateId = invoiceRepository.findById(id);
    //        }
    //        if (requestUpdateId.isPresent()) {
    //            Order updateOrder = requestUpdateId.get();
    //            Utils.copyProperties(invoiceRequest, updateOrder, invoiceRequestFields);
    //            updateOrder.setUpdatedAt(LocalDateTime.now());
    //            updateOrder.setBillerId(extractBillerId(invoiceRequest.getBillerId()));
    //            updateOrder = invoiceRepository.save(updateOrder);
    //            return mapToOrderDTOHandler(updateOrder, null);
    //        } else {
    //            throw new OrderException("The id " + id + " doesn't exist, needs to be created ");
    //        }
    //    }
    //
    void removeOrder(Integer id) throws OrderException;
}
