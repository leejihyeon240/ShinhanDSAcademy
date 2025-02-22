package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestBookServiceTests {
    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user0")
                .build();
        System.out.println(service.register(guestbookDTO));
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(15).size(10).build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV:"+resultDTO.isPrev());
        System.out.println("NEXT:"+resultDTO.isNext());
        System.out.println("TOTAL:"+resultDTO.getTotalPage());

        for (GuestbookDTO dto : resultDTO.getDtoList()) {
            System.out.println(dto);
        }

        System.out.println("===================================");

        resultDTO.getPageList().forEach(System.out::println);
    }

    @Test
    public void testSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).type("tc").keyword("1").build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV:"+resultDTO.isPrev());
        System.out.println("NEXT:"+resultDTO.isNext());
        System.out.println("TOTAL:"+resultDTO.getTotalPage());
        System.out.println("------------------------------------------");
        for (GuestbookDTO dto : resultDTO.getDtoList()) {
            System.out.println(dto);
        }
        System.out.println("===========================================");
        resultDTO.getPageList().forEach(System.out::println);
    }
}
