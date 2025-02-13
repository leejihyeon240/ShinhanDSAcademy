package org.zerock.guestbook.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtoList; // 리스트<GuestbookDTO> 타입 필드

    private int totalPage; // 총페이지 수
    private int page; // 현재 페이지
    private int size; // 페이지당개수
    private int start, end; // 시작번호, 끝번호
    private boolean prev, next; // 이전페이지, 다음페이지 여부
    private List<Integer> pageList; // 페이지번호들이 담긴 리스트


    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
        // result(JPA에서 조회한 결과 객체)의 map(람다식) -> 리스트로변화 리턴
        dtoList = result.stream().map(fn).collect(Collectors.toList());

        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {
        this.page = pageable.getPageNumber() + 1;
        this.size = pageable.getPageSize();

        int tempEnd = (int)(Math.ceil(page/10.0)) * 10;
        start = tempEnd -9;
        prev = start > 1;
        end = totalPage > tempEnd ? tempEnd : totalPage;
        next = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
