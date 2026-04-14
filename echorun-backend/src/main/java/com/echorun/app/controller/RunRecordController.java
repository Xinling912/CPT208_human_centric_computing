package com.echorun.app.controller;

import com.echorun.app.dto.GhostResponseDTO;
import com.echorun.app.dto.RunUploadDTO;
import com.echorun.app.model.RunRecord;
import com.echorun.app.service.RunRecordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/runs")
public class RunRecordController {

    private final RunRecordService runRecordService;

    public RunRecordController(RunRecordService runRecordService) {
        this.runRecordService = runRecordService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> upload(@Valid @RequestBody RunUploadDTO dto) {
        RunRecord saved = runRecordService.saveUpload(dto);
        return ResponseEntity.ok(Map.of("id", saved.getId(), "message", "上传成功"));
    }

    @GetMapping("/ghost")
    public ResponseEntity<GhostResponseDTO> ghost(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(runRecordService.getGhostTracks(userId));
    }
}
