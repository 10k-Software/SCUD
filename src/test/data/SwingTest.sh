rm -rf ../../build/classes/*

javac -classpath ../../build/classes/ -d ../../build/classes/ ../../src/FAKES/scud/logic/GameLogic.java

javac -classpath ../../build/classes/ -d ../../build/classes/ ../../src/scud/app/ScudApp.java ../../src/scud/app/SwingUI.java ../../src/scud/app/ConsoleUI.java ../../src/scud/app/ScudUI.java

javac -classpath ../../build/classes/ -d ../../build/classes/ ../scud/app/SwingUITest.java

java -cp ../../lib/costello.jar junit.extensions.abbot.ScriptTestSuite SwingTest.xml