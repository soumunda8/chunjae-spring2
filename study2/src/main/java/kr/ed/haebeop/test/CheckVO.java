package kr.ed.haebeop.test;

import lombok.Data;

import javax.validation.constraints.*;

/*
// 데이터베이스에서 DTO나 VO와 데이터베이스 테이블과 연동하는 JPA 같은 경우에 활용
import javax.persistence.*;
*/

@Data
public class CheckVO {

    /* @Id */
    @NotNull
    @Null(message = "아이디는 필수 항목입니다.")
    @Size(min = 5, max = 12, message = "아이디는 5~12자로 작성해야 합니다.")
    @Pattern(regexp = "^[a-z0-9]+$", message = "영문 소문자와 숫자 입력이 가능합니다.")
    private String id;

    @NotNull
    @Null(message = "비밀번호는 필수 항목입니다.")
    @Size(min = 5, max = 18, message = "비밀번호는 5~18자로 작성해야 합니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "영문 소문자와 영문대문자, 숫자 입력이 가능합니다.")
    private String pw;

}

/*
    javax.validation 패키지에서 지정 가능한 애노테이션 및 옵션
*/