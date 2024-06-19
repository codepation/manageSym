package com.example.back.entity;

import lombok.Data;

@Data
public class Book {
    Integer bookId;
    String name;//和数据库的列名相同
    String press;
    String author;
    Double price;
}
