/*
 * Copyright (C) 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.alicloud.utils;

import org.powermock.api.mockito.PowerMockito;

import com.alibaba.cloud.context.edas.EdasChangeOrderConfiguration;
import com.alibaba.cloud.context.edas.EdasChangeOrderConfigurationFactory;

/**
 * @author Wujun
 */
public class ChangeOrderUtils {

	private ChangeOrderUtils() {
	}

	public static void mockChangeOrder() {
		EdasChangeOrderConfiguration edasChangeOrderConfiguration = PowerMockito
				.mock(EdasChangeOrderConfiguration.class);
		PowerMockito.when(edasChangeOrderConfiguration.isEdasManaged()).thenReturn(true);
		PowerMockito.when(edasChangeOrderConfiguration.getAddressServerDomain())
				.thenReturn("testDomain");
		PowerMockito.when(edasChangeOrderConfiguration.getTenantId())
				.thenReturn("testTenantId");
		PowerMockito.when(edasChangeOrderConfiguration.getDauthAccessKey())
				.thenReturn("testAK");
		PowerMockito.when(edasChangeOrderConfiguration.getDauthSecretKey())
				.thenReturn("testSK");
		PowerMockito.when(edasChangeOrderConfiguration.getProjectName())
				.thenReturn("testProjectName");
		PowerMockito.when(edasChangeOrderConfiguration.getAddressServerPort())
				.thenReturn("8080");
		PowerMockito.mockStatic(EdasChangeOrderConfigurationFactory.class);
		PowerMockito
				.when(EdasChangeOrderConfigurationFactory
						.getEdasChangeOrderConfiguration())
				.thenReturn(edasChangeOrderConfiguration);
	}
}
