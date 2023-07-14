package hello.hellospring.domain;


import javax.persistence.*;

@Entity //JPA가 관리하는 entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 id를 자동생성: identity 전략
    private Long id;

    //@Column(name = "username") //column이 username
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
