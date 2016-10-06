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
/**
 * 
 */
package com.kenzan.hystrix.appdynamics.hook;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixInvokable;

/**
 * @author darshanrambhia
 * @param <T>
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("unchecked")
public class AppdHystrixCommandExecutionHookTest {
    
    HystrixInvokable<?> mockedHystrixInvokable;
    HystrixCommand<Boolean> mockedHystrixCommand;
    @Spy
    AppdHystrixCommandExecutionHook hook;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        
        mockedHystrixCommand =
            new HystrixCommand<Boolean>(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestUtil"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CommandName"))) {
                
                @Override
                protected Boolean run() {
                    
                    return true;
                }
            };
        mockedHystrixInvokable = new HystrixInvokable<Boolean>() {
        };
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onExecutionError(com.netflix.hystrix.HystrixInvokable, java.lang.Exception)}.
     */
    @Test
    public final void testOnExecutionError() throws Exception {
        
        hook.onExecutionError((HystrixInvokable<Boolean>) mockedHystrixCommand, null);
        verify(hook).markEvents(mockedHystrixCommand, "onExecutionError");
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onExecutionError(com.netflix.hystrix.HystrixInvokable, java.lang.Exception)}.
     */
    @Test
    public final void testOnExecutionError2() throws Exception {
        
        hook.onExecutionError(mockedHystrixInvokable, null);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onExecutionError"));
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onExecutionStart(com.netflix.hystrix.HystrixInvokable)}.
     */
    @Test
    public final void testOnExecutionStart() throws Exception {
        
        hook.onExecutionStart((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onExecutionStart");
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onExecutionStart(com.netflix.hystrix.HystrixInvokable)}.
     */
    @Test
    public final void testOnExecutionStart2() throws Exception {
        
        hook.onExecutionStart(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onExecutionStart"));
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onFallbackError(com.netflix.hystrix.HystrixInvokable, java.lang.Exception)}.
     */
    @Test
    public final void testOnFallbackError() throws Exception {
        
        hook.onExecutionError((HystrixInvokable<Boolean>) mockedHystrixCommand, null);
        verify(hook).markEvents(mockedHystrixCommand, "onExecutionError");
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onFallbackError(com.netflix.hystrix.HystrixInvokable, java.lang.Exception)}.
     */
    @Test
    public final void testOnFallbackError2() throws Exception {
        
        hook.onExecutionError(mockedHystrixInvokable, null);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onExecutionError"));
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onFallbackStart(com.netflix.hystrix.HystrixInvokable)}.
     */
    @Test
    public final void testOnFallbackStart() throws Exception {
        
        hook.onFallbackStart((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onFallbackStart");
    }
    
    /**
     * Test method for
     * {@link com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook#onFallbackStart(com.netflix.hystrix.HystrixInvokable)}.
     */
    @Test
    public final void testOnFallbackStart2() throws Exception {
        
        hook.onFallbackStart(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onFallbackStart"));
    }

    @Test
    public void testOnFallbackSuccess() throws Exception {
        
        hook.onFallbackSuccess((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onFallbackSuccess");
    }
    
    @Test
    public void testOnFallbackSuccess2() throws Exception {
        
        hook.onFallbackStart(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onFallbackStart"));
    }

    @Test
    public void testOnStart() throws Exception {
        
        hook.onStart((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onStart");
    }
    
    @Test
    public void testOnStart2() throws Exception {
        
        hook.onStart(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onStart"));
    }

    @Test
    public void testOnThreadComplete() throws Exception {
        
        hook.onThreadComplete((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onThreadComplete");
    }
    
    @Test
    public void testOnThreadComplete2() throws Exception {
        
        hook.onThreadComplete(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onThreadComplete"));
    }

    @Test
    public void testOnThreadStart() throws Exception {
        
        hook.onThreadStart((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onThreadStart");
    }
    
    @Test
    public void testOnThreadStart2() throws Exception {
        
        hook.onThreadStart(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onThreadStart"));
    }

    @Test
    public void testOnError() throws Exception {
        
        hook.onError((HystrixInvokable<Boolean>) mockedHystrixCommand, null, null);
        verify(hook).markEvents(mockedHystrixCommand, "onError");
    }

    @Test
    public void testOnError2() throws Exception {
        
        hook.onError(mockedHystrixInvokable, null, null);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onError"));
    }

    @Test
    public void testOnExecutionEmit() throws Exception {
        
        hook.onExecutionEmit((HystrixInvokable<Boolean>) mockedHystrixCommand, null);
        verify(hook).markEvents(mockedHystrixCommand, "onExecutionEmit");
    }
    
    @Test
    public void testOnExecutionEmit2() throws Exception {
        
        hook.onExecutionEmit(mockedHystrixInvokable, null);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onExecutionEmit"));
    }

    @Test
    public void testOnExecutionSuccess() throws Exception {
        
        hook.onExecutionSuccess((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onExecutionSuccess");
    }

    @Test
    public void testOnExecutionSuccess2() throws Exception {
        
        hook.onExecutionSuccess(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onExecutionSuccess"));
    }

    @Test
    public void testOnSuccess() throws Exception {
        
        hook.onSuccess((HystrixInvokable<Boolean>) mockedHystrixCommand);
        verify(hook).markEvents(mockedHystrixCommand, "onSuccess");
    }
    
    @Test
    public void testOnSuccess2() throws Exception {
        
        hook.onSuccess(mockedHystrixInvokable);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onSuccess"));
    }

    @Test
    public void testOnEmit() throws Exception {
        
        hook.onEmit((HystrixInvokable<Boolean>) mockedHystrixCommand, null);
        verify(hook).markEvents(mockedHystrixCommand, "onEmit");
    }
    
    @Test
    public void testOnEmit2() throws Exception {
        
        hook.onEmit(mockedHystrixInvokable, null);
        verify(hook, never()).markEvents(any(HystrixCommand.class), eq("onEmit"));
    }
}
