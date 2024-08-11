package com.fmgarcia.cetus.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmgarcia.cetus.core.domain.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
