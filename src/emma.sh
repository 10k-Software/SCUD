java -cp lib/emma.jar:build/classes/ emma instr -ip build/classes/ -m overwrite -filter -*Test -filter -junit*

java -cp lib/emma.jar:lib/junit-4.1.jar:lib/costello.jar:build/classes/ junit.extensions.abbot.ScriptTestSuite test/data/IntSwingTest.xml

java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ scud.app.ScudApp Testlevel.xml -c < test/data/ConsoleUITest.input.real

java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ junit.textui.TestRunner scud.logic.GameLogicTest
java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ junit.textui.TestRunner scud.data.EnvironmentLibraryTest
java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ junit.textui.TestRunner scud.data.ActionTest
java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ junit.textui.TestRunner scud.parser.LevelParserTest
java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ junit.textui.TestRunner scud.data.PlayerTest
java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ junit.textui.TestRunner scud.data.RoomTest
java -cp lib/emma.jar:lib/junit-4.1.jar:build/classes/ junit.textui.TestRunner scud.data.PlayerTest

java -cp lib/emma.jar emma report -r html -in coverage.em -in coverage.ec -sp src
