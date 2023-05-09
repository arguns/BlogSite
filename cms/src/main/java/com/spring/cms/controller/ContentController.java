package com.spring.cms.controller;

import com.spring.cms.dto.ContentRequest;
import com.spring.cms.dto.ContentResponse;
import com.spring.cms.global.MessageResponse;
import com.spring.cms.service.ContentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/cms")
@EnableWebMvc
public class ContentController {

    private final ContentService contentService;
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }
    @PostMapping
    ContentResponse addContent(@RequestBody ContentRequest contentRequest){
        return contentService.addContent(contentRequest);
    }

    @PutMapping("/edit/{id}")
    ContentResponse editContent(@PathVariable(value = "id") Long id, @RequestBody ContentRequest contentRequest){
        return contentService.editContent(id, contentRequest);
    }
    @GetMapping
    List<ContentResponse> getAllContents(){
        return contentService.getAllContents();
    }

    @GetMapping("/{id}")
    ContentResponse getContentById(@PathVariable(value = "id") Long id){
        return contentService.getContentById(id);
    }

    @DeleteMapping("/delete/{id}")
    MessageResponse deleteContentById(@PathVariable(value = "id") Long id){
        return contentService.deleteContentById(id);
    }


}
