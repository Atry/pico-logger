//   Copyright 2011 杨博
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.dongxiguo.utils

import org.slf4j.Logger
import org.slf4j.Marker

private object PicoLogger {
  private val DummyFunction = { (_: () => String) => }
  private val DummyMarkerFunction = { (_: Marker, _: () => String) => }
  private val DummyThrowableFunction = { (_: () => String, _: Throwable) => }
}

/**
 * @author 杨博<pop.atry@gmail.com>
 */
class PicoLogger(val logger: Logger) {
  import PicoLogger._

  private val traceFunction =
    if(logger.isTraceEnabled) { (msg: () => String) =>
      logger.trace(msg())
    } else DummyFunction

  final def trace(msg: => String) {
    traceFunction(msg _)
  }

  private val traceThrowableFunction =
    if(logger.isTraceEnabled) { (msg: () => String, throwable: Throwable) =>
      logger.trace(msg(), throwable)
    } else DummyThrowableFunction

  final def trace(msg: => String, throwable: Throwable) {
    traceThrowableFunction(msg _, throwable)
  }

  private val traceMarkerFunction =
    if(logger.isTraceEnabled) { (marker: Marker, msg: () => String) =>
      logger.trace(marker, msg())
    } else DummyMarkerFunction

  final def trace(marker: Marker, msg: => String) {
    traceMarkerFunction(marker, msg _)
  }

  private val debugFunction =
    if(logger.isDebugEnabled) { (msg: () => String) =>
      logger.debug(msg())
    } else DummyFunction

  final def debug(msg: => String) {
    debugFunction(msg _)
  }

  private val debugThrowableFunction =
    if(logger.isDebugEnabled) { (msg: () => String, throwable: Throwable) =>
      logger.debug(msg(), throwable)
    } else DummyThrowableFunction

  final def debug(msg: => String, throwable: Throwable) {
    debugThrowableFunction(msg _, throwable)
  }

  private val debugMarkerFunction =
    if(logger.isDebugEnabled) { (marker: Marker, msg: () => String) =>
      logger.debug(marker, msg())
    } else DummyMarkerFunction

  final def debug(marker: Marker, msg: => String) {
    debugMarkerFunction(marker, msg _)
  }

  private val infoFunction =
    if(logger.isInfoEnabled) { (msg: () => String) =>
      logger.info(msg())
    } else DummyFunction

  final def info(msg: => String) {
    infoFunction(msg _)
  }

  private val infoThrowableFunction =
    if(logger.isInfoEnabled) { (msg: () => String, throwable: Throwable) =>
      logger.info(msg(), throwable)
    } else DummyThrowableFunction

  final def info(msg: => String, throwable: Throwable) {
    infoThrowableFunction(msg _, throwable)
  }

  private val infoMarkerFunction =
    if(logger.isInfoEnabled) { (marker: Marker, msg: () => String) =>
      logger.info(marker, msg())
    } else DummyMarkerFunction

  final def info(marker: Marker, msg: => String) {
    infoMarkerFunction(marker, msg _)
  }

  private val warnFunction =
    if(logger.isWarnEnabled) { (msg: () => String) =>
      logger.warn(msg())
    } else DummyFunction

  final def warn(msg: => String) {
    warnFunction(msg _)
  }

  private val warnThrowableFunction =
    if(logger.isWarnEnabled) { (msg: () => String, throwable: Throwable) =>
      logger.warn(msg(), throwable)
    } else DummyThrowableFunction

  final def warn(msg: => String, throwable: Throwable) {
    warnThrowableFunction(msg _, throwable)
  }

  private val warnMarkerFunction =
    if(logger.isWarnEnabled) { (marker: Marker, msg: () => String) =>
      logger.warn(marker, msg())
    } else DummyMarkerFunction

  final def warn(marker: Marker, msg: => String) {
    warnMarkerFunction(marker, msg _)
  }

  private val errorFunction =
    if(logger.isErrorEnabled) { (msg: () => String) =>
      logger.error(msg())
    } else DummyFunction

  final def error(msg: => String) {
    errorFunction(msg _)
  }

  private val errorThrowableFunction =
    if(logger.isErrorEnabled) { (msg: () => String, throwable: Throwable) =>
      logger.error(msg(), throwable)
    } else DummyThrowableFunction

  final def error(msg: => String, throwable: Throwable) {
    errorThrowableFunction(msg _, throwable)
  }

  private val errorMarkerFunction =
    if(logger.isErrorEnabled) { (marker: Marker, msg: () => String) =>
      logger.error(marker, msg())
    } else DummyMarkerFunction

  final def error(marker: Marker, msg: => String) {
    errorMarkerFunction(marker, msg _)
  }

}