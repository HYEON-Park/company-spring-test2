package com.book.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
@RunWith(SpringRunner.class)    //RunWith 테스트를 진행할 때 JUnit에 내장 된 실행자 외에 다른 실행자를 실행시킴( 여기서는 SpringRunner라는 스프링 실행자를 사용.
                                //ㄴ스프링부트 테스트와 JUit 사이의 연결자 역할을 함.
@WebMvcTest                     //Web(SpringMVC) 에 집중할 수 있는 어노테이션.
public class HelloControllerTest {
    @Autowired                                              //스프링이 관리하는 빈 Bean을 주입받는다.
    private MockMvc mvc;                                    //웹API를 테스트할 때 사용합니다.

    @Test
    public void hello가리턴됨() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())                 //mvc.perform의 결과를 검증 / HTTP Header Status 검증 / 200,404,500 등 상태검증
                .andExpect(content().string(hello));        //mvc.perform의 결과를 검증 / 응답본문내용을 검증
                                                            //ㄴController에서 "hello"를 리턴하기 때문에 값을 검증.
    }

    @Test
    public void helloDto리턴() throws Exception {
        String name = "hello";
        int amount  = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name )
                        .param("amount", String.valueOf(amount))
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //
                .andExpect(jsonPath("$.amount", is(amount)));
                            //jsonPath = JSON 응답값을 필드별로 검증할 수 있는 메소드.
                            //$를 기준으로 필드명을 명시
    }
}
