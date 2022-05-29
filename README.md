This repository will serve as a formal study of some fundamental computer science algorithms. 
    * The list of algorithms can be found in the file Algorithm.txt
    * Each directory corresponds to the language in which the set of algorithms is implemented
    * The list can be found here: https://medium.com/techie-delight/top-25-algorithms-every-programmer-should-know-373246b4881b

To help initialize each directory, I've written a short shell script which will load all the 
algorithms into a directory with a specified extension, generateFiles.sh
    * Usage: ./generateFiles directoryToBeMade fileExtension
    * Examples: ./generateFiles Java java
                ./generateFiles C# cs
