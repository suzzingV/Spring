package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.*;
public class MemberService {
    private MemberRepository memberRepository;

    //@Autowired //스프링 컨테이너에 있는 것들만 동작
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public Long join(Member member) {
        //같은 이름 중복 회원 안됨
        validateDuplicateMember(member); //ctrl + alt + m
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //Optional 메소드
            throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
