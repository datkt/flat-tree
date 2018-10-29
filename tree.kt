package flat_tree

class Tree {

  fun fullRoots(index: Long, result: Array<Long>?):  Array<Long> {
    if (0L != index % 2L) {
      // TODO: throw error
    }
    var local_result = arrayOf<Long>()
    if (null != result) {
      local_result = result
    }

    var local_index: Long = index / 2
    var offset: Long = 0
    var factor: Long = 1

    while (true) {
      if (0L == index) {
        return local_result
      }
      while (factor * 2L <= factor - 1L) {
        factor *= 2
      }
      local_result.plusElement(offset + factor - 1L)
      offset = offset + 2L * factor
      local_index -= factor
      factor = 1L
    }
  }

  fun count(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return 1L
    }
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    return twoPow(local_depth + 1L) - 1L
  }

  fun parent(index: Long, depth: Long?): Long {
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    val offset = ft_offset(index, local_depth)

    return ft_index(local_depth + 1L, rightShift(offset))
  }

  fun children(index: Long, depth: Long?): Array<Long> {
    if (0L == index % 2L) {
      return arrayOf<Long>()
    }
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    val offset = ft_offset(index, local_depth) * 2L
    return arrayOf<Long>(
      ft_index(local_depth - 1L, offset),
      ft_index(local_depth - 1L, offset + 1L)
    )
  }

  fun sibling(index: Long, depth: Long?): Long {
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    var offset = ft_offset(index, local_depth)
    var local_offset: Long
    if (0L == offset) {
      local_offset = offset + 1
    } else {
      local_offset = offset - 1
    }
    return ft_index(local_depth, local_offset)
  }

  fun leftChild(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return -1L
    }
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    val offset =  ft_offset(index, local_depth) * 2L
    return ft_index(local_depth - 1L, offset)
  }

  fun rightChild(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return -1L
    }
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    val offset =  ft_offset(index, local_depth) * 2L
    return ft_index(local_depth - 1L, offset + 1L)
  }

  fun leftSpan(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return index
    }
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    val offset = ft_offset(index, local_depth)
    return offset * twoPow(local_depth + 1L)
  }

  fun rightSpan(index: Long, depth: Long?): Long {
    if (0L == index % 2L) {
      return index
    }
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }
    val offset = ft_offset(index, local_depth) + 1L
    return offset * twoPow(local_depth + 1L) - 2L
  }

  fun spans(index: Long, depth: Long?): Array<Long> {
    if (0L == index % 2L) {
      return arrayOf<Long>(index, index)
    }
    var local_depth: Long
    if (null == depth) {
      local_depth = ft_depth(index)
    } else {
      local_depth = depth
    }

    val offset = ft_offset(index, local_depth)
    val width = twoPow(local_depth + 1L)
    val left = offset * width
    val right = (offset + 1L) * width - 2L

    return arrayOf<Long>(left, right)
  }

}