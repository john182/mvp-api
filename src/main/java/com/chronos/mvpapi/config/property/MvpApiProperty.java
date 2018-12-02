package com.chronos.mvpapi.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mvp")
@Getter
@Setter
public class MvpApiProperty {

    private final Seguranca seguranca = new Seguranca();
    private String originPermitida = "http://localhost:8000";

    @Getter
    @Setter
    public static class Seguranca {

        private boolean enableHttps;


    }
}
