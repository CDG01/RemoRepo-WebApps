package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query(value="SELECT AVG(av.rating) FROM article_valuation av JOIN articles a ON av.article_id=a.id WHERE a.user_id=1", nativeQuery = true)
    double avgByUserId(Long user_id);
}
