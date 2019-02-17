all:
	javac $(shell find src -type f -name "*.java") -d bin

clean:
	rm -r bin/*