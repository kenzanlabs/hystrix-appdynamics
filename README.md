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