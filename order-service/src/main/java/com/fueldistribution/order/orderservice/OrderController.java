package com.fueldistribution.order.orderservice;

import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fueldistribution.basedomains.Order;

@RestController
@CrossOrigin
@RequestMapping(path = "/orders")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	private OrderProducer orderProducer;

	@Autowired
	OrderService orderService;

	@Autowired
	public OrderController(OrderProducer orderProducer) {
		this.orderProducer = orderProducer;
	}

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@PostMapping(path = "/create")
	public Order createAndProduceOrder(@RequestBody Order order) {

		LOGGER.info("inside create and produce order method");
		order.setReferenceNumber(UUID.randomUUID().toString());
		order.setStatus("ORDER CREATED");
		order.setMessage("order created successfully");
		orderProducer.sendMessage(order);
		order = orderDetailsRepository.save(order);

		sendReferenceNumber(order.getReferenceNumber());
		return order;

	}

	@GetMapping(path = "/ref", produces = MediaType.APPLICATION_JSON_VALUE)
	private String sendReferenceNumber(@RequestParam String referenceNumber) {

		return referenceNumber;

	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Order> getAllOrders() {

		return orderDetailsRepository.findAll();
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ResponseEntity<Optional<Order>> getOrderDetails(@RequestParam String referenceNumber) {

		Optional<Order> order = orderService.fetchOrdertByReferenceNumber(referenceNumber);

		if (order == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(order);
		}
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public @ResponseBody String getOrderStatus(@RequestParam String referenceNumber) {

		String orderStatus = orderService.fetchOrderStatustByReferenceNumber(referenceNumber);
		return orderStatus;

	}

	public void updateStatus(String refNo, String status) {

		Order order = orderDetailsRepository.getByReferenceNumber(refNo);
		order.setStatus("COMPLETED");
		order = orderDetailsRepository.save(order);

	}

	public void updateStatusAllocate(String refNo, String status) {

		LOGGER.info(String.format("inside updateStatusAllocate method"));
		Order order = orderDetailsRepository.getByReferenceNumber(refNo);
		order.setStatus("ALLOCATED");
		order = orderDetailsRepository.save(order);

	}

	public void updateStatusScheduled(String refNo, String status) {

		LOGGER.info(String.format("inside updateStatusScheduled method"));
		Order order = orderDetailsRepository.getByReferenceNumber(refNo);
		order.setStatus("DISPATCH SCHEDULED");
		order = orderDetailsRepository.save(order);

	}

}
