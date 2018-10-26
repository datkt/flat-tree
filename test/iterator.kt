import flat_tree.*
import tape.*

const val TAP_VERSION = 13
const val TAP_HEADER = "TAP version ${TAP_VERSION}"

typealias OK = (ok: Boolean?, comment: String?) -> Unit?

fun main(args: Array<String>) {
  println(TAP_HEADER)

  val iterator = Iterator(0L)

  println("_")
  println(iterator.index)
  println(iterator.offset)
  println(iterator.factor)
  iterator.seek(107L)

  println("_")
  println( truthy(true == iterator.isLeft()) )
  println( truthy(false == iterator.isRight()) )
  println(iterator.index)
  println(iterator.offset)
  println(iterator.factor)
  iterator.seek(1L)

  println("_")
  println( truthy(true == iterator.isLeft()) )
  println( truthy(false == iterator.isRight()) )
  println(iterator.index)
  println(iterator.offset)
  println(iterator.factor)

  println("hi")
}