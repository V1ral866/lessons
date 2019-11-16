package com.hillel.mvc.library.dao;

import com.hillel.mvc.library.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @Autowired
    @Qualifier("initBooks")
    private Map<Integer, BookEntity> booksMap;

    @Override
    public List<BookEntity> getBooksList() {
        return new ArrayList<>(booksMap.values());
    }

    @Override
    public BookEntity getBookEntity(int id) {
        return booksMap.get(id);
    }

    @Override
    public void save(BookEntity bookEntity) {
        booksMap.put(bookEntity.getBookId(), bookEntity);
    }

    @Override
    public void delete(int id) {
        booksMap.remove(id);
    }
}
