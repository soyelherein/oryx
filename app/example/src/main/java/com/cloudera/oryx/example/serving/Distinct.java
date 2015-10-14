/*
 * Copyright (c) 2015, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */

package com.cloudera.oryx.example.serving;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

import com.cloudera.oryx.api.serving.OryxResource;

/**
 * Responds to a GET request to {@code /distinct}. Returns all distinct words and their count.
 */
@Path("/distinct")
public final class Distinct extends OryxResource {

  @GET
  @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
  public Map<String,Integer> get() {
    @SuppressWarnings("unchecked")
    ExampleServingModel model = (ExampleServingModel) getServingModelManager().getModel();
    return model.getWords();
  }

}