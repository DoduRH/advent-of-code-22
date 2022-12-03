file = "aoc22/src/main/java/resources/Day3Test.txt"

with open(file) as f:
    lines = f.readlines()

# Part 1
total = 0

for line in lines:
    # Split in half
    line = line.strip()
    assert len(line) %2 == 0
    midpoint = len(line) // 2
    side1 = line[:midpoint]
    side2 = line[midpoint:]

    commonChars = set(side1).intersection(side2)

    for char in commonChars:
        total += ord(char)
        if char == char.upper():
            total -= 65-27
        else:
            total -= 96

print("Part 1")
print(total)
print(157)

total = 0
# Part 2
for l1, l2, l3 in zip(lines[0::3], lines[1::3], lines[2::3]):
    # Split in half
    commonChars = set(l1).intersection(l2).intersection(l3)

    for char in commonChars:
        if char == "\n":
            continue
        total += ord(char)
        if char == char.upper():
            total -= 65-27
        else:
            total -= 96

print("Part 2")
print(total)
print(70)
