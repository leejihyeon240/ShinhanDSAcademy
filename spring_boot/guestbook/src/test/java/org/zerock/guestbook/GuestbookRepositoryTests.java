package org.zerock.guestbook;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.entity.QGuestbook;
import org.zerock.guestbook.repository.GuestbookRepository;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {
    @Autowired
    private GuestbookRepository repo;
    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            Guestbook gb = Guestbook.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .writer("user" + (i % 10))
                    .build();
            System.out.println(guestbookRepository.save(gb));
        });
    }

    @Test
    public void updateTest() {
        Optional<Guestbook> result = guestbookRepository.findById(300L);

        if(result.isPresent()) {
            Guestbook gb = result.get();

            gb.changeTitle("Change Title...");
            gb.changeContent("Change Content...");

            guestbookRepository.save(gb);
        }
    }

    @Test
    public void TestQuery1() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

        QGuestbook qGuestbook = QGuestbook.guestbook; // Q도메인 객체

        String keyword = "1"; // 사용자가 입력한 검색어

        BooleanBuilder builder = new BooleanBuilder(); // 불리언빌더객체 생성
        BooleanExpression expression = qGuestbook.title.contains(keyword); // 표현식

        builder.and(expression); // 표현식을 and

        Page<Guestbook> result = guestbookRepository.findAll(builder, pageable); // 빌더를 적요

        result.stream().forEach(guestbook -> {
            System.out.println(guestbook);
        });

    }

    @Test
    public void TestQuery2() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

        QGuestbook qGuestbook = QGuestbook.guestbook; // Q도메인 객체

        String keyword = "1"; // 사용자가 입력한 검색어

        BooleanBuilder builder = new BooleanBuilder(); // 불리언빌더객체 생성
        BooleanExpression exTitle = qGuestbook.title.contains(keyword); // 제목에서 검색
        BooleanExpression exContent = qGuestbook.content.contains(keyword); // 내용에서 검색
        BooleanExpression exAll = exTitle.or(exContent); // 제목 검색 or 내용 검색

        builder.and(exAll); // and(제목 검색 or 내용 검색)
        builder.and(qGuestbook.gno.gt(0L));

        Page<Guestbook> result = guestbookRepository.findAll(builder, pageable);

        result.stream().forEach(guestbook -> {
            System.out.println(guestbook);
        });
    }
}
