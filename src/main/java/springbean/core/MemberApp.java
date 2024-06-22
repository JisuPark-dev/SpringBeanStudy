package springbean.core;

import springbean.core.member.Grade;
import springbean.core.member.Member;
import springbean.core.member.MemberService;
import springbean.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member);
        System.out.println("findMember = " + findMember);
    }
}
