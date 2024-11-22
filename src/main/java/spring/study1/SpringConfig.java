package spring.study1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.study1.repository.MemberRepository;
import spring.study1.repository.MemoryMemberRepository;
import spring.study1.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
