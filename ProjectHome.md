这是给Scala打日志的工具类，需要配合slf4j使用。比直接使用slf4j快得多！

如果一条log没被过滤掉，需要实际IO输出，用pico-logger和用slf4j一样快。但是slf4j打一条复杂log时，即使被过滤掉了，也需要消耗上百纳秒，而pico-logger过滤掉log时一纳秒都不浪费。无论多复杂的log，pico-logger在JVM优化后执行时间都不超过2个时钟周期，在我2.1GHz的CPU上只要952皮秒，一纳秒都不到。如果传给pico-logger的参数是没有额外变量的字符串字面量，执行时间为零。

用法：
```
object Foo extends PicoLogger(org.slf4j.LoggerFactory.getLogger(classOf[Foo]))
{
  def foo() {
    // 用PicoLogger，当trace级别被禁用时，零执行时间
    trace("string literal")
    
    // 用org.slf4j.Logger，当trace级别被禁用时，消耗4纳秒左右。不同后端性能稍有差异。
    logger.trace("string literal")
  }

  def bar(p1: Int, p2: Double, p3: Long, p4: Byte, p5: Boolean) {
    // 用PicoLogger，当trace级别被禁用时，2个时钟周期，在2GHz以上的CPU时不到1纳秒
    trace("p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + ", p5=" + p5)
    
    // 用org.slf4j.Logger，当trace级别被禁用时，消耗约100纳秒
    logger.trace("p1={},p2={},p3={},p4={},p5={}", Array(p1, p2, p3, p4, p5))
  }
}
```
还在用Java打日志的渣滓们，在我pico-logger的淫威下颤抖吧。