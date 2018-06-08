package main

import (
	"fmt"
	"sort"
)

func adjacentElementsProduct(inputArray []int) int {
	var v int = inputArray[0] * inputArray[1]
	for i := 0; i < len(inputArray)-1; i++ {
		v = int(math.Max(float64(v), float64(inputArray[i] * inputArray[i + 1])))
	}
	return v
}

func shapeArea(n int) int {
    k := n * 2 - 1
    return k * k - n * (n - 1) * 2
}

func makeArrayConsecutive2(statues []int) int {
    var res int = 0
    sort.Ints(statues)
    for i := 0; i < len(statues) - 1; i++ {
        res += statues[i + 1] - statues[i] - 1
    }
    return res
}

func almostIncreasingSequence(sequence []int) bool {
		if len(sequence) == 2 {
		return true
	}
	err := 0

	for i := 0; i < len(sequence) - 1; i++ {
		if sequence[i] >= sequence[i + 1] {
			err++
			//if throw first
			possible := false
			if i > 0 && sequence[i - 1] < sequence[i + 1]  || i == 0 {
				possible = true
			}
			//if throw second
			if i + 1 == len(sequence) - 1 || i < len(sequence) - 2 && sequence[i] < sequence[i + 2] {
				possible = true
			}
			if (!possible) {
				err++
			}

		}

	}
	return err <= 1
}

func matrixElementsSum(matrix [][]int) int {
	res := 0
	for i, _ := range matrix {
		for j, _ := range matrix[i] {
			if i > 0 && matrix[i - 1][j] == 0 {
				matrix[i][j] = 0
			}
			res += matrix[i][j]
		}
	}
	return res
}

