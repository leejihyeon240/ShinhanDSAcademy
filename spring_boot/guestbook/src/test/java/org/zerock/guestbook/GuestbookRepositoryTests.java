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

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1,300).forEach(i-> {
            Guestbook guestbook = Guestbook.builder()
                    .title("Title..."+i)
                    .content("Content..."+i)
                    .writer("user"+(i%10))
                    .build();
            System.out.println(repo.save(guestbook));
        });
    }

    @Test
    public void updateTest() {
        Optional<Guestbook> result = repo.findById(300L);
        if (result.isPresent()) {
            Guestbook guestbook = result.get();
            guestbook.changeTitle("Changed Title...");
            guestbook.changeContent("Changed Content...");
            repo.save(guestbook);
        }
    }

    @Test
    public void testQuery1() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno"));

        QGuestbook qGuestbook = QGuestbook.guestbook; // Q도메인객체
        String keyword = "1"; // 사용자가 입력한 검색어

        BooleanBuilder builder = new BooleanBuilder(); // 불리언빌더객체 생성
        BooleanExpression expression = qGuestbook.title.contains(keyword); // 표현식
        builder.and(expression); // 표현식을 and
        Page<Guestbook> result = repo.findAll(builder, pageable); // 빌더를 적용

        result.stream().forEach(System.out::println);

    }

    @Test
    public void testQuery2() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

        QGuestbook qGuestbook = QGuestbook.guestbook;
        String keyword = "1"; // 검색어 -> 제목 또는 내용에 포함되는
        BooleanBuilder builder = new BooleanBuilder();
        // 검색조건 시작
        // =============================================================================
        BooleanExpression exTitle = qGuestbook.title.contains(keyword); // 제목에서 검색
        BooleanExpression exContent = qGuestbook.content.contains(keyword); // 내용에서 검색
        BooleanExpression exAll = exTitle.or(exContent); // 제목검색 or 내용검색

        builder.and(exAll); // and (제목검색 or 내용검색)
//        BooleanExpression exGno = qGuestbook.gno.gt(0L);
//        builder.and(exGno);
        builder.and(qGuestbook.gno.gt(0L)); // and gno > 0
        // =================================================================================
        // 검색조건 끝
        Page<Guestbook> result = repo.findAll(builder, pageable);
        result.stream().forEach(System.out::println);
    }
}
