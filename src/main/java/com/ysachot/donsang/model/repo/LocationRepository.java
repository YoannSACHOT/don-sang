package com.ysachot.donsang.model.repo;

import com.ysachot.donsang.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
}
