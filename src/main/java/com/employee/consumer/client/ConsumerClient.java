/**
 * 
 */
package com.employee.consumer.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.consumer.bean.EmployeeBean;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Abhi
 *
 */
@Component
public class ConsumerClient {
	
	private RestTemplate restTemplate;
	private ObjectMapper mapper;
	
	public List<EmployeeBean> callEmployeeBasicData(){
		restTemplate= new RestTemplate();
		List<EmployeeBean> empList=null;
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> json=restTemplate.getForObject("http://localhost:8081/emp/basic/data/getAllEmployees", List.class);
		mapper= new ObjectMapper();
		empList= json.stream().map(t->{
			EmployeeBean bean=mapper.convertValue(t, EmployeeBean.class);
			return bean;
		}).collect(Collectors.toList());
		return empList;
	}

}
