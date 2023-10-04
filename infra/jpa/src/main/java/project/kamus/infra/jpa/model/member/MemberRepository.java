package project.kamus.infra.jpa.model.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}