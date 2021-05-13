package com.rbinnovative.orders.controller;

import com.rbinnovative.orders.exception.OrderException;
import com.rbinnovative.orders.model.dto.OrdersDTO;
import com.rbinnovative.orders.service.OrdersProcessorImpl;
import com.rbinnovative.orders.utils.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = Constants.ORDERS_ENDPOINT, method = RequestMethod.GET)
public class OrdersQueryController {

    private Logger logger = LoggerFactory.getLogger(OrdersQueryController.class);

    @Autowired
    private OrdersProcessorImpl ordersProcessor;

    /**
     * Support for GET /orders endpoint without uri params.
     *
     * @return all orders with all fields
     */
    @ApiOperation(value = "GET all orders")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The orders"),
            @ApiResponse(code = 400, message = " Error if missing a mandatory parameter "),
            @ApiResponse(code = 404, message = " ")})
    @RequestMapping
    public ResponseEntity<List<OrdersDTO>> retrieveAllOrders() {
        logger.info("GET all orders");
        List<OrdersDTO> ordersDTOs = ordersProcessor.processAllQuery();

        logger.info("GET all orders response {}", ordersDTOs);
        return ResponseEntity.ok().body(ordersDTOs);
    }

    /**
     * Support for GET /orders endpoint by id
     *
     * @return invoice by id
     */
    @ApiOperation(value = "Query invoice by id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success query")})
    @RequestMapping(value = "/{id}", params = {"!fields"})
    public ResponseEntity<OrdersDTO> retrieveOrderById(@PathVariable Integer id) throws OrderException {
        logger.info("GET invoice with id {}", id);
        OrdersDTO invoiceDTO = ordersProcessor.processOneQuery(id);
        logger.info("GET invoice response received {}", invoiceDTO);
        return ResponseEntity.ok().body(invoiceDTO);
    }
}
