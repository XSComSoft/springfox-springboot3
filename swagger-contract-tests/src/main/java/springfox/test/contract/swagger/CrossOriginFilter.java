/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package springfox.test.contract.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Allows cross origin for testing swagger docs using swagger-ui from local file system
 */
@Component
public class CrossOriginFilter implements Filter {
  private static final Logger LOGGER = LoggerFactory.getLogger(CrossOriginFilter.class);

  @Override
  public void doFilter(
      ServletRequest req,
      ServletResponse resp,
      FilterChain chain) throws IOException,
      ServletException {

    LOGGER.debug("Applying CORS filter");
    HttpServletResponse response = (HttpServletResponse) resp;
    response.setHeader(
        "Access-Control-Allow-Origin",
        "*");
    response.setHeader(
        "Access-Control-Allow-Methods",
        "POST, GET, OPTIONS, DELETE");
    response.setHeader(
        "Access-Control-Max-Age",
        "0");
    chain.doFilter(
        req,
        resp);
  }
}