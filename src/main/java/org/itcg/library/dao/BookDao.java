package org.itcg.library.dao;

import org.itcg.library.model.database.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends ReactiveMongoRepository<Book, String> {}
