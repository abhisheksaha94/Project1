import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class Chemistry {

    public static void main(String args[]) {
        String[] elements = { "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
                "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr",
                "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs",
                "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W",
                "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np",
                "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg",
                "Cn", "Uut", "Uuq", "Uup", "Uuh", "Uus", "Uuo" };

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String inputWord = myScanner.next();
        String chemWord = spellWord(inputWord, elements);

        System.out.println(chemWord);

        myScanner.close();
    }

    /**
     * @param word the word that we want to re-spell using abbrevications of elements in the periodic table
     * @param elements an array that contains the abbreviations of elements in the periodic table
     *
     * @return word re-spelled using abbreviations of elements in the periodic table
     *
     * The spellWord function will take in two parameters, word and elements.
     * 1. Word represents the word that we want to re-spell using abbreviation of the elements from
     * the periodic table.
     * 2. Elements represents possible element abbreviations that you can use to re-spell the word
     *
     * The function needs to return a String representing the word that you have re-sprelled
     * using abbreviations of the elements in the periodic table.
     *
     */
    public static String spellWord(String word, String[] elements) {
        // write your code here to spell word with element abbreviations
        Set<String> set = new HashSet<>(Arrays.stream(elements).collect(Collectors.toSet()));
        String temp = "";
        String result = "";
        boolean status = true;
        int begin = 0;
        for (int i = 0; i < word.length(); i++){
            temp = temp == "" ? word.substring(begin,i+1).toUpperCase() : temp + word.substring(begin + 1 ,i+1);
            System.out.println("Temp = " + temp);
            if(set.contains(temp)){
                System.out.println("Inside If");
                begin = i + 1;
                result = result + temp;
                temp = "";
            }
        }
        if(result.length() != word.length()){
            System.out.println("cannot spell word");
            return "";
        }
        return result;
    }

    // feel free to write additional helper functions below
}
