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

package io.cdap.cdap.metadata;

import com.google.inject.Inject;
import io.cdap.cdap.config.PreferencesService;
import io.cdap.cdap.gateway.handlers.PreferencesHttpHandlerInternal;
import io.cdap.cdap.proto.PreferencesDetail;
import io.cdap.cdap.proto.id.EntityId;

/**
 * Fetch preferences via REST API calls (using internal endpoint {@code INTERNAL_API_VERSION_3})
 * from {@link PreferencesHttpHandlerInternal}
 */
public class LocalPreferencesFetcherInternal implements PreferencesFetcher {

  private final PreferencesService preferencesService;

  @Inject
  public LocalPreferencesFetcherInternal(PreferencesService preferencesService) {
    this.preferencesService = preferencesService;
  }

  /**
   * Get preferences for the given identify
   */
  public PreferencesDetail get(EntityId entityId, boolean resolved) {
    PreferencesDetail detail = preferencesService.getPreferences();
    return detail;
  }
}

