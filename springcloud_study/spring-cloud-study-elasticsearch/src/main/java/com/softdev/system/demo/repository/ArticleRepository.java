package com.softdev.system.demo.repository;

import com.softdev.system.demo.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * ElasticsearchRepository --> ElasticsearchCrudRepository --> PagingAndSortingRepository --> CrudRepository
 * @author Wujun
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {

}
