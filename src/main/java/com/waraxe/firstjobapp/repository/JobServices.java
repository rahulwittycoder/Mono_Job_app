package com.waraxe.firstjobapp.repository;

import com.waraxe.firstjobapp.models.Jobs;

import java.util.List;

public interface JobServices {
    Jobs getJobById(Long id);
    List<Jobs> findAll();
    void createJob(Jobs job);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Jobs updatedJob);
}
