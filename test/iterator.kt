import flat_tree.*
import datkt.tape.*

fun main(args: Array<String>) {
  val tree = Tree()

  test("base blocks", fun(t: Test) {
    println("init")
    t.assert(0L == ft_index(0L, 0L), AssertionOptions( message = "0L == ft_index(0L, 0L)" ))
    t.assert(2L == ft_index(0L, 1L), AssertionOptions( message = "2L == ft_index(0L, 1L)" ))
    t.assert(4L == ft_index(0L, 2L), AssertionOptions( message = "4L == ft_index(0L, 2L)" ))

    t.end()
  })

  test("tree.parents", fun(t: Test) {
    t.assert(1L == ft_index(1L, 0L), AssertionOptions( message = "1L == ft_index(1L, 0L)" ))
    t.assert(5L == ft_index(1L, 1L), AssertionOptions( message = "5L == ft_index(1L, 1L)" ))
    t.assert(3L == ft_index(2L, 0L), AssertionOptions( message = "3L == ft_index(2L, 0L)" ))

    t.assert(1L == tree.parent(0L, 0L), AssertionOptions( message = "1L == tree.parent(0L, 0L)" ))
    t.assert(1L == tree.parent(2L, 0L), AssertionOptions( message = "1L == tree.parent(2L, 0L)" ))
    t.assert(3L == tree.parent(1L, 0L), AssertionOptions( message = "3L == tree.parent(1L, 0L)" ))

    t.end()
  })

  test("tree.children", fun(t: Test) {
    t.assert(null == tree.children(0L, null), AssertionOptions( message = "null == tree.children(0L, null)" ))
    t.assert(arrayOf(0L, 2L) == tree.children(1L, null), AssertionOptions( message = "arrayOf(0L, 2L) == tree.children(1L, null)" ))
    t.assert(arrayOf(1L, 5L) == tree.children(3L, null), AssertionOptions( message = "arrayOf(1L, 5L) == tree.children(3L, null)" ))
    t.assert(arrayOf(8L, 10L) == tree.children(9L, null), AssertionOptions( message = "arrayOf(8L, 10L) == tree.children(9L, null)" ))

    t.end()
  })

  test("tree.leftChild", fun(t: Test) {
    t.assert(-1L == tree.leftChild(0L, null), AssertionOptions( message = "-1L == tree.leftChild(0L, null)" ))
    t.assert(0L == tree.leftChild(1L, null), AssertionOptions( message = "0L == tree.leftChild(1L, null)" ))
    t.assert(1L == tree.leftChild(3L, null), AssertionOptions( message = "1L == tree.leftChild(3L, null)" ))

    t.end()
  })

  test("tree.rightChild", fun(t: Test) {
    t.assert(-1L == tree.rightChild(0L, null), AssertionOptions( message = "-1L == tree.rightChild(0L, null)" ))
    t.assert(2L == tree.rightChild(1L, null), AssertionOptions( message = "2L == tree.rightChild(1L, null)" ))
    t.assert(5L == tree.rightChild(3L, null), AssertionOptions( message = "5L == tree.rightChild(3L, null)" ))

    t.end()
  })

  test("tree.siblings", fun(t: Test) {
    t.assert(2L == tree.sibling(0L, null), AssertionOptions( message = "2L == tree.sibling(0L, null)" ))
    t.assert(0L == tree.sibling(2L, null), AssertionOptions( message = "0L == tree.sibling(2L, null)" ))
    t.assert(5L == tree.sibling(1L, null), AssertionOptions( message = "5L == tree.sibling(1L, null)" ))
    t.assert(1L == tree.sibling(5L, null), AssertionOptions( message = "1L == tree.sibling(5L, null)" ))

    t.end()
  })

  // test.skip("fullRoots", fun(t: Test) {
  //   t.assert(arrayOf<Long>() == tree.fullRoots(0L, null), AssertionOptions( message = "arrayOf<Long>() == tree.fullRoots(0L, null)" ))
  //   t.assert(arrayOf(0L) == tree.fullRoots(2L, null), AssertionOptions( message = "arrayOf(0L) == tree.fullRoots(2L, null)" ))
  //   t.assert(arrayOf(3L) == tree.fullRoots(8L, null), AssertionOptions( message = "arrayOf(3L) == tree.fullRoots(8L, null)" ))
  //   t.assert(arrayOf(7L, 17L) == tree.fullRoots(20L, null), AssertionOptions( message = "arrayOf(7L, 17L) == tree.fullRoots(20L, null)" ))
  //   t.assert(arrayOf(7L, 16L) == tree.fullRoots(18L, null), AssertionOptions( message = "arrayOf(7L, 16L) == tree.fullRoots(18L, null)" ))
  //   t.assert(arrayOf(7L) == tree.fullRoots(16L, null), AssertionOptions( message = "arrayOf(7L) == tree.fullRoots(16L, null)" ))

  //   t.end()
  // })

  test("ft_depth", fun(t: Test) {
    t.assert(0L == ft_depth(0L), AssertionOptions( message = "0L == ft_depth(0L)" ))
    t.assert(1L == ft_depth(1L), AssertionOptions( message = "1L == ft_depth(1L)" ))
    t.assert(0L == ft_depth(2L), AssertionOptions( message = "0L == ft_depth(2L)" ))
    t.assert(2L == ft_depth(3L), AssertionOptions( message = "2L == ft_depth(3L)" ))
    t.assert(0L == ft_depth(4L), AssertionOptions( message = "0L == ft_depth(4L)" ))

    t.end()
  })

  test("ft_offset", fun(t: Test) {
    t.assert(0L == ft_offset(0L, null), AssertionOptions( message = "0L == ft_offset(0L, null)" ))
    t.assert(0L == ft_offset(1L, null), AssertionOptions( message = "0L == ft_offset(1L, null)" ))
    t.assert(1L == ft_offset(2L, null), AssertionOptions( message = "1L == ft_offset(2L, null)" ))
    t.assert(0L == ft_offset(3L, null), AssertionOptions( message = "0L == ft_offset(3L, null)" ))
    t.assert(2L == ft_offset(4L, null), AssertionOptions( message = "2L == ft_offset(4L, null)" ))

    t.end()
  })

  test("tree.spans", fun(t: Test) {
    t.assert(arrayOf(0L, 0L) == tree.spans(0L, null), AssertionOptions( message = "arrayOf(0L, 0L) == tree.spans(0L, null)" ))
    t.assert(arrayOf(0L, 2L) == tree.spans(1L, null), AssertionOptions( message = "arrayOf(0L, 2L) == tree.spans(1L, null)" ))
    t.assert(arrayOf(0L, 6L) == tree.spans(3L, null), AssertionOptions( message = "arrayOf(0L, 6L) == tree.spans(3L, null)" ))
    t.assert(arrayOf(16L, 30L) == tree.spans(23L, null), AssertionOptions( message = "arrayOf(16L, 30L) == tree.spans(23L, null)" ))
    t.assert(arrayOf(24L, 30L) == tree.spans(27L, null), AssertionOptions( message = "arrayOf(24L, 30L) == tree.spans(27L, null)" ))

    t.end()
  })

  test("tree.leftSpan", fun(t: Test) {
    t.assert(0L == tree.leftSpan(0L, null), AssertionOptions( message = "0L == tree.leftSpan(0L, null)" ))
    t.assert(0L == tree.leftSpan(1L, null), AssertionOptions( message = "0L == tree.leftSpan(1L, null)" ))
    t.assert(0L == tree.leftSpan(3L, null), AssertionOptions( message = "0L == tree.leftSpan(3L, null)" ))
    t.assert(16L == tree.leftSpan(23L, null), AssertionOptions( message = "16L == tree.leftSpan(23L, null)" ))
    t.assert(24L == tree.leftSpan(27L, null), AssertionOptions( message = "24L == tree.leftSpan(27L)" ))

    t.end()
  })

  test("tree.rightSpan", fun(t: Test) {
    t.assert(0L == tree.rightSpan(0L, null), AssertionOptions( message = "0L == tree.rightSpan(0L, null)" ))
    t.assert(2L == tree.rightSpan(1L, null), AssertionOptions( message = "2L == tree.rightSpan(1L, null)" ))
    t.assert(6L == tree.rightSpan(3L, null), AssertionOptions( message = "6L == tree.rightSpan(3L, null)" ))
    t.assert(30L == tree.rightSpan(23L, null), AssertionOptions( message = "30L == tree.rightSpan(23L, null)" ))
    t.assert(30L == tree.rightSpan(27L, null), AssertionOptions( message = "30L == tree.rightSpan(27L, null)" ))

    t.end()
  })

  test("tree.count", fun(t: Test) {
    t.assert(1L == tree.count(0L, null), AssertionOptions( message = "1L == tree.count(0L, null)" ))
    t.assert(3L == tree.count(1L, null), AssertionOptions( message = "3L == tree.count(1L, null)" ))
    t.assert(7L == tree.count(3L, null), AssertionOptions( message = "7L == tree.count(3L, null)" ))
    t.assert(3L == tree.count(5L, null), AssertionOptions( message = "3L == tree.count(5L, null)" ))
    t.assert(15L == tree.count(23L, null), AssertionOptions( message = "15L == tree.count(23L, null)" ))
    t.assert(7L == tree.count(27L, null), AssertionOptions( message = "7L == tree.count(27L, null)" ))

    t.end()
  })

  test("parent > int32", fun(t: Test) {
    t.assert(10000000001L == tree.parent(10000000000L, null), AssertionOptions( message = "10000000001L == tree.parent(10000000000L)" ))
    t.end()
  })

  test("child to parent to child", fun(t: Test) {
    var child: Long = 0
    for (i in 0..50) child = tree.parent(child, null)
    t.assert(1125899906842623L == child, AssertionOptions( message = "1125899906842623L == child" ))
    for (j in 0..50) child = tree.leftChild(child, null)
    t.assert(0L == child, AssertionOptions( message = "0L == child" ))

    t.end()
  })

  test("iterator", fun(t: Test) {
    val iterator = Iterator(0L)

    t.assert(0L == iterator.index, AssertionOptions( message = "0L == iterator.index" ))
    t.assert(1L == iterator.parent(), AssertionOptions( message = "1L == iterator.parent()" ))
    t.assert(3L == iterator.parent(), AssertionOptions( message = "3L == iterator.parent()" ))
    t.assert(7L == iterator.parent(), AssertionOptions( message = "7L == iterator.parent()" ))
    t.assert(11L == iterator.rightChild(), AssertionOptions( message = "11L == iterator.rightChild()" ))
    t.assert(9L == iterator.leftChild(), AssertionOptions( message = "9L == iterator.leftChild()" ))
    println("iterator.next()")
    println(iterator.next())
    t.assert(13L == iterator.next(), AssertionOptions( message = "13L == iterator.next()" ))
    t.assert(12L == iterator.leftSpan(), AssertionOptions( message = "12L == iterator.leftSpan()" ))

    t.end()
  })

  test("iterator, non-leaf start", fun(t: Test) {
    val iterator = Iterator(1L)

    t.assert(1L == iterator.index, AssertionOptions( message = "1L == iterator.index" ))
    t.assert(3L == iterator.parent(), AssertionOptions( message = "3L == iterator.parent()" ))
    t.assert(7L == iterator.parent(), AssertionOptions( message = "7L == iterator.parent()" ))
    t.assert(11L == iterator.rightChild(), AssertionOptions( message = "11L == iterator.rightChild()" ))
    t.assert(9L == iterator.leftChild(), AssertionOptions( message = "9L == iterator.leftChild()" ))
    t.assert(13L == iterator.next(), AssertionOptions( message = "13L == iterator.next()" ))
    t.assert(12L == iterator.leftSpan(), AssertionOptions( message = "12L == iterator.leftSpan()" ))

    t.end()
  })

  datkt.tape.collect()
}
