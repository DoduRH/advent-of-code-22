file = "aoc22/src/main/java/resources/Day1Input.txt"

print(max([sum([int(l.strip()) for l in elf.split("\n")]) for elf in "".join(open(file).readlines()).split("\n\n")]))

print(sum(sorted([sum([int(l.strip()) for l in elf.split("\n")]) for elf in "".join(open(file).readlines()).split("\n\n")])[-3:]))