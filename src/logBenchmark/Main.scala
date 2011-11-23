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

package logBenchmark

import org.slf4j.LoggerFactory
import com.dongxiguo.utils.PicoLogger

class Main

/**
 * @author 杨博<pop.atry@gmail.com>
 */
final object Main extends PicoLogger(LoggerFactory.getLogger(classOf[Main])) {
  private final val NumRepeats = 10000000

  private def benchmarkIntFast(p1: Int, p2: Int) {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      info("aa " + p1 + " " + p2)
      i += 1
    }
    println("PicoLogger with Int parameters:          " + (System.nanoTime() - start))
  }

  private def benchmarkLogback(p1: String, p2: String) {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      logger.info("aa {} {}", p1, p2)
      i += 1
    }
    println("slf4j with String parameters:            " + (System.nanoTime() - start))
  }

  private def benchmarkLiteralLogback() {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      logger.info("log literal")
      i += 1
    }
    println("slf4j with string literal:               " + (System.nanoTime() - start))
  }

  private def benchmarkIntLogback(p1: Int, p2: Int) {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      logger.info("aa {} {}", p1, p2)
      i += 1
    }
    println("slf4j with Int parameters:               " + (System.nanoTime() - start))
  }

  private def benchmarkLiteralFast() {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      info("log literal")
      i += 1
    }
    println("PicoLogger with string literal:          " + (System.nanoTime() - start))
  }
  private def benchmarkLiteralFast10() {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      // Zero overhead
      info("log literal")
      info("log literal")
      info("log literal")
      info("log literal")
      info("log literal")
      info("log literal")
      info("log literal")
      info("log literal")
      info("log literal")
      info("log literal")
      i += 1
    }
    println("PicoLogger with string literal 10 times: " + (System.nanoTime() - start))
  }

  private def benchmarkMultiLogback(p1: Int, p2: Double, p3: String, p4: Null, p5: Long) {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      logger.info("aa {} {} {} {} {}", Array(p1, p2, p3, p4, p5))
      i += 1
    }
    println("slf4j with multi-parameters:             " + (System.nanoTime() - start))
  }

  final def dummy(p1: String, p2: String) { }
  private def benchmarkMultiFast(p1: Int, p2: Double, p3: String, p4: Null, p5: Long) {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      info("aa " + p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5)
      i += 1
    }
    println("PicoLogger with multi-parameter:         " + (System.nanoTime() - start))
  }

  private def benchmarkFast(p1: String, p2: String) {
    val start = System.nanoTime()
    var i = 0

    while (i < NumRepeats) {
      info("aa " + p1 + " " + p2)
      i += 1
    }
    println("PicoLogger with String parameters:       " + (System.nanoTime() - start))
  }


  private def benchmarkDummy(p1: String, p2: String) {
    val start = System.nanoTime()
    var i = 0
    while (i < NumRepeats) {
      dummy(p1, p2)
      i += 1
    }
    println("dummy: " + (System.nanoTime() - start))
  }

  private def benchmarkFor(p1: String, p2: String) {
    val start = System.nanoTime()
    for (_ <- 0 until NumRepeats)
      dummy(p1, p2)
    println("dummy in for: " + (System.nanoTime() - start))
  }


  def main(args: Array[String]) {
    assert(args.length == 0)
    assert(throw new Exception)
    for (i <- 0 until 5) {
      println("repeated " + NumRepeats + " times:")
      println()
      benchmarkLogback("xxx", "1423")
      benchmarkFast("xxx", "1423")
      println()
      benchmarkLiteralLogback()
      benchmarkLiteralFast()
      benchmarkLiteralFast10()
      println()
      benchmarkIntLogback(12345, 54321)
      benchmarkIntFast(12345, 54321)
      println()
      benchmarkMultiLogback(12345, 5.4321, "Good", null, 1234567890123L)
      benchmarkMultiFast(12345, 5.4321, "Good", null, 1234567890123L)
      println()
      benchmarkDummy("xxx", "1423")
      benchmarkFor("xxx", "1423")
      println(Stream.fill(79)('-').mkString)
    }
  }
}
