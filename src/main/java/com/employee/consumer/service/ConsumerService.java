/**
 * 
 */
package com.employee.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.consumer.bean.EmployeeBean;
import com.employee.consumer.client.ConsumerClient;

/**
 * @author Abhi
 *
 */
@Service
public class ConsumerService {

	@Autowired
	private ConsumerClient client;
	
	public List<EmployeeBean> getEmployeeDataService(){
		return client.callEmployeeBasicData();
	}
}
