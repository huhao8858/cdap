/*
 * Copyright © 2020 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.cdap.runtime.spi.runtimejob;

import org.apache.twill.api.TwillRunner;
import org.apache.twill.discovery.DiscoveryService;
import org.apache.twill.discovery.DiscoveryServiceClient;

import java.util.Map;

/**
 * Represents runtime job environment that provides information that is needed by the {@link RuntimeJob} to run the job.
 */
public interface RuntimeJobEnvironment {
  /**
   * Returns a {@link DiscoveryService} for service announcement purpose.
   */
  DiscoveryService getDiscoveryService();

  /**
   * Returns a {@link DiscoveryServiceClient} for service discovery purpose.
   */
  DiscoveryServiceClient getDiscoveryServiceClient();

  /**
   * Returns a {@link TwillRunner}.
   */
  TwillRunner getTwillRunner();

  /**
   * Returns runtime environment properties to be available to {@link RuntimeJob}.
   */
  Map<String, String> getProperties();
}
