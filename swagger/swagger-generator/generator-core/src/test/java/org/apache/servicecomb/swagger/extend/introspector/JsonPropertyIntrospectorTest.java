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

package org.apache.servicecomb.swagger.extend.introspector;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonPropertyIntrospectorTest {

  @Test
  public void findEnumValue() {
    JsonPropertyIntrospector introspector = new JsonPropertyIntrospector();

    assertEquals("AB", introspector.findEnumValue(TestEnum.AB));
    assertEquals("C-D", introspector.findEnumValue(TestEnum.C_D));
    assertEquals("E.F", introspector.findEnumValue(TestEnum.E_F));
    assertEquals("HI", introspector.findEnumValue(TestEnum.HI));
  }

  public enum TestEnum {
    AB,
    @JsonProperty(value = "C-D")
    C_D,
    @JsonProperty(value = "E.F")
    E_F,
    @JsonProperty
    HI
  }
}
