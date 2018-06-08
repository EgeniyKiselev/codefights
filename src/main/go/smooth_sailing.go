package main

import (
	"fmt"
	"sort"
)

func allLongestStrings(inputArray []string) []string {
    maxLen := 0
    for _, s := range inputArray {
        if len(s) > maxLen {
            maxLen = len(s)
        }
    }
    res := make([]string, 0)
    for _, s := range inputArray {
        if len(s) == maxLen {
            res = append(res, s)
        }
    }

    return res
}

func commonCharacterCount(s1 string, s2 string) int {
	res := 0
	s1arr := make([]byte, 256)
	for _, ch := range s1 {
		s1arr[ch]++
	}
	s2arr := make([]byte, 256)
	for _, ch := range s2 {
		s2arr[ch]++
	}

	for i := 0; i < 256; i++ {
		if s1arr[i] < s2arr[i] {
			res += int(s1arr[i])
		} else {
			res += int(s2arr[i])
		}
	}
	return res
}

func isLucky(n int) bool {
	t := n
	arr := []int {}
	for ; t != 0; {
		z :=  t % 10
		arr = append(arr, z)
		t /= 10
	}
	s1 := 0
	s2 := 0
	for i:= 0; i < len(arr) / 2; i++ {
		s1 += arr[i]
		s2 += arr[len(arr) - 1 - i]
	}

	return s1 == s2
}

// complexity: memory O(n), Time (nlogn)
func sortByHeight(a []int) []int {
	result := make([]int, len(a))
	copy(result, a)
	sort.Ints(a)
	last := 0
	for i, x := range result {
		if x == -1 {
			continue
		}
		for j := last; j < len(a); j++ {
			if a[j] != -1 {
				last = j
				break
			}
		}
		result[i] = a[last]
		last++
	}
	return result
}