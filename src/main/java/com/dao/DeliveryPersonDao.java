package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.DeliveryPerson;

@Repository
public interface DeliveryPersonDao extends JpaRepository<DeliveryPerson, Integer> {

}
