package net.kenzan.hystrix.appdynamics.hook;

import static org.junit.Assert.assertTrue;

import org.apache.commons.configuration.AbstractConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;

@RunWith(MockitoJUnitRunner.class)
public class HookTest {
    
    @Before
    public void setup() {
        
        AbstractConfiguration config = ConfigurationManager.getConfigInstance();
        
        config.addProperty("hystrix.plugin.HystrixEventNotifier.implementation",
            "net.kenzan.hystrix.appdynamics.hook.AppdHystrixEventNotifierHook");
        config.addProperty("hystrix.plugin.HystrixCommandExecutionHook.implementation",
            "net.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook");
    }
    
    @Test
    public void testHookSetup() {
        
        HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();
        HystrixEventNotifier hystrixEventNotifier = HystrixPlugins.getInstance().getEventNotifier();
        
        assertTrue(commandExecutionHook instanceof AppdHystrixCommandExecutionHook);
        assertTrue(hystrixEventNotifier instanceof AppdHystrixEventNotifierHook);
    }
}
