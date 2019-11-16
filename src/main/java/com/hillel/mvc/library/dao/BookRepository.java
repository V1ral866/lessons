package com.hillel.mvc.library.dao;

import com.hillel.mvc.library.model.BookEntity;

import java.util.List;

public interface BookRepository {

    List<BookEntity> getBooksList();

    BookEntity getBookEntity(int id);

    void save(BookEntity bookEntity);

    void delete(int id);
}
