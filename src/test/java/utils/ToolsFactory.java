package utils;

public class ToolsFactory {

    //method that checks if the words is having vowel or no
    public boolean containsvowel(String str) {
        str = str.toLowerCase();

        // Iterate over each character in the string
        for (char c : str.toCharArray()) {
            // Check if the character is a vowel
            if (isVowel(c)) {
                return false;
            }
        }

        // No vowels found
        return true;
    }

    //method that checks if each character is vowel or no
    public boolean isVowel(char c) {
        // Vowels are a, e, i, o, u
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
