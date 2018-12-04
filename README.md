datkt.flattree
==============

Port of @mafintosh's flat-tree functions to map a binary tree to a list.

## Installation

The `datkt.flattree` package an be installed with NPM.

```sh
$ npm install @datkt/flattree
```

## Prerequisites

- [Kotlin/Native](https://github.com/JetBrains/kotlin-native) and the
  `konanc` command line program.
- `@datkt/konanc-config`

## Usage

```sh
## Compile a program in 'main.kt' and link flattree libraries found in `node_modules/`
$ konanc main.kt $(konanc-config -clr @datkt/flattree) -o main.kexe
$ ./main.kexe
```

where `main.kt` might be

```kotlin
import datkt.flattree.*

fun main(args: Array<String>) {
  val tree = Tree()
  tree.parent(0L, null) // 1L
  tree.parent(2L, null) // 1L
  tree.parent(1L, null) // 3L
}
```

## API

### `index = ftIndex(depth: Long, offset: Long): Long`

Returns an array index for the tree element at the given depth and offset

### `parentIndex = tree.parent(index: Long, depth: Long?): Long`

Returns the index of the parent element in tree

### `siblingIndex = tree.sibling(index: Long, depth: Long?): Long`

Returns the index of this elements sibling

### `children = tree.children(index: Long, depth: Long?): Array<Long>`

Returns an array `[leftChild, rightChild]` with the indexes of this elements children.
If this element does not have any children it returns `null`

### `range = tree.spans(index: Long, depth: Long?): Array<Long>`

Returns the range (inclusive) the tree root at `index` spans.
For example `tree.spans(3)` would return `[0, 6]` (see the usage example).

### `index = tree.leftSpan(index: Long, depth: Long?): Long`

Returns the left spanning in index in the tree `index` spans.

### `index = tree.rightSpan(index: Long, depth: Long?): Long`

Returns the right spanning in index in the tree `index` spans.

### `count = tree. count(index: Long, depth: Long?): Long`

Returns how many nodes (including parent nodes) a tree contains

### `depth = ftDepth(index: Long): Long`

Returns the depth of an element

### `offset = ftOffset(index: Long, depth: Long?): Long`

Returns the relative offset of an element

### `roots = tree.fullRoots(index: Long, result: Array<Long>?):  Array<Long>`

Returns a list of all the full roots (subtrees where all nodes have either 2 or 0 children) `<` index.
For example `fullRoots(8)` returns `[3]` since the subtree rooted at `3` spans `0 -> 6` and the tree
rooted at `7` has a child located at `9` which is `>= 8`.

### `index = iterator.next(): Long`

Move the iterator the next item in the tree.

### `index = iterator.prev(): Long`

Move the iterator the prev item in the tree.

### `iterator.seek(index: Long)`

Move the iterator the this specific tree index.

### `index = iterator.parent(): Long`

Move the iterator to the current parent index

### `index = iterator.leftChild(): Long`

Move the iterator to the current left child index.

### `index = iterator.rightChild(): Long`

Move the iterator to the current right child index.

### `index = iterator.leftSpan(): Long`

Move the iterator to the current left span index.

### `index = iterator.rightSpan(): Long`

Move the iterator to the current right span index.

### `bool = iterator.isLeft(): Boolean`

Is the iterator at a left sibling?

### `bool = iterator.isRight(): Boolean`

Is the iterator at a right sibling?

### `index = iterator.sibling(): Long`

Move the iterator to the current sibling

## See Also

* https://github.com/mafintosh/flat-tree

## License

MIT
