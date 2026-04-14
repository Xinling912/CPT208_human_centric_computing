package com.echorun.app.dto;

import java.util.List;

public class GhostResponseDTO {

    private List<GhostTrackDTO> tracks;

    public GhostResponseDTO() {
    }

    public GhostResponseDTO(List<GhostTrackDTO> tracks) {
        this.tracks = tracks;
    }

    public List<GhostTrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<GhostTrackDTO> tracks) {
        this.tracks = tracks;
    }

    public static class GhostTrackDTO {
        private Long runRecordId;
        private List<RunUploadDTO.TrajectoryPointDTO> trajectory;

        public Long getRunRecordId() {
            return runRecordId;
        }

        public void setRunRecordId(Long runRecordId) {
            this.runRecordId = runRecordId;
        }

        public List<RunUploadDTO.TrajectoryPointDTO> getTrajectory() {
            return trajectory;
        }

        public void setTrajectory(List<RunUploadDTO.TrajectoryPointDTO> trajectory) {
            this.trajectory = trajectory;
        }
    }
}
