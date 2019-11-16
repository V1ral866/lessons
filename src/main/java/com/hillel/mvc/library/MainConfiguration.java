package com.hillel.mvc.library;

import com.hillel.mvc.library.model.BookEntity;
import com.hillel.mvc.library.model.BookStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class MainConfiguration {

    @Bean
    public Map<Integer, BookEntity> initBooks() {
        ConcurrentHashMap<Integer, BookEntity> map = new ConcurrentHashMap<>();
        map.put(1, new BookEntity(1, "Test1", "Author1", "User1", BookStatus.AVAILABLE));
        map.put(2, new BookEntity(1, "Test2", "Author2", "User2", BookStatus.AVAILABLE));
        return map;
    }
}
