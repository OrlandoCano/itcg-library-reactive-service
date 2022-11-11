package org.itcg.library.controller;

import org.itcg.library.model.database.Book;
import org.itcg.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/books")
@CrossOrigin("http://localhost:3000")
public class BookController {
  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Mono<Book>> create(@RequestBody Mono<Book> book) {
    return new ResponseEntity<>(service.save(book), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Flux<Book>> loadAll() {
    return new ResponseEntity<>(service.loadAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mono<Book>> load(@PathVariable String id) {
    return new ResponseEntity<>(service.load(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
    return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Mono<Book>> put(@RequestBody Mono<Book> book) {
    return new ResponseEntity<>(service.save(book), HttpStatus.CREATED);
  }
}
