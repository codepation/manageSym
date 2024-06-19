package com.example.back.service;

import com.example.back.entity.Book;
import com.example.back.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public String findAllBookById(int id){
        List<Book> books = bookMapper.BookById(id);
        if(books == null && books.isEmpty()){
            return "null";
        }
        return books.toString();

    }
//    public String insertBook(int id,String name,String press,String author,double price){
//        String re = bookMapper.insertbook(id,name,press,author,price);
//        if (re < 0){
//            return "sussecc";
//        }
//        return "fails";
//    }

}
