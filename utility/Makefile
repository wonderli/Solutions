all: libutil.a
libutil.a: util.o
	ar rcs libutil.a util.o
util.o: util.h util.c
	gcc -c util.h util.c
clean:
	rm -rf util.o libutil.a *~ *.gch


