package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBoot8827 {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot8827.class, args);
    }

    @RequestMapping("example")
    @RestController
    public class ControllerExample {

        private PropertiesExample e;

        @Autowired
        public ControllerExample(PropertiesExample e) {
            this.e = e;
        }

        @RequestMapping("one")
        public String one() {

            return e.one;
        }

        @RequestMapping("two")
        public String two() {

            return e.two;
        }

        @RequestMapping("three")
        public String three() {

            return e.three;
        }
    }

    private class PropertiesExample {

        private String one, two, three;
    }

    // Do not add "@Bean", and the context will attempt to load for each @Test,
    // and fail (as it should)
    @ConfigurationProperties(prefix = "example")
    public PropertiesExample propertiesExample() {
        return new PropertiesExample();
    }
}
