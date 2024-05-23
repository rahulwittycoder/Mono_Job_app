package com.waraxe.firstjobapp.service;

import com.waraxe.firstjobapp.models.Company;
import com.waraxe.firstjobapp.models.Jobs;
import com.waraxe.firstjobapp.repository.CompanyRepository;
import com.waraxe.firstjobapp.repository.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplemented implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplemented(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent())
        {
            Company c = companyOptional.get();
            c.setDescription(company.getDescription());
            c.setName(company.getName());
            companyRepository.save(c);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
