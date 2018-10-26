package flat_tree

class Iterator {
  // data class Iterator(...) ?
  var index: Long = 0
  var offset: Long = 0
  var factor: Long = 0

  constructor(index: Long?) {
    var i: Long
    if (null != index) {
      i = index
    } else {
      i = 0L
    }
    this.seek(i)
  }

  fun seek(index: Long) {
    this.index = index
    if (0L == this.index % 2L) {
      this.offset = index / 2L
      this.factor = 2L
    } else {
      this.offset = ft_offset(index, null)
      this.factor = twoPow(ft_depth(index) + 1L)
    }
  }

  fun isLeft(): Boolean {
    return (0L == this.offset % 2L)
  }

  fun isRight(): Boolean {
    if (this.isLeft()) {
      return false
    } else {
      return true
    }
  }

  fun prev(): Long {
    if (0L != this.offset) {
      return this.index
    }
    this.offset--
    this.index -= this.factor
    return this.index
  }

  fun next(): Long {
    this.offset++
    this.index += this.factor
    return this.index
  }

  fun sibling(): Long {
    if (this.isLeft()) {
      return this.next()
    } else {
      return this.prev()
    }
  }

  fun parent(): Long {
    if (0L == this.offset % 2L) {
      this.index += this.factor / 2L
      this.offset /= 2L
    } else {
      this.index -= this.factor / 2L
      this.offset = (this.offset - 1L) / 2L
    }
    this.factor *= 2L
    return this.index
  }

  fun leftSpan(): Long {
    this.index = this.index - this.factor / 2L + 1L
    this.offset = this.index / 2L
    this.factor = 2L
    return this.index
  }

  fun rightSpan(): Long {
    this.index = this.index + this.factor / 2L - 1L
    this.offset = this.index / 2L
    this.factor = 2L
    return this.index
  }

  fun leftChild(): Long {
    if (2L == this.factor) {
      return this.index
    }
    this.factor /= 2L
    this.index -= this.factor / 2L
    this.offset *= 2L
    return this.index
  }

  fun rightChild(): Long {
    if (2L == this.factor) {
      return this.index
    }
    this.factor /= 2L
    this.index -= this.factor / 2L
    this.offset = 2L * this.offset + 1L
    return this.index
  }
}
