
import utest.asserts._
import utest.framework.{Test, TestTreeSeq}
import utest.framework.Tree
import acyclic.file
import scala.concurrent.duration._

/**
 * Created by haoyi on 1/24/14.
 */
package object utest extends _root_.utest.asserts.Asserts{
  implicit val retryInterval = new RetryInterval(100.millis)
  implicit val retryMax = new RetryMax(1.second)
  import scala.language.experimental.macros


  /**
   * Extension methods to allow you to create tests via the "omg"-{ ... }
   * syntax.
   */

  implicit class TestableString(s: String){
    /**
     * Used to demarcate tests with the `TestSuite{ ... }` block. Has no
     * meaning outside that block
     */
    @reflect.internal.annotations.compileTimeOnly("String#- method should only be used directly inside a TestSuite{} macro")
    def -(x: => Any) = ???
  }

  implicit class TestableSymbol(s: Symbol){
    /**
     * Used to demarcate tests with the `TestSuite{ ... }` block. Has no
     * meaning outside that block
     */
    @reflect.internal.annotations.compileTimeOnly("String#- method should only be used directly inside a TestSuite{} macro")
    def apply(x: => Any) = ???
    /**
     * Used to demarcate tests with the `TestSuite{ ... }` block. Has no
     * meaning outside that block
     */
    @reflect.internal.annotations.compileTimeOnly("String#- method should only be used directly inside a TestSuite{} macro")
    def -(x: => Any) = ???
  }

  /**
   * Extension methods on `Tree[Test]` in order to conveniently run the tests
   * and aggregate the results
   */
  implicit def toTestSeq(t: Tree[Test]) = new TestTreeSeq(t)

  val TestSuite = framework.TestSuite
  type TestSuite  = framework.TestSuite
  
  /**
   * Placeholder object used to declare test cases which you don't want to 
   * bother naming. These test cases are named with sequential numbers 
   * starting from "0", "1", "2", etc.
   */
  object * { 
    /**
     * Declares a numbered test-case
     */
    def -(x: => Any) = ???
  }

}
