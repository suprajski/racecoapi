package com.raceco.apii.Service;

import com.raceco.apii.Entity.Track;

import java.util.List;

public interface TrackService {
    Track addTrack(Track track);
    Track getTrackById(Long trackId);
    List<Track> getTracksByCity(Long cityId);
    List<Track> getTracksByBranch(Long branchId);

    List<Track> getAllTracks();
    void deleteTrack(Long trackId);
}
