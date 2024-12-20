package com.raceco.apii.Service;

import com.raceco.apii.Entity.Branch;
import com.raceco.apii.Entity.City;
import com.raceco.apii.Entity.Track;
import com.raceco.apii.Repository.BranchRepository;
import com.raceco.apii.Repository.CityRepository;
import com.raceco.apii.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Track addTrack(Track track) {

        // Ensure the branch exists
        Branch branch = branchRepository.findById(track.getBranch().getBranchId())
                .orElseThrow(() -> new IllegalArgumentException("Branch not found"));

        // Ensure the city exists or save a new one
        City city = cityRepository.findByCityNameAndBranchBranchId(
                track.getCity().getCityName(),
                branch.getBranchId()
        ).orElseGet(() -> {
            City newCity = track.getCity();
            newCity.setBranch(branch);
            return cityRepository.save(newCity);
        });

        track.setCity(city);
        track.setBranch(branch);
        return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(Long trackId) {
        return trackRepository.findById(trackId)
                .orElseThrow(()->new RuntimeException("Track not found with ID: "+trackId));
    }

    @Override
    public List<Track> getAllTracks() {return  trackRepository.findAll();}

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
