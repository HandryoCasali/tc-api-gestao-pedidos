package br.com.fiap.postech.techchallenge;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@Slf4j
@EnableFeignClients
@SpringBootApplication
public class TechchallengeApplication {

    public static void main(String[] args) {
        log.info("INICIADO A APLICAÇÃO");
        SpringApplication.run(TechchallengeApplication.class, args);
    }
}