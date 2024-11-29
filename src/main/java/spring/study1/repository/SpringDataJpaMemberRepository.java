package spring.study1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study1.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
