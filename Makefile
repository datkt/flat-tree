KOTLINC = kotlinc

OS ?= $(shell uname)



test: .
	$(KOTLINC) -r node_modules/@datkt -l tape/tape test/iterator.kt iterator.kt util.kt tree.kt -o test -opt


