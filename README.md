### Animation Generator
Input text files contain details of shapes that would be used to convert them into animations
1.  Details of the shapes that needs to be constructed are provided in the text files
2. And the transformations that need to be performed on the shapes 
	a. Movement from one coordinate to another in the animation
	b. Scaling the shapes size (Making then bigger or smaller in the animations
	c. Color changes to the shape during animation	
3. Animation generated from text input can be played, stopped and restarted 
4. All the shapes in the animation can be viewed and selected shapes can be removed from the animation
5. Clicking on File->Save tabs on top-left corner allows to save the animation in text format

### Application Screenshots
![StartScreen](/Animation-Generator/Capture_1.png?)



### Steps for Running the application through Intellij Idea IDE

1. Download the project files, unzip and use Open Project option in IntelliJ
2. In Edit Configurations -- Program Arguments --- add the following

```
-in big-bang-big-crunch.txt -speed 50 -view visual
```

### Steps for Running the application through JAR executable file (Animation-Genearator.jar) given in repo:

1. Open Command Line and change file location to where JAR file is located on your computer
2. Run the following command:

```
java -jar Animation-Generator.jar -in big-bang-big-crunch.txt -speed 50 -view visual
```

### Input Text Files
1. The name of the input text file can be changed to any of the text files given in the repo
	a. hanoi.txt
	b. toh-3.txt
	c. toh-5.txt
	d. toh-8.txt
	e. toh-12.txt
	f. buildings.txt
	g. smalldemo.txt
	
### Input Arguments
Besides providing name of the text file,  we have two more arguments
1. speed of the animation (50 recommended)
2. view : 
	visual : Animation would be played in Java GUI window (
	java -jar Animation-Generator.jar -in big-bang-big-crunch.txt -speed 50 -view visual
		
	text   : Animation could be viewed in text format on the terminal 
	java -jar Animation-Generator.jar -in big-bang-big-crunch.txt -speed 50 -view text
	
		  

          
