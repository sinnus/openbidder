/*
 * Copyright 2012 Google Inc. All Rights Reserved.
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

package com.google.openbidder.ui.user.exception;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * No credentials been found for the given project.
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NoCredentialsForProjectException extends RuntimeException {

  private static final String MESSAGE =
      "No OAuth 2.0 credentials found for user %s on project %d";

  private final long projectId;
  private final String userEmail;

  public NoCredentialsForProjectException(long projectId, String userEmail) {
    super(String.format(MESSAGE, checkNotNull(userEmail), projectId));
    this.userEmail = userEmail;
    this.projectId = projectId;
  }

  public long getProjectId() {
    return projectId;
  }

  public String getUserEmail() {
    return userEmail;
  }
}
