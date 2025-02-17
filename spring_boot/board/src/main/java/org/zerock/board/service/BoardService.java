package org.zerock.board.service;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

public interface BoardService {
    // 글등록
    Long register(BoardDTO dto);
    // 목록
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
    // 상세
    BoardDTO get(Long bno);
    // 삭제
    void removeWithReplies(Long bno);
    // 수정
    void modify(BoardDTO dto);

    // dto -> entity 변환
    // 사용자가 글등록 -> 데이터 -> "dto -> entity" -> jpa(save)
    default Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder().email(dto.getWriterEmail()).build();
        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }

    // entity(Object[]) -> DTO
    default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();
        return boardDTO;
    }
}
