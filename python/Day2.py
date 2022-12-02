file = "aoc22/src/main/java/resources/Day2Input.txt"

print(sum([sum([3 + int(p2) + 1 if p1 == p2 else 6 + int(p2) + 1 if (int(p2) - int(p1)) % 3 == 1 else int(p2) + 1 for p1, p2 in [line.strip().replace("A", "0").replace("B", "1").replace("C", "2").replace("X", "0").replace("Y", "1").replace("Z", "2").split(" ")]]) for line in open(file).readlines()]))

print(sum([sum([3 + (int(p1) + int(p2)) % 3 + 1 if int(p1) == (int(p1) + int(p2)) % 3 else 6 + (int(p1) + int(p2)) % 3 + 1 if ((int(p1) + int(p2)) % 3 - int(p1)) % 3 == 1 else (int(p1) + int(p2)) % 3 + 1 for p1, p2 in [line.strip().replace("A", "0").replace("B", "1").replace("C", "2").replace("X", "-1").replace("Y", "0").replace("Z", "1").split(" ")]]) for line in open(file).readlines()]))
