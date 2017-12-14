package gr.hua.dit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Customer;
import gr.hua.dit.entity.CustomerList;
import gr.hua.dit.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerList customerList;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Customer getCustomer(@PathVariable("id") int id) {

		Customer customer = customerService.getCustomer(id);
		System.out.println("customer :" + customer);

		return customer;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public CustomerList getCustomers() {

		List<Customer> customers = customerService.getCustomers();
		System.out.println("customers :" + customers);
		this.customerList.setCustomerList(customers);
		return this.customerList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Customer createCustomer(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer = new Customer(firstName, lastName, email);
		customerService.saveCustomer(customer);
		return customer;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Customer createCustomerfromJson(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	

}
