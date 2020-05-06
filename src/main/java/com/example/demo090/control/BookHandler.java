package com.example.demo090.control;

import com.example.demo090.control.param.BookReq;
import com.example.demo090.dao.entity.BookEntity;
import com.example.demo090.dao.repository.BookRepository;
import com.example.demo090.domain.Book;
import com.example.demo090.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;


    @GetMapping("/findallbook")
    public List<BookEntity> findAllBook(){
        return bookRepository.findAll();
    }

    /**
     * 创建一个用户.
     *   忽略输入数据的校验。
     *
     * @param userReq
     * @return
     */
    @PostMapping("/form")
    public Book createUser(BookReq userReq) {
        //log.info("User Req in form:{}", userReq);

        Book user = this.bookService.createOne(userReq);
        //log.info("Create User:{}", user);
        return user;
    }

    @PostMapping("/json")
    public Book createBookByJson(@RequestBody BookReq bookReq){


        Book book = this.bookService.createOne(bookReq);
        return book;
    }

    @PutMapping("/books/{id}")
    public Book updateUser(@PathVariable Integer id, String name) {

        Book book = bookService.updateBook(id,name);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public void deleteUser(@PathVariable Integer id) {
        //log.info("delete user:{}", id);

        bookService.deleteBook(id);
    }

    @GetMapping("/getall")
    public List<Book> getAll(){
        List<Book> books = bookService.getAll();
        return books;
    }

    @GetMapping("/books/name")
    public List<Book> getBooksByName(@RequestParam("keyName") String keyName) {
        List<Book> books = this.bookService.findUsers("%" + keyName + "%");
        return books;
    }

    @GetMapping("/books/price")
    public List<Book> getBooksByPrice(@RequestParam("lowPrice") Double lowprice,@RequestParam("highPrice") Double highprice){
        List<Book> books = this.bookService.findBooksByAges(lowprice, highprice);
        return books;

    }

}
