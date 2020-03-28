package oc.projet7.Repository;

import oc.projet7.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {

   Optional <Member> findByEmail(String email);

   Member findMemberByEmail(String email);

   Member findById(int id);
}
