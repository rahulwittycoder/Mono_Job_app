package com.waraxe.firstjobapp.controllers;

import com.waraxe.firstjobapp.models.Review;
import com.waraxe.firstjobapp.repository.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService)
    {
        this.reviewService=reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review)
    {
        reviewService.addReview(companyId, review);
        return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewid}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review)
    {
        return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        boolean isReviewDeleted = reviewService.deleteReview(companyId,reviewId);
        if(isReviewDeleted)
        {
            return new ResponseEntity<>("Review Deleted Successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Deleted", HttpStatus.NOT_FOUND);
    }
}
