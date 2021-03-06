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

package com.google.openbidder.ui.util.json;

import com.google.openbidder.ui.resource.support.InstanceType;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Custom serializer for {@link InstanceType} instances, required because the default
 * {@link com.fasterxml.jackson.databind.ser.std.MapSerializer} does a simple
 * {@link #toString()}, ignoring any {@link com.fasterxml.jackson.annotation.JsonValue}
 * annotations.
 */
public class InstanceTypeSerializer extends JsonSerializer<InstanceType> {

  @Override
  public void serialize(
      InstanceType value,
      JsonGenerator jgen,
      SerializerProvider provider) throws IOException {

    jgen.writeFieldName(value == null ? null : value.getInstanceType());
  }
}
