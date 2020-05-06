package com.example.demo090.service;

import com.example.demo090.control.param.BookReq;
import com.example.demo090.domain.Book;

import java.util.List;

public interface BookService  {
    public Book createOne(BookReq userReq);

    public Book updateBook(Integer id, String name);

    public List<Book> getAll();

    public void deleteBook(Integer id);

    public List<Book> findUsers(String keyName);

    public List<Book> findBooksByAges(Double low, Double high);
}
