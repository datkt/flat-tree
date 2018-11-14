package datkt.flattree.test

import datkt.flattree.computeIndex
import datkt.flattree.computeDepth
import datkt.flattree.computeOffset
import datkt.tape.Test
import datkt.tape.test

fun util(argv: Array<String>) {
  test("base blocks", fun(t: Test) {
    t.equal(0L, computeIndex(0L, 0L), "0L, computeIndex(0L, 0L)")
    t.equal(2L, computeIndex(0L, 1L), "2L, computeIndex(0L, 1L)")
    t.equal(4L, computeIndex(0L, 2L), "4L, computeIndex(0L, 2L)")

    t.equal(1L, computeIndex(1L, 0L), "1L, computeIndex(1L, 0L)")
    t.equal(5L, computeIndex(1L, 1L), "5L, computeIndex(1L, 1L)")
    t.equal(3L, computeIndex(2L, 0L), "3L, computeIndex(2L, 0L)")

    t.end()
  })

  test("computeDepth", fun(t: Test) {
    t.equal(0L, computeDepth(0L), "0L, computeDepth(0L)")
    t.equal(1L, computeDepth(1L), "1L, computeDepth(1L)")
    t.equal(0L, computeDepth(2L), "0L, computeDepth(2L)")
    t.equal(2L, computeDepth(3L), "2L, computeDepth(3L)")
    t.equal(0L, computeDepth(4L), "0L, computeDepth(4L)")

    t.end()
  })

  test("computeOffset", fun(t: Test) {
    t.equal(0L, computeOffset(0L, null), "0L, computeOffset(0L, null)")
    t.equal(0L, computeOffset(1L, null), "0L, computeOffset(1L, null)")
    t.equal(1L, computeOffset(2L, null), "1L, computeOffset(2L, null)")
    t.equal(0L, computeOffset(3L, null), "0L, computeOffset(3L, null)")
    t.equal(2L, computeOffset(4L, null), "2L, computeOffset(4L, null)")

    t.end()
  })
}
