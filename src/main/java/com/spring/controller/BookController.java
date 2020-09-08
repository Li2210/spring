package com.spring.controller;

import com.spring.pojo.Books;
import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调用 service层
    @Autowired
    @Qualifier("BookServiceImpl")
    public BookService bookService;

    /**
     * to addBook page
     */
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }


    /**
     * add book
     */
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    /**
     * retrieve all books
     */
    @RequestMapping("/allBook")
    public String books(Model model){
        List<Books> books = bookService.queryAllBook();

        model.addAttribute("list", books);
        return "allBook";
    }

    /**
     * to update page
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id, Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("getBook", books);
        return "updateBook";
    }

    /**
     * update books
     */
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    /**
     * delete books
     */
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}
