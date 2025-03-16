package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appconfig = new AppConfig();
//        MemberService memberService = appconfig.memberService();

        // 스프링 컨테이너에 AppConfig에 있는 것들을 저장하여 관리
        ApplicationContext applicationsContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //applicationsContext.getBean(이름, 타입)
        MemberService memberService = applicationsContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }

}
