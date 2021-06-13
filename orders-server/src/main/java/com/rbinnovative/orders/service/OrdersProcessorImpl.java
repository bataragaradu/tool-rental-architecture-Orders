package com.rbinnovative.orders.service;

import com.rb.innovative.client.model.Order;
import com.rbinnovative.orders.repository.OrdersRepository;
import com.rbinnovative.orders.exception.OrderException;
import com.rbinnovative.orders.model.dao.Orders;
import com.rbinnovative.orders.model.dto.OrdersDTO;
import com.rbinnovative.orders.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersProcessorImpl implements TransactionProcessor {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public OrdersDTO processOneQuery(Integer id) throws OrderException {
        Optional<Orders> orderOptional = ordersRepository.findById(id);
        Optional<OrdersDTO> ordersDTO = orderOptional.map((ordersElem) -> mapToOrdersDTOHandler(ordersElem, null));
        if (ordersDTO.isPresent()) {
            return ordersDTO.get();
        } else {
            throw new OrderException("The id doesn't exist, needs to be created " + id);
        }
    }

    @Override
    public List<OrdersDTO> processAllQuery() {
        List<Orders> orders = Optional.ofNullable(ordersRepository.findAll()).orElseGet(ArrayList::new);
        return orders.stream().map((ordersElem) -> mapToOrdersDTOHandler(ordersElem, null)).collect(Collectors.toList());
    }

    @Override
    public Order createOrder(Order orderRequest) {
        Orders createOrders = processOrderCreation(orderRequest);
        createOrders = ordersRepository.save(createOrders);
        Order resultOrder = new Order();
        BeanUtils.copyProperties(createOrders, resultOrder);
        return  resultOrder;
    }

    @Override
    public void removeOrder(Integer id) throws OrderException {
        Optional<Orders> ordersOptional = ordersRepository.findById(id);

        if (ordersOptional.isPresent()) {
            ordersRepository.delete(ordersOptional.get());
        } else {
            throw new OrderException("Order with requested id doesn't exist");
        }
    }


    private OrdersDTO mapToOrdersDTOHandler(Orders orders, List<String> fields) {
        OrdersDTO orderDTO = new OrdersDTO();
        if (fields != null) {
            Utils.copyProperties(orders, orderDTO, fields);
        } else {
            BeanUtils.copyProperties(orders, orderDTO);
        }
        return orderDTO;
    }

    private Orders processOrderCreation(Order orderRequest) {
        Orders createOrder = new Orders();
        BeanUtils.copyProperties(orderRequest, createOrder);
        //Particular request entities
        return createOrder;
    }


    public List<OrdersDTO> retrieveUserOrders(String userId) {
        List<Orders> orders = Optional.ofNullable(ordersRepository.findByUserId(userId)).orElseGet(ArrayList::new);
        return orders.stream().map((ordersElem) -> mapToOrdersDTOHandler(ordersElem, null)).collect(Collectors.toList());
    }
}