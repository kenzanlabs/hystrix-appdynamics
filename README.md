## Hystrix-AppDynamics [![Build Status](https://travis-ci.org/kenzanlabs/hystrix-appdynamics.svg?branch=master)](https://travis-ci.org/kenzanlabs/hystrix-appdynamics)


# Overview
hystrix-appdynamics provides specific hooks for Appdynamics to instrument hystrix

**Current Release: 0.0.1**

# Usage
Maven:

```
<dependency>    
    <groupId>net.kenzan.hystrix </groupId>
	<artifactId>hystrix-appdynamics</artifactId>
	<version>0.0.1</version>
</dependency> 
```
# Dependencies
| GroupId   | ArtifactId    | Min. Version |
| --------- |:-------------:| ------------:|
| com.netflix.hystrix |  hystrix-core   |  1.4.x  |

# Instrumenting Appdynamics
Appdynamics will need to be configured in the UI to start collecting data points from the method ```markEvents()``` method in ```com.kenzan.hystrix.appdynamics.hook.AppdHystrixCommandExecutionHook``` class. The method will be called on every event triggered during a Hystrix Lifecycle and will have the current command Instance to collect the following data points. For more info: [Instrumenting Appdynamics](https://github.com/kenzanmedia/hystrix-appdynamics/wiki/Instrumenting-Appdynamics#how-to-setup-appdynamics-to-collect-the-hystrix-data)

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

# License
Copyright © 2016 Kenzan, LLC (http://kenzan.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.