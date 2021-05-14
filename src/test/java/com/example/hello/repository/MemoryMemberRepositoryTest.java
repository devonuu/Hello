package com.example.hello.repository;

import static org.assertj.core.api.Assertions.*;

import com.example.hello.domain.Member;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void afterEach(){
    repository.clearStore();
  }

  @Test
  public void save(){
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();

    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName(){
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result1 = repository.findByName("spring1").get();
    Member result2 = repository.findByName("spring2").get();

    assertThat(member1).isEqualTo(result1);
    assertThat(member2).isEqualTo(result2);
    assertThat(result1).isNotEqualTo(result2);
  }

  @Test
  public void findAll(){
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();

    assertThat(result.size()).isEqualTo(2);
  }
}
