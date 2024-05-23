package com.waraxe.firstjobapp.controllers;

import com.waraxe.firstjobapp.models.Jobs;
import com.waraxe.firstjobapp.repository.JobServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobServices jobServices;
    private List<Jobs> jobs = new ArrayList<>();

    public JobController(JobServices jobServices) {
        this.jobServices = jobServices;
    }

    @GetMapping
    public ResponseEntity<List<Jobs>> findAll() {
        return ResponseEntity.ok(jobServices.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Jobs job) {
        jobServices.createJob(job);
        //return new ResponseEntity<>("Job Added Successfully!",HttpStatus.OK);  This Works too
        return ResponseEntity.ok("Job Added Successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jobs> getJobById(@PathVariable Long id) {
        Jobs j = jobServices.getJobById(id);
        if (j != null) {
            return ResponseEntity.ok(j);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean delete = jobServices.deleteJobById(id);
        if (delete) {
            return ResponseEntity.ok("Job Deleted Successfully!");
        }
        return new ResponseEntity<>("Job Not Found!", HttpStatus.NOT_FOUND);
    }

    //@RequestMapping(value="/jobs/{id}", method=RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Jobs updatedJob) {
        boolean updated = jobServices.updateJobById(id, updatedJob);
        if (updated) {
            return ResponseEntity.ok("Job with Job ID: " + id + " updated successfully!");
        }
        return new ResponseEntity<>("Job Not Found!", HttpStatus.NOT_FOUND);
    }
}