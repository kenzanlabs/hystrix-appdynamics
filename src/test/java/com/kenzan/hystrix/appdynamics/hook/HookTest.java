package com.kenzan.hystrix.appdynamics.hook;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;

public class HookTest {

    @Test
    public void testHookSetup() {
        
        HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();
        HystrixEventNotifier hystrixEventNotifier = HystrixPlugins.getInstance().getEventNotifier();
        
        assertTrue(commandExecutionHook instanceof AppdHystrixCommandExecutionHook);
        assertTrue(hystrixEventNotifier instanceof AppdHystrixEventNotifierHook);
    }
}