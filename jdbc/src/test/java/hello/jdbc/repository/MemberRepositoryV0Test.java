package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("member7", 10000);
        repositoryV0.save(member);

        //findById
        Member findMember = repositoryV0.findById(member.getMemberId());
        log.info("findMember={}", findMember); //lombok의 @Data안에 ToString -> Member(값, 값) 출력
        log.info("member == findMember {}", member == findMember);
        log.info("member equals findMember {}" , member.equals(findMember)); //lombok의 @Data -> equals, hashcode 만들어줌 -> 내용물 같으면 같게 취급
        assertThat(findMember).isEqualTo(member);

        //update: money: 10000 -> 20000
        repositoryV0.update(member.getMemberId(), 20000);
        Member updateMember = repositoryV0.findById(member.getMemberId());
        assertThat(updateMember.getMoney()).isEqualTo(20000);

        //delete
        repositoryV0.delete(member.getMemberId());
        assertThatThrownBy(() -> repositoryV0.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}
