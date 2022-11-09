package org.itcg.library.service.impl;

import org.itcg.library.dao.BookDao;
import org.itcg.library.model.database.Book;
import org.itcg.library.service.BookService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {
  private final BookDao repository;

  public BookServiceImpl(BookDao repository) {
    this.repository = repository;
  }

  @Override
  public Mono<Book> save(Mono<Book> book) {
    return book.flatMap(repository::save);
  }

  @Override
  public Mono<Book> load(String ISBN) {
    return repository.findById(ISBN);
  }

  @Override
  public Mono<Void> delete(String ISBN) {
    return repository.deleteById(ISBN);
  }

  @Override
  public Flux<Book> loadAll() {
    return repository.findAll();
  }
}
