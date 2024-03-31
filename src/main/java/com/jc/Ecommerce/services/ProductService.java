package com.jc.Ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jc.Ecommerce.dto.ProductDTO;
import com.jc.Ecommerce.entity.Product;
import com.jc.Ecommerce.repositories.ProductRepository;
import com.jc.Ecommerce.services.exeption.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {

		Product product = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

		ProductDTO dto = new ProductDTO(product);
		return dto;

	}

	@Transactional(readOnly = true)
	public Page<ProductDTO> findall(Pageable page) {

		Page<Product> products = repository.findAll(page);

		return products.map(x -> new ProductDTO(x));

	}

	@Transactional
	public ProductDTO insert(ProductDTO productDTO) {

		Product produtc = new Product();

		produtc.setName(productDTO.getName());
		produtc.setPrice(productDTO.getPrice());
		produtc.setImgUrl(productDTO.getImgUrl());
		produtc.setDescription(productDTO.getDescription());

		produtc = repository.save(produtc);

		return new ProductDTO(produtc);
	}

	@Transactional
	public ProductDTO update(Long productId, ProductDTO ProductDTO) {

		Product produtc = new Product();

		produtc = repository.getById(productId);
		produtc.setName(ProductDTO.getName());
		produtc.setPrice(ProductDTO.getPrice());
		produtc.setImgUrl(ProductDTO.getImgUrl());
		produtc.setDescription(ProductDTO.getDescription());

		produtc = repository.save(produtc);

		return new ProductDTO(produtc);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {

		if(!repository.existsById(id))
			 throw new ResourceNotFoundException("Recurso não encontrado");
		
		try {
			
			
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Falha na integridade referencial");
		}

	}

}
