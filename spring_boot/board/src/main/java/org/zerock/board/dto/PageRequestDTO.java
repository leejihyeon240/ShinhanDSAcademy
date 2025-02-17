package org.zerock.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    private int page; // 페이지 번호
    private int size; // 페이지당 개수(예: 1페이지에 10개)
    private String type; // 검색종류
    private String keyword; // 검색어

    // 생성자 - 초기화
    public PageRequestDTO() {
        this.page = 1; // 1페이지
        this.size = 10; // 1페이지당 10개
    }
    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page-1, size, sort); // 페이지번호가 0부터시작
    }
}
