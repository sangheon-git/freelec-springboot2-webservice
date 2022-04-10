package com.sangheon.book.springboot.service;


import com.sangheon.book.springboot.domain.posts.Posts;
import com.sangheon.book.springboot.domain.posts.PostsRepository;
import com.sangheon.book.springboot.web.dto.PostsResponseDto;
import com.sangheon.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        // return PostsRepository.save(requestDto.toEntity()).getId();
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

}
