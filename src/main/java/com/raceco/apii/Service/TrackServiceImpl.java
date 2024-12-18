package com.raceco.apii.Service;

import com.raceco.apii.Entity.Track;
import com.raceco.apii.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(Long trackId) {
        return trackRepository.findById(trackId)
                .orElseThrow(()->new RuntimeException("Track not found with ID: "+trackId));
    }

    @Override
    public List<Track> getTracksByCity(Long cityId) {
        return trackRepository.findByCityCityId(cityId);
    }

    @Override
    public List<Track> getTracksByBranch(Long branchId) {
        return trackRepository.findByBranchBranchId(branchId);
    }

    @Override
    public void deleteTrack(Long trackId) {
        trackRepository.deleteById(trackId);
    }
}
