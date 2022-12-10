# file = "aoc22/src/main/java/resources/Day10Test.txt"
file = "aoc22/src/main/java/resources/Day10Input.txt"

with open(file) as f:
    lines = f.readlines()

xReg = 1
cycle = 0
values = {}
total = 0

def calcToCycle(target):
    xReg = 1
    cycle = 0
    for line in lines:
        action, *num = line.strip().split(" ")
        if action == "noop":
            cycle += 1
            if cycle == target:
                return xReg
        elif action == "addx":
            cycle += 1
            if cycle == target:
                return xReg
            cycle += 1
            if cycle == target:
                return xReg

            xReg += int(num[0])
    return None

for i in range(20, 221, 40):
    reg = calcToCycle(i)
    print(f"Register is {reg} on cycle {i}")
    total += reg * i

print(f"Total is {total}")


# Pt 2
xReg = 1
cycle = 0
values = {}
total = 0

xReg = 1
cycle = 0
i=0

while (reg := calcToCycle(i+1)) is not None:
    if abs(i%40 - reg) <= 1:
        print("#", end="")
    else:
        print(" ", end="")
    i += 1
    if i%40 == 0:
        print("|")

print(f"\nRun for {i} cycles")
    

