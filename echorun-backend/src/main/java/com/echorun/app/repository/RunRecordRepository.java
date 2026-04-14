package com.echorun.app.repository;

import com.echorun.app.model.RunRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RunRecordRepository extends JpaRepository<RunRecord, Long> {

    List<RunRecord> findTop10ByUser_IdNotOrderByStartedAtDesc(Long userId);
}
