loxun: build
    java -cp bin/loxun src/com/mikolaszko/loxun/*java

build: bin
    javac -d bin/loxun src/com/mikolaszko/loxun/*.java

clean:
    @rm -rf bin

bin:
    @mkdir -p bin/loxun