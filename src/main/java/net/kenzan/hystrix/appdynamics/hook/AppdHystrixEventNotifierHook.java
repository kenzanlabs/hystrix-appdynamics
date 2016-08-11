package net.kenzan.hystrix.appdynamics.hook;

import java.util.List;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import com.netflix.hystrix.HystrixEventType;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;

/**
 * The Class AppdHystrixEventNotifierHook.
 */
public class AppdHystrixEventNotifierHook extends HystrixEventNotifier {
    
    /**
     * Instantiates a new appd hystrix event notifier hook.
     */
    public AppdHystrixEventNotifierHook() {
        
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier#markEvent
     * (com.netflix.hystrix.HystrixEventType,
     * com.netflix.hystrix.HystrixCommandKey)
     */
    @Override
    public void markEvent(HystrixEventType eventType, HystrixCommandKey key) {
        
        super.markEvent(eventType, key);
    }
    
    /*
     * (non-Javadoc)
     * @see com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier#
     * markCommandExecution(com.netflix.hystrix.HystrixCommandKey,
     * com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy,
     * int, java.util.List)
     */
    @Override
    public void markCommandExecution(HystrixCommandKey key,
                                     ExecutionIsolationStrategy isolationStrategy,
                                     int duration,
                                     List<HystrixEventType> eventsDuringExecution) {
        
        super.markCommandExecution(key, isolationStrategy, duration, eventsDuringExecution); 
    }
}
