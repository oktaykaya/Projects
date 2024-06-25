package com.foodiefy.mainservice.service;

import com.foodiefy.mainservice.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllComments();

    CommentDto getCommentById(long id);

    String addComment(CommentDto commentDto);

    String updateComment(CommentDto commentDto, long id);

    String deleteComment(long id);
}
