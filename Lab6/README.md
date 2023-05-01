# Sorting-arxml-files-based-on-short-name

## Description:
- Write a program that reads an ARXML file containing a list of containers, each with a unique ID.
- Reorder the containers alphabetically by their "SHORT-NAME".
- The program should write the reordered containers to a new ARXML file.
## Read carefully:
- The name of the arxml file shall be an argument which needs to passed through the command 
line.
- If the file is not having .arxml, a user defined
exception “NotVaildAutosarFileException” is thrown.
- If the file is empty, a user defined exception 
“EmptyAutosarFileException” is thrown.
- The output file is named as the same of the input file concatenated with “_mod.arxml”
  e.g. if the input was named “Rte_Ecuc.arxml” then the output should be “Rte_Ecuc_mod.arxml”.

## Files:
- [**Main.java**](Main.java) : The java code file containing the main class, user-defined exceptions classes and Container class.
- [**normal.arxml**](normal.arxml) : arxml file unsorted to test the functionality of the code.
- [**normal_mod.arxml**](normal_mod.arxml) : arxml file after sorting .
- [**empty.arxml**](empty.arxml) :  empty arxml file to test the functionality of the code.
- [**test.bat**](test.bat) : batch file to test all the cases "files".
