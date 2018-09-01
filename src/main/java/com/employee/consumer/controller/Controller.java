/**
 * 
 */
package com.employee.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.consumer.bean.EmployeeBean;
import com.employee.consumer.service.ConsumerService;

/**
 * @author Abhi
 *
 */
@RestController
public class Controller {

	@Autowired
	private ConsumerService service;
	
	@RequestMapping(value="consumer/getEmployeeData", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeBean>> getEmployeeData(){
		List<EmployeeBean> list=service.getEmployeeDataService();
		return new ResponseEntity<List<EmployeeBean>>(list, HttpStatus.OK);
	}
}
