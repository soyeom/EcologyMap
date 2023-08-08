package ecobridge.EcologyMap.controller;

import ecobridge.EcologyMap.domain.Creature;
import ecobridge.EcologyMap.dto.AddCreatureRequest;
import ecobridge.EcologyMap.service.CreatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController //HTTP Response Body 에 객체 데이터를 JSON 형싟으로 변환하는 컨트롤러
public class MapApiController {

    private final CreatureService creatureService;

    //HTTP 메서드가 POST 일 때 전달받은 URL 과 동일한 메서드로 매핑
    @PostMapping("/api/creatures")
    //@RequestBody 로 요청 본문 값 매핑
    public ResponseEntity<Creature> addCreature(@RequestBody AddCreatureRequest request) {
        Creature savedCreature = creatureService.save(request);

        //요청한 자원이 성공적으로 생성도었으며 저장된 생물 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCreature);
    }
}
