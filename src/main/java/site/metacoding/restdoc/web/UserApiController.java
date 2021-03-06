package site.metacoding.restdoc.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.restdoc.domain.User;

@RequestMapping("/api") // 이 컨트롤러에 진입할 때 무조건 "/api"가 붙어있어야 함, 일일이 붙여줄 필요 없다!
@RestController
public class UserApiController {

    // save > post 저장
    // deleteById > delete 삭제
    // updateById > put 수정
    // findById > get
    // findAll > get
    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user) {
        // userService.회원가입(user);
        User userEntity = User.builder()
                .id(1)
                .username("ssar")
                .password("1234")
                .email("ssar@nate.com")
                .build();

        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        // userService.회원정보보기(id);
        User userEntity = User.builder()
                .id(1)
                .username("ssar")
                .password("1234")
                .email("ssar@nate.com")
                .build();

        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> findAll() {
        // userService.회원전체보기();
        User userEntity1 = User.builder()
                .id(1)
                .username("ssar")
                .password("1234")
                .email("ssar@nate.com")
                .build();

        User userEntity2 = User.builder()
                .id(2)
                .username("cos")
                .password("1234")
                .email("cos@nate.com")
                .build();

        List<User> users = Arrays.asList(userEntity1, userEntity2);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
