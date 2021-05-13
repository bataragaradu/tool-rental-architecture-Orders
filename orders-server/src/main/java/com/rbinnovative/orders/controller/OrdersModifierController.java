package com.rbinnovative.orders.controller;

import com.rb.innovative.client.model.Order;
import com.rbinnovative.orders.exception.OrderException;
import com.rbinnovative.orders.service.OrdersProcessorImpl;
import com.rbinnovative.orders.utils.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = Constants.ORDERS_ENDPOINT)
public class OrdersModifierController {

	private final Logger logger = LoggerFactory.getLogger(OrdersModifierController.class);

	@Autowired
	private OrdersProcessorImpl ordersProcessor;

	/**
	 * Support for POST /orders endpoint
	 * @return the id of created orders
	 */
	@ApiOperation(value = "POST orders ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Save a new order"),
			@ApiResponse(code = 400, message = " order already exists with that key could not be found")})
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveOrder(@Valid @RequestBody Order orderRequest) throws OrderException {

		logger.info("Save a new order {}", orderRequest);
		Integer OrderId = ordersProcessor.createOrder(orderRequest).getId();
		logger.info("POST successfully saved order with id {}",OrderId);
		return ResponseEntity.ok().body(OrderId.toString());
	}

		/**
	 * Support for DELETE /order endpoint
	 * @return the id of deleted order
	 */
	@ApiOperation(value = "DELETE order ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Remove a order"),
			@ApiResponse(code = 400, message = " order with that id could not be found")})
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteOrder(@PathVariable Integer id) throws OrderException {

		logger.info("Remove a order with id {}", id);
		ordersProcessor.removeOrder(id);
		logger.info("DELETE  response sent with no body");
		return ResponseEntity.ok().body(StringUtils.EMPTY);
	}

//	/**
//	 * Support for POST /order endpoint
//	 * @return the id of updated order
//	 */
//	@ApiOperation(value = "PUT order ")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Update a order"),
//			@ApiResponse(code = 400, message = " order with that id could not be found")})
//	@RequestMapping(value ="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> updateOrder(@PathVariable Integer id, @Valid @RequestBody OrderRequest OrderRequest) throws OrderException, BillerException {
//
//		logger.info("Update a parameter settings {} with id {}", OrderRequest, id);
//		OrdersProcessor.updateParameter(id, OrderRequest);
//		logger.info("PUT response sent with no body");
//		return ResponseEntity.ok().body(StringUtils.EMPTY);
//	}
//
//	/**
//	 * Support for DELETE /order endpoint
//	 * @return the id of deleted order
//	 */
//	@ApiOperation(value = "DELETE order ")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Remove a order"),
//			@ApiResponse(code = 400, message = " order with that id could not be found")})
//	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> deleteOrder(@PathVariable Integer id) throws OrderException {
//
//		logger.info("Remove a order with id {}", id);
//		OrdersProcessor.removeParameter(id);
//		logger.info("DELETE  response sent with no body");
//		return ResponseEntity.ok().body(StringUtils.EMPTY);
//	}
}
