package com.hcl.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.hackathon.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
