package progjava.misc;

//package progjava.misc;

// Import Enum as static member of class (1/2)
// import static progjava.misc.ClasseQueIncluiEnum.Dias;

// Import Enum as static member of class (2/2)
// import static progjava.misc.ClasseQueIncluiEnum.*;

// Import Enum as normal member of class (1/2)
import progjava.misc.ClasseQueIncluiEnum.Dias;

// Import Enum as normal member of class (2/2)
// import progjava.misc.ClasseQueIncluiEnum.*;

// Impor below is not useful at all (make sure you get it)
import progjava.misc.ClasseQueIncluiEnum;

public class UsaEnum {
    public static void main(String[] args) {
	for (ClasseQueIncluiEnum.Dias d : Dias.values())
	    System.out.printf("%s ", d);
    }
}
