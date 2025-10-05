package com.bobs.spring.core.spring_core_devs4js.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("qa")
public class QaEnviroment implements EnvioromentService {

    @Override
    public String getEnviroment() {
        // TODO Auto-generated method stub
        return "QA";
    }

}
