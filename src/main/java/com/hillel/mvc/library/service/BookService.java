package com.hillel.mvc.library.service;

import com.hillel.mvc.library.dao.BookRepository;
import com.hillel.mvc.library.model.BookEntity;
import com.hillel.mvc.library.model.BookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getBooks() {
        return bookRepository.getBooksList();
    }

    public void saveBook(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public BookEntity getBook(int id) {
        return bookRepository.getBookEntity(id);
    }

    public void takeBook(int bookId, String holder) {
        BookEntity bookEntityFromDB = bookRepository.getBookEntity(bookId);
        if (bookEntityFromDB.getBookStatus().equals(BookStatus.AVAILABLE)) {
            bookEntityFromDB.setBookStatus(BookStatus.TAKEN);
            bookEntityFromDB.setBookHolder(holder);
        } else {
            bookEntityFromDB.setBookStatus(BookStatus.AVAILABLE);
            bookEntityFromDB.setBookHolder(null);
        }
        bookRepository.save(bookEntityFromDB);
    }

    public void deleteBook(int id) {
        bookRepository.delete(id);
    }
}
