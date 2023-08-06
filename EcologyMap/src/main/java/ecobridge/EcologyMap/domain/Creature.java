package ecobridge.EcologyMap.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter //자동으로 GET메서드를 통해 필드 접근 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED) //접근제어자가 protected인 기본생성자 코드없이 생성
public class Creature {

    //생물 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="creature_id", updatable = false)
    private Long creature_id;

    //생물 보호등급
    @Column(name="creature_protection_class", nullable = false)
    private Long creature_protection_class;

    //생물 정보
    @Column(name="creature_information", nullable = false)
    private String creature_information;

    //여러개의 생물은 하나의 카테고리일수 있으므로 ManyToOne
    @ManyToOne
    @JoinColumn(name="category_id") //category_id column을 외래키로 추가
    private Creature_category category; //Creature_category entity를 객체로 생성. Creature에서 creature_category의 category_name에 접근하고 싶을때 해당 변수 사용

    @Column(name="image_url", nullable = false)
    private String image_url;
}