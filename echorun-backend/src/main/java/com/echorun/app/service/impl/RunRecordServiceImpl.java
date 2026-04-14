package com.echorun.app.service.impl;

import com.echorun.app.dto.GhostResponseDTO;
import com.echorun.app.dto.RunUploadDTO;
import com.echorun.app.model.RunRecord;
import com.echorun.app.model.User;
import com.echorun.app.repository.RunRecordRepository;
import com.echorun.app.repository.UserRepository;
import com.echorun.app.service.RunRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RunRecordServiceImpl implements RunRecordService {

    private final RunRecordRepository runRecordRepository;
    private final UserRepository userRepository;

    public RunRecordServiceImpl(RunRecordRepository runRecordRepository, UserRepository userRepository) {
        this.runRecordRepository = runRecordRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public RunRecord saveUpload(RunUploadDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("用户不存在"));

        RunRecord record = new RunRecord();
        record.setUser(user);
        if (dto.getStartedAtIso() != null && !dto.getStartedAtIso().isBlank()) {
            record.setStartedAt(Instant.parse(dto.getStartedAtIso()));
        }
        if (dto.getEndedAtIso() != null && !dto.getEndedAtIso().isBlank()) {
            record.setEndedAt(Instant.parse(dto.getEndedAtIso()));
        }
        record.setDistanceMeters(dto.getDistanceMeters());
        record.setDurationSeconds(dto.getDurationSeconds());

        List<RunRecord.TrajectoryPoint> points = dto.getTrajectory().stream().map(p -> {
            RunRecord.TrajectoryPoint tp = new RunRecord.TrajectoryPoint();
            tp.setLatitude(p.getLatitude());
            tp.setLongitude(p.getLongitude());
            tp.setRecordedAtEpochMs(p.getRecordedAtEpochMs());
            return tp;
        }).collect(Collectors.toList());
        record.setTrajectory(points);

        return runRecordRepository.save(record);
    }

    @Override
    @Transactional(readOnly = true)
    public GhostResponseDTO getGhostTracks(Long currentUserId) {
        List<RunRecord> ghosts = runRecordRepository.findTop10ByUser_IdNotOrderByStartedAtDesc(currentUserId);
        List<GhostResponseDTO.GhostTrackDTO> tracks = ghosts.stream().map(run -> {
            GhostResponseDTO.GhostTrackDTO t = new GhostResponseDTO.GhostTrackDTO();
            t.setRunRecordId(run.getId());
            List<RunUploadDTO.TrajectoryPointDTO> pts = run.getTrajectory().stream().map(tp -> {
                RunUploadDTO.TrajectoryPointDTO d = new RunUploadDTO.TrajectoryPointDTO();
                d.setLatitude(tp.getLatitude());
                d.setLongitude(tp.getLongitude());
                d.setRecordedAtEpochMs(tp.getRecordedAtEpochMs());
                return d;
            }).collect(Collectors.toList());
            t.setTrajectory(pts);
            return t;
        }).collect(Collectors.toList());
        return new GhostResponseDTO(tracks);
    }
}
