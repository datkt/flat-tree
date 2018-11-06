KOTLINC = kotlinc

test: .
	$(KOTLINC) -r node_modules/@datkt -l tape/tape test/flattree.kt flattree.kt util.kt iterator.kt -o test -opt

library: .
	$(KOTLINC) flattree.kt iterator.kt util.kt -produce library -o flattree