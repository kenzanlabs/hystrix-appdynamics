## Hystrix-AppDynamics

# Information
| Package       | Description   | Version|
| ------------- |:-------------:| ------:|
| hystrix-appdynamics| Hooks for Appdynamics to instrument Hystrix | 0.0.1-SNAPSHOT |

# Overview
hystrix-appdynamics provides specific hooks for Appdynamics to instrument hystrix

# Usage
Maven:

```
<dependency>    
    <groupId>net.kenzan.hystrix </groupId>
	<artifactId>hystrix-appdynamics</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency> 
```
# Dependencies
| GroupId   | ArtifactId    | Min. Version |
| --------- |:-------------:| ------------:|
| com.netflix.hystrix |  hystrix-core   |  1.4.x  |

# Instrumenting Appdynamics
Appdynamics will need to be configured in the UI to start collecting data points from the method ```markEvents()``` method in ```net.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook``` class. The method will be called on every event triggered during a Hystrix Lifecycle and will have the current command Instance to collect the following data points. For more info: [Instrumenting Appdynamics](https://github.com/kenzanmedia/hystrix-appdynamics/wiki/Instrumenting-Appdynamics#how-to-setup-appdynamics-to-collect-the-hystrix-data)

# Datapoints for Appdynamics
- CommandKey
- CommandGroup
- ExecutionEvents
- ExecutionTimeInMilliseconds
- RollingMaxConcurrentExecutions
- NumberEmissions
- NumberFallbackEmissions
- CurrentConcurrentExecutionCount
- Hystrix Events emitted during the lifecycle

# Wiki
Wiki for this library for in-depth information: [Wiki](https://github.com/kenzanmedia/hystrix-appdynamics/wiki) 