package com.testP.async.handler;

import com.testP.async.EventHandler;
import com.testP.async.EventModel;
import com.testP.async.EventType;
import com.testP.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AddQuestionHandler implements EventHandler {
    @Autowired
    SearchService searchService;
    private static final Logger logger = LoggerFactory.getLogger(AddQuestionHandler.class);

    @Override
    public void doHandle(EventModel model) {
        try{
            searchService.indexQuestion(model.getEntityId(),model.getExt("content"),model.getExt("title"));

        }catch (Exception e){
            logger.error("问题建立索引失败");
           e.printStackTrace();
        }
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.ADDQUESTION);
    }
}

