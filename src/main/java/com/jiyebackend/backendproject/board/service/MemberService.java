package com.jiyebackend.backendproject.board.service;

import com.jiyebackend.backendproject.board.dto.MemberDTO;
import com.jiyebackend.backendproject.board.entity.MemberEntity;
import com.jiyebackend.backendproject.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join (MemberDTO memberDTO) {
        // repository 의 save 메서드 호출 (조건: entity 객체를 넘겨줘야 함)
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);

    }
}
