package com.spring.cms.service;

import com.spring.cms.dto.ContentRequest;
import com.spring.cms.dto.ContentResponse;
import com.spring.cms.entity.Content;
import com.spring.cms.global.MessageResponse;
import com.spring.cms.repository.ContentRepository;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService{

    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public ContentResponse addContent(ContentRequest contentRequest) {
        return toResponse(contentRepository.save(toEntity(contentRequest)));
    }

    @Override
    public ContentResponse editContent(Long id, ContentRequest contentRequest) {
        Content existingContent = contentRepository.findById(id).orElseThrow(()-> new RuntimeException("Content not found"));
        return toResponse(contentRepository.save(toUpdateEntity(existingContent, contentRequest)));
    }

    @Override
    public List<ContentResponse> getAllContents() {
        return contentRepository.findAll()
                .stream()
                .map(this:: toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ContentResponse getContentById(Long id) {
        Content existingContent = contentRepository.findById(id).orElseThrow(()-> new RuntimeException("Content not found"));
        return toResponse(existingContent);

    }

    @Override
    public MessageResponse deleteContentById(Long id) {
        Content existingContent = contentRepository.findById(id).orElseThrow(()-> new RuntimeException("Content not found"));
        contentRepository.deleteById(id);
        return MessageResponse.builder().message("Content deleted successfully").build();
    }

    private Content toEntity(ContentRequest contentRequest){
       if(contentRequest!=null) {
           Content content = new Content();
           content.setTitle(contentRequest.getTitle());
           content.setBody(contentRequest.getBody());
           return content;
       }
       return null;
    }
    private Content toUpdateEntity(Content content, ContentRequest contentRequest){
        if(contentRequest.getTitle()!=null){
            content.setTitle(contentRequest.getTitle());
        }
        if(contentRequest.getBody()!=null){
            content.setBody(contentRequest.getBody());
        }
        return content;
    }

    private ContentResponse toResponse(Content content){
        return ContentResponse.builder()
                .id(content.getId())
                .title(content.getTitle())
                .body(content.getBody())
                .build();
    }

}
