/**
 * Copyright © 2016 Kenzan, LLC (http://kenzan.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kenzan.hystrix.appdynamics.hook;

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
