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

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.exception.HystrixRuntimeException.FailureType;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;

/**
 * @author darshanrambhia
 *
 */
public class AppdHystrixCommandExecutionHook extends HystrixCommandExecutionHook {
    
    /**
     * Instantiates a new appd hystrix command execution hook.
     */
    public AppdHystrixCommandExecutionHook() {
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onExecutionError(com.netflix.hystrix.HystrixInvokable,
     * java.lang.Exception)
     */
    @Override
    public <T> Exception onExecutionError(HystrixInvokable<T> commandInstance, Exception e) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance,"onExecutionError");
        }
        return super.onExecutionError(commandInstance, e);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onExecutionStart(com.netflix.hystrix.HystrixInvokable)
     */
    @Override
    public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance,"onExecutionStart");
        }
        super.onExecutionStart(commandInstance);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onFallbackError(com.netflix.hystrix.HystrixInvokable,
     * java.lang.Exception)
     */
    @Override
    public <T> Exception onFallbackError(HystrixInvokable<T> commandInstance, Exception e) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance,"onFallbackError");
        }
        return super.onFallbackError(commandInstance, e);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onFallbackStart(com.netflix.hystrix.HystrixInvokable)
     */
    @Override
    public <T> void onFallbackStart(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onFallbackStart");
        }
        super.onFallbackStart(commandInstance);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onFallbackSuccess(com.netflix.hystrix.HystrixInvokable)
     */
    @Override
    public <T> void onFallbackSuccess(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance,"onFallbackSuccess");
        }
        super.onFallbackSuccess(commandInstance);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onStart(com.netflix.hystrix.HystrixInvokable)
     */
    @Override
    public <T> void onStart(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onStart");
        }
        super.onStart(commandInstance);
    }
    
    /*
      * (non-Javadoc)
      * @see
      * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
      * onThreadComplete(com.netflix.hystrix.HystrixInvokable)
      */
    
    @Override
    public <T> void onThreadComplete(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onThreadComplete");
        }
        super.onThreadComplete(commandInstance);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onThreadStart(com.netflix.hystrix.HystrixInvokable)
     */
    @Override
    public <T> void onThreadStart(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onThreadStart");
        }
        super.onThreadStart(commandInstance);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onError(com.netflix.hystrix.HystrixInvokable,
     * com.netflix.hystrix.exception.HystrixRuntimeException.FailureType,
     * java.lang.Exception)
     */
    @Override
    public <T> Exception onError(HystrixInvokable<T> commandInstance, FailureType failureType, Exception e) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onError");
        }
        return super.onError(commandInstance, failureType, e);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onExecutionEmit(com.netflix.hystrix.HystrixInvokable, java.lang.Object)
     */
    @Override
    public <T> T onExecutionEmit(HystrixInvokable<T> commandInstance, T value) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onExecutionEmit");
        }
        return super.onExecutionEmit(commandInstance, value);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onExecutionSuccess(com.netflix.hystrix.HystrixInvokable)
     */
    @Override
    public <T> void onExecutionSuccess(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onExecutionSuccess");
        }
        super.onExecutionSuccess(commandInstance);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onSuccess(com.netflix.hystrix.HystrixInvokable)
     */
    @Override
    public <T> void onSuccess(HystrixInvokable<T> commandInstance) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onSuccess");
        }
        super.onSuccess(commandInstance);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook#
     * onEmit(com.netflix.hystrix.HystrixInvokable, java.lang.Object)
     */
    @Override
    public <T> T onEmit(HystrixInvokable<T> commandInstance, T value) {
        
        
        if (commandInstance instanceof HystrixCommand) {
            markEvents((HystrixCommand<T>) commandInstance, "onEmit");
        }
        return super.onEmit(commandInstance, value);
    }
    
    /**
     * Appdynamics should use this method to collect metrics on individual command instances.
     * Following are some of the examples of the metrics to be collected: <br>
     *  - commandInstance.getCommandKey().name();<br>
     *  - commandInstance.getCommandGroup().name();<br>
     *  - commandInstance.getExecutionEvents();<br>
     *  - commandInstance.getExecutionTimeInMilliseconds();<br>
     *  - commandInstance.getMetrics().getRollingMaxConcurrentExecutions();<br>
     *  - commandInstance.getNumberEmissions();<br>
     *  - commandInstance.getNumberFallbackEmissions();<br>
     *  - commandInstance.getMetrics().getCurrentConcurrentExecutionCount();<br>
     * 
     * @param <T> the generic type
     * @param commandInstance the command instance
     * @param event the event
     */
    public <T> void markEvents(HystrixCommand<T> commandInstance, String event) {
        
    }
}