package org.itcg.library.service;

import org.itcg.library.model.database.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
  Mono<Book> save(Mono<Book> book);

  Mono<Book> load(String ISBN);

  Mono<Void> delete(String ISBN);

  Flux<Book> loadAll();
}
