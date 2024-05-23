package com.waraxe.firstjobapp.service;

import com.waraxe.firstjobapp.models.Jobs;
import com.waraxe.firstjobapp.repository.JobRepository;
import com.waraxe.firstjobapp.repository.JobServices;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobServicesImplemented implements JobServices {
    //private List<Jobs> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServicesImplemented(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Jobs> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Jobs job) {
        jobRepository.save(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Jobs updatedJob) {
        Optional<Jobs> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent())
        {
            Jobs j = jobOptional.get();
            j.setTitle(updatedJob.getTitle());
            j.setDescription(updatedJob.getDescription());
            j.setLocation(updatedJob.getLocation());
            j.setMinSalary(updatedJob.getMinSalary());
            j.setMaxSalary(updatedJob.getMaxSalary());
            jobRepository.save(j);
            return true;
        }
        return false;
    }

    @Override
    public Jobs getJobById(Long id)
    {
        return jobRepository.findById(id).orElse(null);
    }
}
