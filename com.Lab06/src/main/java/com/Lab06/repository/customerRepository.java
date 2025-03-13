package com.Lab06.repository;

import com.Lab06.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customer, Long> {
}
