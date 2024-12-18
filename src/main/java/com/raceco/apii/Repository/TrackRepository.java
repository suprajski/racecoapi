package com.raceco.apii.Repository;

import com.raceco.apii.Entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findByCityCityId(Long cityId);
    List<Track> findByBranchBranchId(Long branchId);
}
