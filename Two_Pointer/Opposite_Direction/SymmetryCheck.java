package Opposite_Direction;
//Validating that user input reads the same both ways (DNA sequences, product codes), checking mirror/symmetric structures, text processing that ignores noise characters.
public class SymmetryCheck {
    public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        left++;
        right--;
    }
    return true;
    }
}
/*
Explanation: left and right start at the string's ends and move toward the center, comparing mirrored characters. Inner while loops skip non-alphanumeric characters before comparing. If any mirrored pair mismatches, it's not a palindrome. This is the natural fit because palindrome-ness is defined by symmetry around the center.
LC Questions:
/*
Problem125Valid Palindrome
680Valid Palindrome II
9Palindrome Number
234Palindrome Linked List
2108Find First Palindromic String in the Array */