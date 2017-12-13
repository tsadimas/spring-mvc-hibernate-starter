package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CustomerList")
@Component
public class CustomerList {

	List<Customer> customerList;
	
	public List<Customer> getCustomerList(){
		return customerList; 
	}
	
	public void setCustomerList(List<Customer> customerList) {
		this.customerList=customerList;
	}
	
}
