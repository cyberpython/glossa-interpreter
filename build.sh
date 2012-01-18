#!/usr/bin/env sh
ant clean jar #build the project
mkdir dist/lib #create a lib directory inside the dist directory
cp lib/* dist/lib/ #copy the libraries to the dist/lib directory
mv dist/Glossa.jar dist/glossa-interpreter.jar #rename the jar file
