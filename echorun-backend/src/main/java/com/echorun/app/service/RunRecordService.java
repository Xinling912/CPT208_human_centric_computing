package com.echorun.app.service;

import com.echorun.app.dto.GhostResponseDTO;
import com.echorun.app.dto.RunUploadDTO;
import com.echorun.app.model.RunRecord;

public interface RunRecordService {

    RunRecord saveUpload(RunUploadDTO dto);

    GhostResponseDTO getGhostTracks(Long currentUserId);
}
