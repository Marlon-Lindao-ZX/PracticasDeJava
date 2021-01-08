/**
 * Pig Latin represents the pig latin version of an English word.
 */
public class PigLatin {
    private String pigword;
    
    /** Construct the pig latin version of a word.
     * @param word a single word in English
     * @pre word contains only letters.
     */
    public PigLatin(String word) {
        pigword = convert(word);
    }

    private String convert(String word) {
        String vowels = "aeiouy";
        String output;
        word = word.toLowerCase();
        // if the first char of the word is a vowel
        if(vowels.indexOf(word.charAt(0)) == 0){
            // just add 'way' to the word
            output = word + "way ";
        }
        // else the first char of the word is a consonant
        else {
            Character letter = word.charAt(0);
            //output is the rest of the word + the first char + 'ay'
            output = word.substring(1,word.length()) + letter + "ay ";
        }
        return output;
    }

    public String toString() {
        return pigword;
    }
}
