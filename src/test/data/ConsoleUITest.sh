# Test Script for ConsoleUI
# By Lisa Hunter
 	
#Compile the classes to test (ScudApp and ConsoleUI)
javac -d ./../../../src/scud/app/ ./../../../src/scud/app/ConsoleUI.java 
javac -d ./../../../src/scud/app/ ./../../../src/scud/app/ScudApp.java 

#Compile the fake classes (SwingUI and GameLogic)
javac -d ./../../../src/FAKES/scud/app/ ./../../../src/FAKES/scud/app/SwingUI.java 
javac -d ./../../../src/FAKES/scud/logic/ ./../../../src/FAKES/scud/logic/GameLogic.java 
 	
# Run the ScudApp so it calls the console and save the results
java  ./../../../src/scud/app/ScudApp -c < ConsoleUI.input > ConsoleUI.results
 	
# Compare results to the oracle
diff ConsoleUI.results ConsoleUI.oracle
