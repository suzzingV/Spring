package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//순수하게 자바 코드로 테스트하는 것보다 시간 많이 걸림
@SpringBootTest
@Transactional //test 실행할 때 transaction 먼저 실행, db에 데이터를 다 넣은 다음 테스트 끝나면 롤백해줌(실제 db에 반영 안됨)
class MemberServiceIntegrationTest {

    @Autowired MemberRepository memberRepository; //TestCase는 편한 방식으로 //container에서 가져옴
    @Autowired MemberService memberService;

    @Test
    //@Commit 끝나면 커밋
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("yoonseok");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("sujin");

        Member member2 = new Member();
        member2.setName("sujin");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//assertThrows(예외.class, () -> 실행) : 실행했을 때 이 예외 터져야 함
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}