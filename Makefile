SRC=$(shell find src -regex '[^._].*\.java$$')
OBJ=$(patsubst src/%,bin/%,$(patsubst %.java,%.class,$(SRC)))
JAVA=java
JAVAC=javac

all : $(OBJ)

$(OBJ) : $(SRC)
	mkdir -p bin
	$(JAVAC) -cp lib/kiss.jar:bin -d bin -s src $(SRC)

clean :
	/bin/rm -rf bin/*

run  : all
	mkdir -p logs
	$(JAVA) -cp bin edu.coloradomesa.cs.singleton.SingletonExample
