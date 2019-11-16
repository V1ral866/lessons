package com.hillel.mvc.library;

import com.hillel.mvc.library.model.BookEntity;
import com.hillel.mvc.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksApiController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookEntity>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<List<BookEntity>> deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }
}
