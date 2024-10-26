package com.crio.starter.service;

import java.util.List;
import java.util.Map;
import com.crio.starter.dto.PostDto;
import com.crio.starter.exceptions.InvalidPostException;
import com.crio.starter.exceptions.PostNotFoundException;

public interface MemeService {
    List<PostDto> getPosts();

    PostDto getPost(long postId) throws PostNotFoundException;

    long savePost(PostDto post) throws InvalidPostException;

    void updatePost(Map<String, Object> updates, long postId) throws PostNotFoundException, InvalidPostException;
}
