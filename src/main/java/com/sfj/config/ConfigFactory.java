package com.sfj.config;

public final class ConfigFactory { // made final so cannot be extended
    private ConfigFactory(){} // Not able to create an object
    public static FrameworkConfig getConfig(){
        return org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);
    }
}
