def additionWithoutCarrying(param1, param2):
    r = 0
    mul = 1
    param1 = int(param1)
    param2 = int(param2)
    while param1 != 0 or param2 != 0:
        p1 = int(param1 % 10)
        p2 = int(param2 % 10)
        r += ((p1 + p2) % 10) * mul
        mul *= 10
        param1 /= 10
        param2 /= 10

    return r

def appleBoxes(k):
    r = 0
    for i in range(1, k + 1):
        if i % 2 == 0:
            r += i * i
        else:
            r -= i * i
    return r

def rounders(value):
    res = 0
    add = 0
    i = 0
    value = int(value)
    while value != 0:
        if value // 10 == 0:
            res = int(value + add) * (10 ** i)
            break

        r = value % 10 + add
        if r == 0:
            i += 1
            value //= 10
            continue
        if r >= 5:
            add = 1
        else:
            add = 0
        value //= 10
        i += 1

    return res

