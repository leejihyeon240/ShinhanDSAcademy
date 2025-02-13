package org.zerock.guestbook.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.entity.QGuestbook;
import org.zerock.guestbook.repository.GuestbookRepository;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO--------------------");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);
        log.info(entity);

        guestbookRepository.save(entity);

        return entity.getGno();
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        // 재사용하기 위해 만든 메서드 사용 Sort -> page-1, size, Sort -> Pageable객체로 리턴
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<Guestbook> result = guestbookRepository.findAll(booleanBuilder, pageable);

        // 익명구현객체(람다 표현식) 정의
        //Function<Guestbook, GuestbookDTO> fn = entity -> entityToDto(entity);
//        Function<Guestbook, GuestbookDTO> fn = new Function<Guestbook, GuestbookDTO>() {
//            @Override
//            public GuestbookDTO apply(Guestbook guestbook) {
//                return entityToDto(guestbook);
//            }
//        };
        return new PageResultDTO<>(result, entity -> entityToDto(entity));
    }

    @Override
    public GuestbookDTO read(Long gno) {
        Optional<Guestbook> result = guestbookRepository.findById(gno);
        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public void remove(Long gno) {
        guestbookRepository.deleteById(gno);
    }

    @Override
    public void modify(GuestbookDTO dto) {
        Optional<Guestbook> result = guestbookRepository.findById(dto.getGno());
        if (result.isPresent()) {
            Guestbook guestbook = result.get();
            guestbook.changeTitle(dto.getTitle());
            guestbook.changeContent(dto.getContent());
            guestbookRepository.save(guestbook);
        }
    }

    // 사용자가 요청한 검색(type, keyword)에 따른 검색조건(booleanbuilder 객체) 리턴
    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QGuestbook qGuestbook = QGuestbook.guestbook;
        String keyword = requestDTO.getKeyword();

        BooleanExpression expression = qGuestbook.gno.gt(0L);
        booleanBuilder.and(expression);
        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("t")) {
            conditionBuilder.or(qGuestbook.title.contains(keyword));
        }
        if (type.contains("c")) {
            conditionBuilder.or(qGuestbook.content.contains(keyword));
        }
        if (type.contains("w")) {
            conditionBuilder.or(qGuestbook.writer.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder); // gno > 0 and (제목/내용/작성자 검색)
        return booleanBuilder;
    }
}
