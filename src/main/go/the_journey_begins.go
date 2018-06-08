package main

import (
	"fmt"
	"sort"
)

// func main() {
// }

func add(param1 int, param2 int) int {
    return param1 + param2;
}

func centuryFromYear(year int) int {
    if year % 100 == 0 {
		return year / 100
	} else {
		return year / 100 + 1
	}
}

func checkPalindrome(inputString string) bool {
    for i , j := 0, len(inputString) - 1; i < j; i, j = i + 1, j - 1 {
		if (inputString[i] != inputString[j]) {
			return false
		}
	}
	return true
}
