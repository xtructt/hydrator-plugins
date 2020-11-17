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

package io.cdap.plugin.db.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

/**
 * A MySQL {@link SocketFactory} that keeps track of the number of bytes written.
 */
public class SocketFactory implements com.mysql.jdbc.SocketFactory {
  private static final Logger LOG = LoggerFactory.getLogger(SocketFactory.class);
  private Socket socket;

  public Socket connect(String hostname, int portNumber, Properties props) throws IOException {
    LOG.error("In connect");
    socket = javax.net.SocketFactory.getDefault().createSocket(hostname, portNumber);
    return socket;
  }

  @Override
  public Socket beforeHandshake() {
    LOG.error("In beforeHandshake");
    return socket;
  }

  @Override
  public Socket afterHandshake() {
    LOG.error("In afterHandshake");
    return socket;
  }
}
