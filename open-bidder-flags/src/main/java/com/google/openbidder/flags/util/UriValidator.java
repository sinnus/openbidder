/*
 * Copyright 2013 Google Inc. All Rights Reserved.
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

package com.google.openbidder.flags.util;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Validate that a parameter is a URL.
 */
public class UriValidator implements IParameterValidator {

  @SuppressWarnings("unused")
  @Override
  public void validate(String name, String value) throws ParameterException {
    try {
      new URI(value);
    } catch (URISyntaxException e) {
      throw new ParameterException("Parameter " + name + " is not a URL (" + value + ")");
    }
  }
}