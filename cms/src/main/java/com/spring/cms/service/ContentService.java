package com.spring.cms.service;

import com.spring.cms.dto.ContentRequest;
import com.spring.cms.dto.ContentResponse;
import com.spring.cms.global.MessageResponse;

import java.util.List;

public interface ContentService {

    ContentResponse addContent(ContentRequest contentRequest);

    ContentResponse editContent(Long id, ContentRequest contentRequest);

    List<ContentResponse> getAllContents();

    ContentResponse getContentById(Long id);

    MessageResponse deleteContentById(Long id);


}
