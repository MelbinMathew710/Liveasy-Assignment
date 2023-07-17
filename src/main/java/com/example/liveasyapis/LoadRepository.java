package com.example.liveasyapis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadRepository extends JpaRepository<PayLoad, Integer>{

    List<PayLoad> findByShipperId(String shipperId);
}
