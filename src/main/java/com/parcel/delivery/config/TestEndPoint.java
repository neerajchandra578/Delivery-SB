package com.parcel.delivery.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="tstEndpoint")
public class TestEndPoint {

    private Map<String,FeatureDtl> testEndPointMap = new ConcurrentHashMap<>();

    public TestEndPoint(){
        testEndPointMap.put("Department",new FeatureDtl(true));
        testEndPointMap.put("StudentDetails",new FeatureDtl(false));
        testEndPointMap.put("Login",new FeatureDtl(false));
    }

    @ReadOperation
    private Map<String,FeatureDtl> showDetails(){
        return testEndPointMap;
    }
    /*@ReadOperation
    public FeatureDtl feature(@Selector String featureName) {
        return testEndPointMap.get(featureName);
    }*/

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class FeatureDtl{
       private boolean isActive;
    }

}
