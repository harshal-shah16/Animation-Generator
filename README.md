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
Start Screen
![image](https://user-images.githubusercontent.com/29174853/103982832-41eab100-5152-11eb-921c-0f13387148bb.png)

Playing Animation
![image](https://user-images.githubusercontent.com/29174853/103983205-da813100-5152-11eb-8311-7a6b7f66b806.png)


Following are GIFs of some animations that can run through the applications. Input text files provided in the repo


![big-bang-big-crunch](https://user-images.githubusercontent.com/29174853/103983407-2fbd4280-5153-11eb-82ab-b90e27899cb1.gif)

![night](https://user-images.githubusercontent.com/29174853/103983557-71e68400-5153-11eb-8614-83776d80cb99.gif)

![toh-5](https://user-images.githubusercontent.com/29174853/103983611-87f44480-5153-11eb-9d24-4acbe732e817.gif)

![smalldemo](https://user-images.githubusercontent.com/29174853/103983618-8d518f00-5153-11eb-8f51-19d5aa279006.gif)



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
	* hanoi.txt
	* toh-3.txt
	* toh-5.txt
	* toh-8.txt
	* toh-12.txt
	* buildings.txt
	* smalldemo.txt
	
### Input Arguments
Besides providing name of the text file,  we have two more arguments
1. speed of the animation (50 recommended)
2. view : 
visual : Animation would be played in Java GUI window 
java -jar Animation-Generator.jar -in big-bang-big-crunch.txt -speed 50 -view visual
		
text   : Animation could be viewed in text format on the terminal 
java -jar Animation-Generator.jar -in big-bang-big-crunch.txt -speed 50 -view text
	
		  

          
