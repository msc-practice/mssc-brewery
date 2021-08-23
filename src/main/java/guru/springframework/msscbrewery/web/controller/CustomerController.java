package guru.springframework.msscbrewery.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }
  @GetMapping({"/{customerId}"})
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
    return ResponseEntity.ok(customerService.getCustomerById(customerId));
  }
  
}
