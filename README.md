# Gaussian Elimination Implementation
This program uses the Gaussian Elimination algorithm in the form of a graphical user interface (GUI), to allow the user to compute a series of matrix computations. Currently, the program works for solving a series of linear equations, computing the determinant of an n x n matrix, and finding the inverse of an n x n matrix. I used the pseudocode below as the source for my Gaussian Elimination algorithm [1].
<p align="center">
  <img src="/gauss_pseudocode.PNG">
</p>

  - The inverse function of the program was added on after my assignment was due, so it doesn't directly use the Guassian Elimination algorithm. It was just something I wanted to add on as a small personal project. 
  - If you have any questions about the program or find bugs, you can email me at 907riley@gmail.com.

### Solving a Series of Linear Equations
This is probably the most useful implementation of the Gaussian Elimination algorithm. The algorithm solves the system of linear equations by computing the U decomposition of the n x (n + 1) matrix and then uses backtracking to solve for each of the variables. I used the pseudocode algorithm from the class book (which took more time then I'd like to admit to get to work) and I came up with the backtracking algorithm from scratch.  

I was initiallly thinking about adding a feature to compute the LU decomposition, but I realized that this already computes the U decomposition and outputs it for the user. 

*If the program ever outputs the value `NaN` for the solution or a matrix number, that means that your system does not have a unique solution.*

[This](https://www.shmoop.com/equation-systems/gaussian-elimination-exercises.html) is a site with multiple examples of system of linear equations problems with answers to test the GUI with.

### Computing the Determinant
Computing a determinant of an n x n matrix is important because it can tell you many things about the matrix.
  - If the determiant is 0, then the matrix doesn't have an inverse
  - It can be used on a system of linear equations to tell you if the system has a unique solution
  - Along with many more uses in areas like Linear Algebra.  
 
For coding this algorithm, I took my Gaussian Elimination code and altered it slightly to keep track of the number of row swaps (this is important) and then compute the determinant by getting the product of the diagonal values. This site helped a lot with thinking through the process [2].

[This](http://www.mesacc.edu/~scotz47781/mat150/notes/cramers_rule/Determinnant_3_by_3_Matrix_Practice.pdf) is a site with multiple examples of determinant problems with answers to test the GUI with.

### Finding the Inverse
The inverse of a matrix A (represented as A^(-1)) has the property such that A * A^(-1) results in the identity matrix I. The identity matrix is matrix consisting of ones along the diagonal running from top left to bottom right and all the other matrix components are 0. As stated above, if the determinant of a matrix is 0, then there is no inverse.


Finding the inverse of a matrix allows you to solve matrix problems that would normally require division because you can't divide matrices. Multiplying a matrix by another matrix's inverse is the same as dividing by that other matrix.
 - XA = B is the same as X = BA^(-1)

# Running the Program
First make sure you have the entire repository cloned onto your computer. Next navigate into the src folder (there should be another directory and a makefile). From there you can use the program in a couple different ways outlined below.

### How to Use the GUI
The GUI is fairly straightforward but here is a quick expanation of how to use it.
  1. The settings menu is the first part of the program you will see (if using pre-coded tests, skip to step 3). Just use the drop down menus to pick the number of rows you need for your problem (this is the number of unknowns you have for a Gaussian Elimination) and the problem you want to solve (solving a system of linear equations is just referred to as Gaussian Elimination). Then click the "Confirm Settings" button.
  2. The GUI will then create a screen for you to begin solving your problem. Enter in the numbers into the text boxes (for Gaussian Elimination, don't worry about matching your variables to the ones on the GUI, you just need to make sure all the columns are the same variable). The last column when using the Gaussian Elimination mode is for the constants that the linear equations equal.
  3. Once all the numbers are loaded into the text boxes, click the button that either says "Perform Gaussian Elimination", "Calculate Determinant", or "Compute Inverse".
  4. The answer will appear at the bottom of the screen for both modes.
  5. You can reset the GUI by clicking the "Reset Matrix and Solutions" button.

### Run from the Start
To run the program from the very beginning, run the command `make run`. This will start the program from the Main.java file,  which just starts the program with the Settings object. From there it is up to you to decide how you want to use the program.

### Pre-Coded Tests
There are a series of pre-coded tests for all of the program's uses. Here are the commands, purposes, and expected results for all of them.  
  - `make TestAll`
     - This command will run a series of 12 tests. Each test will have a series of pre-loaded numbers in the matrix and all you have to do is click the button to perform the computation. When you want the next test to run, close the GUI tab and the next should pop up.
  - `make GaussTestAll`
     - This command will only run the four Gaussian Elimination tests.
  - `make DeterminantTestAll`
     - This command will only run the four Determinant tests.
  - `make InverseTestAll`
     - This command will only run the four Inverse tests.
  - `make GaussTest1`
     - This command will only run the first Gaussian Elimination test. This test solves a system of three linear equations. It requires the algorithm to do swapping, which is something I wanted to make sure it could do.
  - `make GaussTest2`
     - This command will only run the second Gaussian Elimination test. This test solves a system of three linear equations. 
  - `make GaussTest3`
     - This command will only run the third Gaussian Elimination test. This test solves a system of four linear equations. I wanted to make sure the program worked for a system of greater than three unknowns.
  - `make GaussTest4`
     - This command will only run the fourth Gaussian Elimination test. This test solves a system of two linear equations.
  - `make DeterminantTest1`
     - This command will only run the first Determinant test. This test is computing the determinant of a 3 x 3 matrix.
  - `make DeterminantTest2`
     - This command will only run the second Determinant test. This test is computing the determinant of a 3 x 3 matrix.
  - `make DeterminantTest3`
     - This command will only run the third Determinant test. This test is computing the determinant of a 4 x 4 matrix.
   - `make DeterminantTest4`
     - This command will only run the fourth Determinant test. This test is computing the determinant of a 2 x 2 matrix.
  - `make InverseTest1`
     - This command will only run the first Inverse test. This test is computing the inverse of a 2 x 2 matrix.
  - `make InverseTest2`
     - This command will only run the second Inverse test. This test is computing the inverse of a 3 x 3 matrix.
  - `make InverseTest3`
     - This command will only run the third Inverse test. This test is computing the inverse of a 3 x 3 matrix.
   - `make InverseTest4`
     - This command will only run the fourth Inverse test. This test is computing the inverse of a 4 x 4 matrix.
### Test Results
If you want to confirm the test results, here are the answers for all the tests. For each of the TestAll commands, the programs execute in ascending order starting with the GaussTests, so it should be easy to know what test you're on (it follows the order in the table).

| Test | Expected Result |
|----|---------------|
| GaussTest1 | (-1, -1, -1) |
| GaussTest2 | (2, 4, 6) |
| GaussTest3 | (1, 2, 3, 4) |
| GaussTest4 | (2, 1) |
| DeterminantTest1 | 49 |
| DeterminantTest2 | -108 |
| DeterminantTest3 | -42 |
| DeterminantTest4 | -2 |

| InverseTest1 | |
|-|-|
| -0.2 |  0.3 |
|  0.4 | -0.1 |

| InverseTest2 | | |
|-|-|-|
| 0.192 | -0.041 | -0.068 |
| -0.397 | 0.014 | 0.356 |
| 0.260 | 0.301 | -0.164 |

| InverseTest3 | | |
|-|-|-|
| -1.522 | 0.891 | 1.109 |
| 0.087 | -0.065 | 0.065 |
| 0.826 | -0.370 | -0.630 |

| InverseTest4 | | | |
|-|-|-|-|
| -3.811 | -2.946 |  1.541 |  0.243 |
| -5.595 | -4.027 |  1.730 |  0.378 |
|  1.027 |  0.865 | -0.351 | -0.108 |
|  1.243 |  0.784 | -0.162 |  0.027 |
# Resources
- [1] Levitin, Anany. Introduction to the Design and Analysis of Algorithms. Pearson. 
- [2] 4.3 Evaluating the Determinant by Gaussian Elimination and by Row or Column Expansion, ocw.mit.edu/ans7870/18/18.013a/textbook/HTML/chapter04/section03.html#:~:text=Evaluating%20a%20Determinant%20by%20Gaussian,product%20of%20the%20diagonal%20entries. 
