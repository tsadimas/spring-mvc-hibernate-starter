package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
