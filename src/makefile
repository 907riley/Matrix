JFLAGS = -g
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	matrix_project/Main.java \
        matrix_project/Settings.java \
        matrix_project/Matrix.java \
        matrix_project/Gauss.java \
        matrix_project/Determinant.java \
        matrix_project/Inverse.java \
        matrix_project/Coefficient.java \
        matrix_project/GaussTest1.java \
        matrix_project/GaussTest2.java \
        matrix_project/GaussTest3.java \
        matrix_project/GaussTest4.java \
        matrix_project/DeterminantTest1.java \
        matrix_project/DeterminantTest2.java \
        matrix_project/DeterminantTest3.java \
        matrix_project/DeterminantTest4.java \
        matrix_project/InverseTest1.java \
        matrix_project/InverseTest2.java \
        matrix_project/InverseTest3.java \
        matrix_project/InverseTest4.java 
        
        
        
MAIN = matrix_project/Main

GTEST1 = matrix_project/GaussTest1
GTEST2 = matrix_project/GaussTest2
GTEST3 = matrix_project/GaussTest3
GTEST4 = matrix_project/GaussTest4

DTEST1 = matrix_project/DeterminantTest1
DTEST2 = matrix_project/DeterminantTest2
DTEST3 = matrix_project/DeterminantTest3
DTEST4 = matrix_project/DeterminantTest4

ITEST1 = matrix_project/InverseTest1
ITEST2 = matrix_project/InverseTest2
ITEST3 = matrix_project/InverseTest3
ITEST4 = matrix_project/InverseTest4

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)
	
TestAll: classes
	$(JVM) $(GTEST1)
	$(JVM) $(GTEST2)
	$(JVM) $(GTEST3)
	$(JVM) $(GTEST4)
	$(JVM) $(DTEST1)
	$(JVM) $(DTEST2)
	$(JVM) $(DTEST3)
	$(JVM) $(DTEST4)
	$(JVM) $(ITEST1)
	$(JVM) $(ITEST2)
	$(JVM) $(ITEST3)
	$(JVM) $(ITEST4)
	
GaussTestAll: classes
	$(JVM) $(GTEST1)
	$(JVM) $(GTEST2)
	$(JVM) $(GTEST3)
	$(JVM) $(GTEST4)

GaussTest1: classes
	$(JVM) $(GTEST1)

GaussTest2: classes
	$(JVM) $(GTEST2)
	
GaussTest3: classes
	$(JVM) $(GTEST3)
	
GaussTest4: classes
	$(JVM) $(GTEST4)
	
DeterminantTestAll: classes
	$(JVM) $(DTEST1)
	$(JVM) $(DTEST2)
	$(JVM) $(DTEST3)
	$(JVM) $(DTEST4)
	
DeterminantTest1: classes
	$(JVM) $(DTEST1)

DeterminantTest2: classes
	$(JVM) $(DTEST2)
	
DeterminantTest3: classes
	$(JVM) $(DTEST3)
	
DeterminantTest4: classes
	$(JVM) $(DTEST4)
	
InverseTestAll: classes
	$(JVM) $(ITEST1)
	$(JVM) $(ITEST2)
	$(JVM) $(ITEST3)
	$(JVM) $(ITEST4)
	
InverseTest1: classes
	$(JVM) $(ITEST1)

InverseTest2: classes
	$(JVM) $(ITEST2)
	
InverseTest3: classes
	$(JVM) $(ITEST3)
	
InverseTest4: classes
	$(JVM) $(ITEST4)
	
clean:
	$(RM) *.class
