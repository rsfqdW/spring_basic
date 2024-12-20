package spring.study1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.study1.domain.Member;
import spring.study1.repository.MemberRepository;
import spring.study1.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    //회원가입(같은 이름이 있는 중복 회원 X)
    public Long join(Member member){

            validateDuplicateMember(member);
            memberRepository.save(member);

            return member.getId();
    }

    //중복 회원 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    //전체 회원 조회
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    //ID로 한명의 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
