package com.waraxe.firstjobapp.repository;

import com.waraxe.firstjobapp.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
