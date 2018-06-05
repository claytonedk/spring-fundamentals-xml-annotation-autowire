package com.kuhn.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kuhn.entity.Customer;
import com.kuhn.enums.CustomerType;
import com.kuhn.log.Log;
import com.kuhn.repository.CustomerRepository;
import com.kuhn.strategy.discount.DiscountCalc;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	private Log mainLog;
	private List<Log> logs;
	private Map<CustomerType, DiscountCalc> mapDiscount;
	
	@Autowired
	public void setMainLog(@Qualifier("dbLog") Log mainLog) {
		this.mainLog = mainLog;
	}

	@Autowired
	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	@Resource(name="mapDiscount")
	public void setMapDiscount(Map<CustomerType, DiscountCalc> mapDiscount) {
		this.mapDiscount = mapDiscount;
	}

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAll() {
		mainLog.log("CustomerService.getAll()");
		
		logs.forEach((v) -> v.log("CustomerService.getAll()"));
		
		return customerRepository.getAll();
	}

	@Override
	public double calculerRabais(CustomerType customerType, double valeurTotale) {
		return mapDiscount.get(customerType).calculateDiscount(valeurTotale);
	}
}
