package flat_tree

fun ft_index(depth: Long, offset: Long): Long {
  return (1L + 2L * offset) * twoPow(depth) - 1L
}

fun ft_depth(index: Long): Long {
  var local_index = index
  var depth: Long = 0

  local_index += 1
  while ( 0L == local_index % 2L ) {
    depth++
    local_index = rightShift(local_index)
  }

  return depth
}

fun ft_offset(index: Long, depth: Long?): Long {
  var os: Long
  var local_depth: Long
  if ( null == depth ) {
    local_depth = ft_depth(index)
  } else {
    local_depth = depth
  }
  os = ((index + 1L) / twoPow(local_depth) - 1L) / 2L
  if (0L == index % 2L) {
    os = index / 2L
  }
  return os
}

fun twoPow(n: Long): Long {
  var int_n: Int = n.toString().toInt()
  if (n < 31L) {
    val pow: Long = 1L shl int_n
    return pow
  } else {
    var int_b: Int = int_n - 30
    val powwow: Long = ((1L shl 30) * (1L shl int_b))
    return powwow
  }
}

fun rightShift(n: Long): Long {
  return (n - (n and 1)) / 2L
}