package com.github.bingoohuang.springboottrial.datafetcher;

import com.github.bingoohuang.springboottrial.entity.Book;
import com.github.bingoohuang.springboottrial.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AllBookDataFetcher implements DataFetcher<List<Book>> {
    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> get(DataFetchingEnvironment environment) {
        return repository.findAll();
    }

}
