KOTLINC = kotlinc

OS ?= $(shell uname)



test: .
	$(KOTLINC) . -l tape -o test -opt