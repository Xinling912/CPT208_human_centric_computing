package com.echorun.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RunUploadDTO {

    @NotNull
    private Long userId;

    private String startedAtIso;
    private String endedAtIso;

    private Double distanceMeters;
    private Integer durationSeconds;

    @NotEmpty
    @Valid
    private List<TrajectoryPointDTO> trajectory;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartedAtIso() {
        return startedAtIso;
    }

    public void setStartedAtIso(String startedAtIso) {
        this.startedAtIso = startedAtIso;
    }

    public String getEndedAtIso() {
        return endedAtIso;
    }

    public void setEndedAtIso(String endedAtIso) {
        this.endedAtIso = endedAtIso;
    }

    public Double getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(Double distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public List<TrajectoryPointDTO> getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(List<TrajectoryPointDTO> trajectory) {
        this.trajectory = trajectory;
    }

    public static class TrajectoryPointDTO {

        @NotNull
        private Double latitude;
        @NotNull
        private Double longitude;
        private Long recordedAtEpochMs;

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Long getRecordedAtEpochMs() {
            return recordedAtEpochMs;
        }

        public void setRecordedAtEpochMs(Long recordedAtEpochMs) {
            this.recordedAtEpochMs = recordedAtEpochMs;
        }
    }
}
