def isPower(n):
    if n == 1:
        return True
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            v = i
            while v <= n:
                if v * i == n:
                    return True
                v *= i
    return False

