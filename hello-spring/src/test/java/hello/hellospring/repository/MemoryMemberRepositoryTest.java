package hello.hellospring.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*; //static 들어가면 바로 함수 쓸수 있음

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //Test 끝날때마다 실행
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("sujin");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //Optional에서 값 꺼내기
        //System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result); //둘이 똑같은지 확인 //기대값, 비교값
        //같으면 파란불, 다르면 빨간불
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("sujin");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("yoonseok");
        repository.save(member2);

        Member result = repository.findByName("yoonseok").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("sujin");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("yoonseok");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
