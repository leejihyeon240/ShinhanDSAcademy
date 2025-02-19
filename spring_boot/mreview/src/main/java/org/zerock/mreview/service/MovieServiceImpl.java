package org.zerock.mreview.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mreview.dto.MovieDTO;
import org.zerock.mreview.dto.PageRequestDTO;
import org.zerock.mreview.dto.PageResultDTO;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.MovieImage;
import org.zerock.mreview.repository.MovieImageRepository;
import org.zerock.mreview.repository.MovieRepository;
import org.zerock.mreview.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;
    private final MovieImageRepository imageRepository;

    @Transactional
    @Override
    public Long register(MovieDTO movieDTO) {
        Map<String, Object> entityMap = dtoToEntity(movieDTO); // dto->entity
        Movie movie = (Movie)entityMap.get("movie"); // Movie엔티티
        List<MovieImage> movieImageList = (List<MovieImage>)entityMap.get("imageList"); // MovieImage(리스트)엔티티
        movieRepository.save(movie); // Movie엔티티 저장
        // MovieImage엔티티는 개수만큼 저장
        movieImageList.forEach(movieImage->{
            imageRepository.save(movieImage);
        });

        return movie.getMno();
    }

    @Override
    public PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("mno").descending());
        Page<Object[]> result = movieRepository.getListPage(pageable);

        Function<Object[], MovieDTO> fn = (arr -> entitiesToDTO(
                (Movie)arr[0],
                (List<MovieImage>)(Arrays.asList((MovieImage)arr[1])),
                (Double) arr[2],
                (Long)arr[3])
        );
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public MovieDTO getMovie(Long mno) {
        List<Object[]> result = movieRepository.getMovieWithAll(mno);
        Movie movie = (Movie)result.get(0)[0]; // Movie 엔티티
        List<MovieImage> movieImageList = new ArrayList<>(); // 영화이미지를 담을 리스트
        // result(리스트)의 1번인덱스(MovieImage엔티티)를 movieImageList에 추가
        result.forEach(arr -> {
            MovieImage movieImage = (MovieImage)arr[1];
            movieImageList.add(movieImage);
        });
        Double avg = (Double)result.get(0)[2]; // 평균평점
        Long reviewCnt = (Long)result.get(0)[3]; // 개수
        return entitiesToDTO(movie, movieImageList, avg, reviewCnt); // DTO로 변환
    }
}
