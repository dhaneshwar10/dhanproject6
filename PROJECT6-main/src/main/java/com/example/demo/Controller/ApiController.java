package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.ApiService;

import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;

@RestController
public class ApiController {
	@Autowired
	ChildRepo serviceRepository;
	@Autowired
	ApiService service;
	
	@PostMapping("/")
	   public Child create(@RequestBody Child chi)
	   {
		return serviceRepository.save(chi);
	   }
	
	
	@GetMapping("{field}")
	public List<Child> studentSortList(@PathVariable String field)
	{
		return service.getSort(field);
	}
	
	@GetMapping("/{offset}/{pageSize}")
	public List<Child>childtWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		return service.setPages(offset,pageSize);
	}
	@GetMapping("/{offset}/{pageSize}/{field}")
	public List<Child>childtWithPagination(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return service.setPages(offset,pageSize,field);
	}
	@GetMapping("/sortandpage/{offset}/{pageno}/{field}")
	public Page<Child> sortPagination(@PathVariable int offset,@PathVariable int pageno,@PathVariable String field)
	{
		return service.dosortandPage(offset,pageno,field);
	}
}