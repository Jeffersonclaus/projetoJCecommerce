package com.jc.Ecommerce.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jc.Ecommerce.dto.ProductDTO;
import com.jc.Ecommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		ProductDTO dto = service.findById(id);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
			
	}
		
	
     
	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAll1(Pageable page) {
	 
		Page<ProductDTO> dto =  service.findall(page);		
		
		return ResponseEntity.ok(dto);
		
	}
     

	@PutMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO productDTO) {
	 
		productDTO = service.insert(productDTO);	
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(productDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(productDTO);
		
	}
     
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update( @PathVariable Long id,@RequestBody ProductDTO productDTO ) {
	 
		productDTO = service.update(id,productDTO);
		return ResponseEntity.ok(productDTO);		
		
	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build(); // quando não tem corpo
			
	}
	
	
	
}	
