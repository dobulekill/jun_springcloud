package com.murphy.elasticsearch.repository;

import com.murphy.elasticsearch.document.OrderDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author dongsufeng
 * @date 2020/1/3 17:16
 * @version 1.0
 */
@Component
public interface OrderDocumentRepository extends ElasticsearchRepository<OrderDocument,Long> {
}
