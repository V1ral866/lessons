package com.hillel.mvc.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    private int bookId;
    private String bookAuthor;
    private String bookTitle;
    private String bookHolder;
    private BookStatus bookStatus = BookStatus.AVAILABLE;
}
