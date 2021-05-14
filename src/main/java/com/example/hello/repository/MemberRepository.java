package com.example.hello.repository;

import com.example.hello.domain.Member;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;

public interface MemberRepository {

  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}
