package datkt.flattree.test

import datkt.flattree.Iterator
import datkt.tape.Test
import datkt.tape.test

fun iterator(argv: Array<String>) {
  test("iterator", fun(t: Test) {
    val iterator = Iterator(0L)

    t.equal(0L, iterator.index, "0L, iterator.index")
    t.equal(1L, iterator.parent(), "1L, iterator.parent()")
    t.equal(3L, iterator.parent(), "3L, iterator.parent()")
    t.equal(7L, iterator.parent(), "7L, iterator.parent()")
    t.equal(11L, iterator.rightChild(), "11L, iterator.rightChild()")
    t.equal(9L, iterator.leftChild(), "9L, iterator.leftChild()")
    t.equal(13L, iterator.next(), "13L, iterator.next()")
    t.equal(12L, iterator.leftSpan(), "12L, iterator.leftSpan()")

    t.end()
  })

  test("iterator, non-leaf start", fun(t: Test) {
    val iterator = Iterator(1L)

    t.equal(1L, iterator.index, "1L, iterator.index")
    t.equal(3L, iterator.parent(), "3L, iterator.parent()")
    t.equal(7L, iterator.parent(), "7L, iterator.parent()")
    t.equal(11L, iterator.rightChild(), "11L, iterator.rightChild()")
    t.equal(9L, iterator.leftChild(), "9L, iterator.leftChild()")
    t.equal(13L, iterator.next(), "13L, iterator.next()")
    t.equal(12L, iterator.leftSpan(), "12L, iterator.leftSpan()")

    t.end()
  })
}
