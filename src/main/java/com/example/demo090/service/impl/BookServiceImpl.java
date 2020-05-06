package com.example.demo090.service.impl;

import com.example.demo090.control.param.BookReq;
import com.example.demo090.dao.entity.BookEntity;
import com.example.demo090.dao.repository.BookRepository;
import com.example.demo090.domain.Book;
import com.example.demo090.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 接口实现类，用于处理CRUD逻辑
 */
@Service
public class BookServiceImpl implements BookService {

    //自动注入
    @Autowired
    BookRepository bookRepository;

    /**
     * 在数据库中根据请求参数创建一条记录，返回Domain对象
     *
     * @param bookReq 请求存储的信息对象
     * @return domain类对象
     */
    @Override
    public Book createOne(BookReq bookReq) {
        //创建数据库实体类对象
        BookEntity bookEntity = new BookEntity();
        //使用工具类进行拷贝
        BeanUtils.copyProperties(bookReq, bookEntity);
        //保存至数据库
        bookRepository.save(bookEntity);

        //创建domain对象用于返回
        Book book = new Book();
        //拷贝
        BeanUtils.copyProperties(bookReq, book);

        //返回
        return book;


    }

    /**
     * 更新数据库
     *
     * @param id   id号
     * @param name 更新的书名
     * @return
     */
    @Override
    public Book updateBook(Integer id, String name) {

        Optional<BookEntity> bookentityopt = bookRepository.findById(id);
        Book book = new Book();

        if (bookentityopt.isPresent()) {
            BookEntity bookEntity = bookentityopt.get();
            bookEntity.setName(name);
            bookEntity = bookRepository.save(bookEntity);
            BeanUtils.copyProperties(bookEntity, book);
        }

        return book;
    }

    @Override
    public List<Book> getAll() {
        List<BookEntity> bookEntities = bookRepository.findAll();

        List<Book> books = bookEntities.stream().map(entity -> {
            Book book = new Book();
            BeanUtils.copyProperties(entity, book);
            return book;
        }).collect(Collectors.toList());

        return books;
    }

    /**
     * 根据id删除数据
     *
     * @param id
     */
    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);

    }

    /**
     * 根据关键字查找名字
     *
     * @param keyName 名字关键字
     * @return
     */
    @Override
    public List<Book> findUsers(String keyName) {
        List<BookEntity> entities = this.bookRepository.findByNameLike(keyName);
        List<Book> books = entities.stream().map(entity -> {
            Book book = new Book();
            BeanUtils.copyProperties(entity, book);
            return book;
        }).collect(Collectors.toList());
        return books;
    }

    /**
     * 根据价格区间查找样本
     * @param low
     * @param high
     * @return
     */
    @Override
    public List<Book> findBooksByAges(Double low, Double high) {
        List<BookEntity> entities = this.bookRepository.findByPriceBetween(low, high);
        List<Book> books = entities.stream().map(entity ->{
            Book book = new Book();
            BeanUtils.copyProperties(entity,book);
            return book;
        }).collect(Collectors.toList());
        return books;
    }
}
