package net.kenzan.hystrix.appdynamics.hook;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
    public void setup() throws IOException {
        
        ConfigurationManager.loadPropertiesFromResources("hystrix-appdynamics.properties");
    }
    
    @Test
    public void testHookSetup() {
        
        HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();
        HystrixEventNotifier hystrixEventNotifier = HystrixPlugins.getInstance().getEventNotifier();
        
        assertTrue(commandExecutionHook instanceof AppdHystrixCommandExecutionHook);
        assertTrue(hystrixEventNotifier instanceof AppdHystrixEventNotifierHook);
    }
}
