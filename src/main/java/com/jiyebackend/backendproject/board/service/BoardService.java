package com.jiyebackend.backendproject.board.service;

import com.jiyebackend.backendproject.board.dto.BoardDTO;
import com.jiyebackend.backendproject.board.entity.BoardEntity;
import com.jiyebackend.backendproject.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class)

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity((boardDTO));
        boardRepository.save(boardEntity);
    }
}
