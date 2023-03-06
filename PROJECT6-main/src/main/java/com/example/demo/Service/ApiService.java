package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;

@Service
public class ApiService {
	@Autowired
	ChildRepo repository;
	public Optional<Child>getChild(int babyId){
		return repository.findById(babyId);
	}
	public List<Child> getSort(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	public List<Child>setPages(@PathVariable int offset,@PathVariable int pageSize)
	{
		Page<Child>page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	
	public List<Child>setPages(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		Page<Child>page=repository.findAll(PageRequest.of(offset,pageSize,Sort.Direction.ASC,field));
		return page.getContent();
	}
	public Page<Child> dosortandPage (int offset,int pageSize,String field){
		Pageable pageable=PageRequest.of(offset,pageSize,Sort.by(Direction.DESC,field));
		return repository.findAll(pageable);
	}
}