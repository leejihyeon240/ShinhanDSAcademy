package org.zerock.mreview.service;

import org.zerock.mreview.dto.MovieDTO;
import org.zerock.mreview.dto.MovieImageDTO;
import org.zerock.mreview.dto.PageRequestDTO;
import org.zerock.mreview.dto.PageResultDTO;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.MovieImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface MovieService {
    Long register(MovieDTO movieDTO);
    PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO);
    MovieDTO getMovie(Long mno);

    default Map<String, Object> dtoToEntity(MovieDTO movieDTO) {
        // 리턴할 map 객체
        Map<String, Object> map = new HashMap<String, Object>();
        // Movie 엔티티객체(사용자가 전송한 값저장) 생성
        Movie movie = Movie.builder()
                .mno(movieDTO.getMno())
                .title(movieDTO.getTitle())
                .build();
        map.put("movie", movie); // 맵에 저장
        // 이미지목록
        List<MovieImageDTO> imageDTOList = movieDTO.getImageDTOList();
        // 이미지가 있으면
        if (imageDTOList != null && imageDTOList.size() > 0) {
            // 이미지리스트의 DTO를 MovieImage 엔티티로 변환해서 리스트로 변환
            List<MovieImage> movieImageList = imageDTOList.stream().map(dto->{
                MovieImage movieImage = MovieImage.builder()
                        .path(dto.getPath())
                        .imgName(dto.getImgName())
                        .uuid(dto.getUuid())
                        .movie(movie)
                        .build();
                return movieImage;
            }).collect(Collectors.toList());
            map.put("imageList", movieImageList); // 맵에 저장
        }
        return map; // Movie엔티티랑, MovieImage(리스트)엔티티
    }

    // 엔티티 -> DTO
    default MovieDTO entitiesToDTO(Movie movie, List<MovieImage> movieImages, Double avg, Long reviewCnt) {
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movie.getMno())
                .title(movie.getTitle())
                .regDate(movie.getRegDate())
                .modDate(movie.getModDate())
                .build();
        List<MovieImageDTO> movieImageDTOList = movieImages.stream().map(img->{
            System.out.println(img);
            return MovieImageDTO.builder()
                    .imgName(img.getImgName())
                    .path(img.getPath())
                    .uuid(img.getUuid())
                    .build();
        }).collect(Collectors.toList());
        movieDTO.setImageDTOList(movieImageDTOList);
        movieDTO.setAvg(avg);
        movieDTO.setReviewCnt(reviewCnt.intValue());
        return movieDTO;
    }
}
