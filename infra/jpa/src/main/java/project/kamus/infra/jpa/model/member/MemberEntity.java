package project.kamus.infra.jpa.model.member;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.kamus.infra.jpa.model.JpaAuditEntity;

@Builder(toBuilder = true)
@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity extends JpaAuditEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private BigInteger id;

  private String username;

  private String phone;
}