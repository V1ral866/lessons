package com.hillel.mvc.library;

import com.hillel.mvc.library.dao.BookRepository;
import com.hillel.mvc.library.model.BookEntity;
import com.hillel.mvc.library.model.BookStatus;
import com.hillel.mvc.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getBooksList() {
        List<BookEntity> books = bookService.getBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("books");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String AddBookForm(Model model) {
        model.addAttribute("bookAttribute", new BookEntity());
        return "addBook";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBook")
    public String addBook(@ModelAttribute("bookAttribute") BookEntity bookEntity) {
        bookService.saveBook(bookEntity);
        return "redirect:/books/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/takeBook")
    public String updateBookStatus(@ModelAttribute("bookAttribute") BookEntity bookEntity) {
        bookService.takeBook(bookEntity.getBookId(), bookEntity.getBookHolder());
        return "redirect:/books/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteBook")
    public String deleteBook(@RequestParam("bookId") int id) {
        bookService.deleteBook(id);
        return "redirect:/books/list";
    }
}
