package com.javaproject.JobApplication.service;

import com.javaproject.JobApplication.modal.Company;
import com.javaproject.JobApplication.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Company company, Long id) {
        Optional<Company> existingCompanyOptional  = companyRepository.findById(id);
        if(existingCompanyOptional.isPresent()){
            Company ext_company = existingCompanyOptional.get();
            modelMapper.getConfiguration().setSkipNullEnabled(true);
//            ext_company.setName(company.getName());
//            ext_company.setDescription(company.getDescription());
//            ext_company.setJobs(company.getJobs());
            modelMapper.map(company,ext_company);
            companyRepository.save(ext_company);
            return ext_company;
        }

        return null;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            if(!companyRepository.existsById(id)){
                return false;
            }
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println("e :: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(!optionalCompany.isPresent()){
            return null;
        }

        return optionalCompany.get();
    }
}
