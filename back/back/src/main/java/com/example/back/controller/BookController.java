package com.example.back.controller;

import com.example.back.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/getbook")
    public String getAllBookById(int id){
       return bookService.findAllBookById(id);
    }

//    @GetMapping("/insertbook")
//    public String insertBook(int id,String name,String press,String author,double price){return bookService.insertBook(id,name,press,author,price);}
}
