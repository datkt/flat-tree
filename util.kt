package datkt.flattree

fun computeIndex(depth: Long, offset: Long): Long {
  return (1L + 2L * offset) * twoPow(depth) - 1L
}

fun computeDepth(index: Long): Long {
  var localIndex = index
  var depth: Long = 0

  localIndex += 1
  while ( 0L == localIndex % 2L ) {
    depth++
    localIndex = rightShift(localIndex)
  }

  return depth
}

fun computeOffset(index: Long, depth: Long?): Long {
  var os: Long
  var localDepth: Long
  if ( null == depth ) {
    localDepth = computeDepth(index)
  } else {
    localDepth = depth
  }
  os = ((index + 1L) / twoPow(localDepth) - 1L) / 2L
  if (0L == index % 2L) {
    os = index / 2L
  }
  return os
}

fun twoPow(n: Long): Long {
  var num1: Int = n.toString().toInt()
  if (n < 31L) {
    val pow: Long = 1L shl num1
    return pow
  } else {
    var num2: Int = num1 - 30
    val powwow: Long = ((1L shl 30) * (1L shl num2))
    return powwow
  }
}

fun rightShift(n: Long): Long {
  return (n - (n and 1)) / 2L
}
