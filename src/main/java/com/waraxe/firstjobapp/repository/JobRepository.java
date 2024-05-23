package com.waraxe.firstjobapp.repository;

import com.waraxe.firstjobapp.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs, Long> {

}