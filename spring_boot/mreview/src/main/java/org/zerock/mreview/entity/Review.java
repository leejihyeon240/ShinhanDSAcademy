package org.zerock.mreview.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude={"movie", "member"})
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_num;

    @ManyToOne(fetch=FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch=FetchType.LAZY)
    private Member member;

    private int grade;
    private String text;
}
