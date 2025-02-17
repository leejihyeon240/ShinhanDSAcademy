package org.zerock.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;
import org.zerock.board.entity.Reply;
import org.zerock.board.repository.search.SearchBoardRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository {
    @Query("select b, w from Board b left join b.writer w where b.bno =:bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    // 연관관계가 없는
    @Query("select b, r from Board b left join Reply r on r.board = b where b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    // Board를 기준으로 Member(이름, 이메일), Reply의 개수
    @Query(value = """
select b, w, count(r) from Board b 
left join b.writer w 
left join Reply r on r.board = b 
group by b 
""", countQuery = "select count(b) from Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);

    // 조회화면에서 게시글정보랑, 회원정보, 댓글개수
    @Query("""
select b, w, count(r) 
from Board b left join b.writer w
left outer join Reply r on r.board = b
where b.bno = :bno
""")
    Object getBoardByBno(@Param("bno") Long bno);
}