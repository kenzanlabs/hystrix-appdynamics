## Hystrix-AppDynamics
A simple Hystrix library to help to connect with Appdynamics

## Information
| Package       | Description   | Version|
| ------------- |:-------------:| ------:|
| hystrix-appdynamics| Hooks for Appdynamics to instrument Hystrix | 1.0.0-rc1 |

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


