package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Advance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdvanceRepository extends JpaRepository<Advance, Long> {
}
