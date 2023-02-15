package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Allowance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAllowanceRepository extends JpaRepository<Allowance, Long> {
}
