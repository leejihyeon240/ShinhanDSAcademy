package org.zerock.mreview.service;

import org.zerock.mreview.dto.ReviewDTO;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getListOfMovie(Long mno);
    Long register(ReviewDTO dto);
    void modify(ReviewDTO dto);
    void remove(Long reviewnum);

    default Review dtoToEntity(ReviewDTO movieReviewDTO) {
        Review review = Review.builder()
                .review_num(movieReviewDTO.getReviewnum())
                .movie(Movie.builder().mno(movieReviewDTO.getMno()).build())
                .member(Member.builder().mid(movieReviewDTO.getMid()).build())
                .grade(movieReviewDTO.getGrade())
                .text(movieReviewDTO.getText())
                .build();
        return review;
    }

    default ReviewDTO entityToDto(Review review) {
        ReviewDTO movieReviewDTO = ReviewDTO.builder()
                .reviewnum(review.getReview_num())
                .mno(review.getMovie().getMno())
                .mid(review.getMember().getMid())
                .nickname(review.getMember().getNickname())
                .email(review.getMember().getEmail())
                .grade(review.getGrade())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();
        return movieReviewDTO;
    }
}
