package com.example.back.mapper;

import com.example.back.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from book")
    List<Book> findAllBook();

    @Select("select * from book where bookId=#{id}")
    List<Book> BookById(int id);

    @Insert("insert into book(bookId,name,press,author,price) value(#{id},#{name},#{press},#{author},#{price})")
    int insertbook(int id,String name,String press,String author,double price);
}
