package com.foodiefy.mainservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="comment")
    private String comment;

    @OneToOne
    @JoinColumn(name="recipe_id", nullable = false)
    private Recipe recipe;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
}
