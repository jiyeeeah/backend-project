package com.jiyebackend.backendproject.board.repository;

import com.jiyebackend.backendproject.board.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
