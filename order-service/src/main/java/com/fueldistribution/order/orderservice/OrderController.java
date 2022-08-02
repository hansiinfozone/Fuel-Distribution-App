package com.fueldistribution.order.orderservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/orders")
public class OrderController {

	private OrderProducer orderProducer;

	@Autowired
	OrderService orderService;
	
	@Autowired
	public OrderController(OrderProducer orderProducer) {
		this.orderProducer = orderProducer;
	}
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@PostMapping(path="/create")
	public String createAndProduceOrder(@RequestBody Order order) {
		
		Order orderWithRef = orderDetailsRepository.save(order);
		System.out.println(orderWithRef);
		orderProducer.produceOrder(orderWithRef);
		return "order placed successfully";
		
	}
	
	 @GetMapping(path="/all")  
	 public @ResponseBody Iterable<Order> getAllOrders() {
			
			 return orderDetailsRepository.findAll();
		}
	 
	 @RequestMapping(value="/order" ,method=RequestMethod.GET)
		public ResponseEntity<Optional<Order>> fetchStudent(@RequestParam Integer referenceNumber) {
		
			Optional<Order> order = orderService.fetchOrdertByReferenceNumber(referenceNumber);
			
			if (order==null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok().body(order);
			}
		}
	
	
}
