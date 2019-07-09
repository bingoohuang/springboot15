package com.github.bingoohuang.springboottrial.datafetcher;

import com.github.bingoohuang.springboottrial.entity.Book;
import com.github.bingoohuang.springboottrial.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDataFetcher implements DataFetcher<Book> {
    @Autowired
    private BookRepository repository;

    @Override
    public Book get(DataFetchingEnvironment environment) {
        String movieId = environment.getArgument("id");
        return repository.findOne(movieId);
    }

}
