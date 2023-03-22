package com.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복test() {
        //given
        String name = "test";
        int amount = 100000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertThat => assertj라는 테스트 검증 라이브러리의 검증메소드
        //isEqualTo => assertj 의 동등 비교 메소드.
        //          ㄴassertThat에 있는 값과 isEqualTo 의 값을 비교해서 같을 때만 성공.
    }
}
