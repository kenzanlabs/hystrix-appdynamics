package net.kenzan.hystrix.appdynamics.hook;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.exception.HystrixRuntimeException.FailureType;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;

/**
 * @author darshanrambhia
 *
 */
public class AppdHystrixCommandExecutionHook extends HystrixCommandExecutionHook {
    
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
    
    public <T> void markEvents(HystrixCommand<T> commandInstance, String event) {
        
        commandInstance.getCommandKey().name();
        commandInstance.getCommandGroup().name();
        commandInstance.getExecutionEvents();
        commandInstance.getExecutionTimeInMilliseconds();
        commandInstance.getMetrics().getRollingMaxConcurrentExecutions();
        commandInstance.getNumberEmissions();
        commandInstance.getNumberFallbackEmissions();
        commandInstance.getMetrics().getCurrentConcurrentExecutionCount();
    }
}