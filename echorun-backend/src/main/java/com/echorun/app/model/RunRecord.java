package com.echorun.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "run_record")
public class RunRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "started_at")
    private Instant startedAt;

    @Column(name = "ended_at")
    private Instant endedAt;

    @Column(name = "distance_meters")
    private Double distanceMeters;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    /**
     * 与 {@code run_trajectory} 多行方案等价的单行存储：JSON 数组，
     * 元素结构见 {@link TrajectoryPoint}。
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "trajectory_json", columnDefinition = "json", nullable = false)
    private List<TrajectoryPoint> trajectory = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Instant startedAt) {
        this.startedAt = startedAt;
    }

    public Instant getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Instant endedAt) {
        this.endedAt = endedAt;
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

    public List<TrajectoryPoint> getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(List<TrajectoryPoint> trajectory) {
        this.trajectory = trajectory != null ? trajectory : new ArrayList<>();
    }

    /**
     * JSON 数组中单点结构（与前端 / DTO 字段名对齐，便于序列化）。
     */
    public static class TrajectoryPoint implements Serializable {

        private static final long serialVersionUID = 1L;

        private Double latitude;
        private Double longitude;
        private Long recordedAtEpochMs;

        public TrajectoryPoint() {
        }

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
