/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.alibaba.nacos.config.server;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.alibaba.nacos.config.server.environment.NacosEnvironmentRepository;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.config.ConfigServerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Nacos Config Server Auto-Configuration
 *
 * @author Wujun
 * @since 0.2.0
 */
@ConditionalOnClass(EnableConfigServer.class)       // If class of @EnableConfigServer is present in class-path
@ComponentScan(basePackages = {
        "com.alibaba.nacos.config.server",
})
@AutoConfigureBefore(ConfigServerAutoConfiguration.class)
@Configuration
public class NacosConfigServerAutoConfiguration {

    @Bean
    public NacosEnvironmentRepository nacosEnvironmentRepository() {
        return new NacosEnvironmentRepository();
    }

}
