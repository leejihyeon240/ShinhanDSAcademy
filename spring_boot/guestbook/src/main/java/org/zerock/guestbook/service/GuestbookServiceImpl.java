package org.zerock.guestbook.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.repository.GuestbookRepository;

import java.util.function.Function;

@Service
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{

    private final GuestbookRepository guestbookRepository;

    public GuestbookServiceImpl(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO--------------------");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        return null;
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno"));
        Page<Guestbook> result = guestbookRepository.findAll(pageable);

        Function<Guestbook, GuestbookDTO> fn = entity -> entityToDto(entity);
        return new PageResultDTO<>(result, fn);
    }
}
