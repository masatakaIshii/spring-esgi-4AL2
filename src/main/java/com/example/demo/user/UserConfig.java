package com.example.demo.user;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConstructorBinding
@ConfigurationProperties(prefix = "app.users")
public
class UserConfig {

    private Integer max = 4;

    UserConfig(@DefaultValue("3") Integer max) {
        this.max = max;
    }

    Integer getMax() {
        return max;
    }
}
