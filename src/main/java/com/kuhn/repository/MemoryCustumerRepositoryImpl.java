package com.kuhn.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kuhn.entity.Customer;

@Repository
public class MemoryCustumerRepositoryImpl implements CustomerRepository {

	private List<Customer> customers;
	
	public MemoryCustumerRepositoryImpl() {
		customers = Arrays.asList(
				new Customer("Clayton Kuhn", "claytonedk@gmail.com"),
				new Customer("Ana Zattar", "ana_zattar@hotmail.com")
		);
	}

	public List<Customer> getAll() {
		return customers;
	}

}
