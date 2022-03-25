package com.example.anonymousposting.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100000)
    private String postText;

    @Column(nullable = false)
    private String title;

    private String date;

    private Integer reaction = 0;

    @ManyToOne
    private Member member;

    @Column
    private Integer numberComment = 0;

    private String imageName;
}
