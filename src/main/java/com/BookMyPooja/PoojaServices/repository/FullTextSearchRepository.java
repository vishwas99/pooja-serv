package com.BookMyPooja.PoojaServices.repository;

import com.BookMyPooja.PoojaServices.entity.Provider;
import com.BookMyPooja.PoojaServices.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FullTextSearchRepository extends JpaRepository<Service, Long> {
    @Query(value = "select * from services where to_tsvector(service_name) @@ to_tsquery(:key)", nativeQuery = true)
    List<Service> searchByKey(@Param("key") String key);
}
