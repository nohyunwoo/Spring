package Hello.core;

import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import Hello.core.order.OrderService;
import Hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // 설정 정보
// 전반적인 앱 동작을 결정하는 기획자
public class AppConfig {

    @Bean // 스프링 컨테이너에 등록
    public MemberService memberService(){ // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
