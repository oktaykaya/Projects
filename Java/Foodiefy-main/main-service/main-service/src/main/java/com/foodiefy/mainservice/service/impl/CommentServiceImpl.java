package com.foodiefy.mainservice.service.impl;

import com.foodiefy.mainservice.dto.CommentDto;
import com.foodiefy.mainservice.dto.RecipeDto;
import com.foodiefy.mainservice.dto.UserDto;
import com.foodiefy.mainservice.model.Comment;
import com.foodiefy.mainservice.model.Recipe;
import com.foodiefy.mainservice.model.User;
import com.foodiefy.mainservice.repository.CommentRepository;
import com.foodiefy.mainservice.service.CommentService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;


    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;

    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentDtos = new ArrayList<>();

        comments.forEach(comment -> {
            CommentDto commentDto = CommentDto.builder()
                    .comment(comment.getComment())
                    .recipe(mapRecipeToDto(comment.getRecipe()))
                    .user(mapUserToDto(comment.getUser()))
                    .build();
            commentDtos.add(commentDto);
        });

        return commentDtos;
    }

    @Override
    public CommentDto getCommentById(long id) {
        Comment comment = commentRepository.findById(id).orElse(null);

        if (comment == null) {
            throw new RuntimeException("Comment not found with id: " + id);
        }

        return CommentDto.builder()
                .comment(comment.getComment())
                .recipe(mapRecipeToDto(comment.getRecipe()))
                .user(mapUserToDto(comment.getUser()))
                .build();
    }

    @Override
    public String addComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setRecipe(mapDtoToRecipe(commentDto.getRecipe()));
        comment.setUser(mapDtoToUser(commentDto.getUser()));

        commentRepository.save(comment);

        return "Comment added successfully!";
    }

    @Override
    public String updateComment(CommentDto commentDto, long id) {
        Comment existingComment = commentRepository.findById(id).orElse(null);

        if (existingComment == null) {
            throw new RuntimeException("Comment not found with id: " + id);
        }

        existingComment.setComment(commentDto.getComment());
        existingComment.setRecipe(mapDtoToRecipe(commentDto.getRecipe()));
        existingComment.setUser(mapDtoToUser(commentDto.getUser()));

        commentRepository.save(existingComment);

        return "Comment updated successfully!";
    }

    @Override
    public String deleteComment(long id) {
        Comment comment = commentRepository.findById(id).orElse(null);

        if (comment == null) {
            throw new RuntimeException("Comment not found with id: " + id);
        }

        commentRepository.delete(comment);

        return "Comment deleted successfully!";
    }

    private RecipeDto mapRecipeToDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        BeanUtils.copyProperties(recipe, recipeDto);
        return recipeDto;
    }

    private UserDto mapUserToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    private Recipe mapDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        BeanUtils.copyProperties(recipeDto, recipe);
        return recipe;
    }

    private User mapDtoToUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}

