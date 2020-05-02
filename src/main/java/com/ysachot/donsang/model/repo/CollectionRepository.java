package com.ysachot.donsang.model.repo;

import com.ysachot.donsang.model.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity,Long> {
}
