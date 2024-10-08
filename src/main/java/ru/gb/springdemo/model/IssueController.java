package ru.gb.springdemo.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.springdemo.repository.BookRepository;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;
import ru.gb.springdemo.service.IssuerService;

@RestController
@RequestMapping("/reader")
public class IssueController {

    @Autowired
    BookRepository bookRepository;
    ReaderRepository readerRepository;
    IssuerService issuerService;


}
