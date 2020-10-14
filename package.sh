#!/bin/sh
javac src/*.java -d ./out
echo 'Main-Class: Window' >>out/manifest.txt
cd out
mkdir release
jar cfm release/DrawBoard.jar manifest.txt *.class
