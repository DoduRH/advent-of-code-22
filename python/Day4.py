file = "aoc22/src/main/java/resources/Day4Input.txt"

import re

with open(file) as f:
    lines = f.readlines()

# Part 1

total = 0
regex = re.compile("(\d{1,})-(\d{1,}),(\d{1,})-(\d{1,})")
for line in lines:
    matches = regex.search(line)
    
    s1, e1, s2, e2 = matches.groups()

    s1 = int(s1)
    e1 = int(e1)
    s2 = int(s2)
    e2 = int(e2)

    if s1 <= s2 and e1 >= e2:
        total += 1
    
    elif s1 >= s2 and e1 <= e2:
        total += 1

print(total)

# Part 2

total = 0
regex = re.compile("(\d{1,})-(\d{1,}),(\d{1,})-(\d{1,})")
for line in lines:
    matches = regex.search(line)
    
    s1, e1, s2, e2 = matches.groups()

    s1 = int(s1)
    e1 = int(e1)
    s2 = int(s2)
    e2 = int(e2)

    if s1 in range(s2, e2+1) or e1 in range(s2, e2+1) or s2 in range(s1, e1+1) or e2 in range(s1, e1+1):
        total += 1
    

print(total)