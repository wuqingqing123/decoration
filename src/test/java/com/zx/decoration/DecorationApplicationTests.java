package com.zx.decoration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DecorationApplicationTests {

    @Test
    void contextLoads() {
        String path = System.getProperty("user.dir");
        System.out.println("---------"+path);
    }

}
