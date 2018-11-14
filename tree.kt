package datkt.flattree

class Tree {

  fun fullRoots(index: Long, result: Array<Long>?):  Array<Long> {
    if (0L != index % 2L) {
      println("error")
      // TODO: throw error
    }
    var localResult = arrayOf<Long>()
    if (null != result) {
      localResult = result
    }

    var localIndex: Long = index / 2
    var offset: Long = 0
    var factor: Long = 1

    while (true) {
      if (0L == localIndex) {
        return localResult
      }
      while (factor * 2L <= localIndex) {
        factor *= 2
      }

      localResult = localResult.plusElement(offset + factor - 1L)
      offset = offset + 2L * factor
      localIndex -= factor
      factor = 1L
    }
  }

  fun count(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return 1L
    }
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    return twoPow(localDepth + 1L) - 1L
  }

  fun parent(index: Long, depth: Long?): Long {
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    val offset = ftOffset(index, localDepth)

    return ftIndex(localDepth + 1L, rightShift(offset))
  }

  fun children(index: Long, depth: Long?): Array<Long> {
    if (0L == index % 2L) {
      return arrayOf<Long>()
    }
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    val offset = ftOffset(index, localDepth) * 2L
    return arrayOf<Long>(
      ftIndex(localDepth - 1L, offset),
      ftIndex(localDepth - 1L, offset + 1L)
    )
  }

  fun sibling(index: Long, depth: Long?): Long {
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    var offset = ftOffset(index, localDepth)
    var localOffset: Long
    if (0L == offset) {
      localOffset = offset + 1
    } else {
      localOffset = offset - 1
    }
    return ftIndex(localDepth, localOffset)
  }

  fun leftChild(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return -1L
    }
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    val offset =  ftOffset(index, localDepth) * 2L
    return ftIndex(localDepth - 1L, offset)
  }

  fun rightChild(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return -1L
    }
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    val offset =  ftOffset(index, localDepth) * 2L
    return ftIndex(localDepth - 1L, offset + 1L)
  }

  fun leftSpan(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return index
    }
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    val offset = ftOffset(index, localDepth)
    return offset * twoPow(localDepth + 1L)
  }

  fun rightSpan(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return index
    }
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }
    val offset = ftOffset(index, localDepth) + 1L
    return offset * twoPow(localDepth + 1L) - 2L
  }

  fun spans(index: Long, depth: Long?): Array<Long> {
    if (0L == index % 2L) {
      return arrayOf<Long>(index, index)
    }
    var localDepth: Long
    if (null == depth) {
      localDepth = ftDepth(index)
    } else {
      localDepth = depth
    }

    val offset = ftOffset(index, localDepth)
    val width = twoPow(localDepth + 1L)
    val left = offset * width
    val right = (offset + 1L) * width - 2L

    return arrayOf<Long>(left, right)
  }

}