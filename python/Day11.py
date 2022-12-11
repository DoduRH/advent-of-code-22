from tqdm import trange
# file = "aoc22/src/main/java/resources/Day11Test.txt"
file = "aoc22/src/main/java/resources/Day11Input.txt"

with open(file) as f:
    lineString = f.read()


def replaceCalc(a, b, itemWorry):
    if a == "old":
        a = itemWorry
    if b == "old":
        b = itemWorry
    
    return [a, b]


class Monkey():
    def __init__(self, items, calc, test, toTrue, toFalse) -> None:
        self.items = items
        c = calc.split(" ")
        if c[0] != "old":
            c[0] = int(c[0])
        if c[2] != "old":
            c[2] = int(c[2])
        self.calc = c
        self.test = test
        self.toTrue = toTrue
        self.toFalse = toFalse
        self.inspections = 0

    def getWorry(self, itemWorry):
        self.inspections += 1
        match self.calc:
            case [a, "*", b]:
                a, b = replaceCalc(a, b, itemWorry)
                return a * b
            case [a, "+", b]:
                a, b = replaceCalc(a, b, itemWorry)
                return a + b

    def __str__(self) -> str:
        return "\n".join([
            ",".join([str(x) for x in self.items]), 
            " ".join([str(x) for x in self.calc]), 
            str(self.test), 
            str(self.toTrue), 
            str(self.toFalse), ""
        ])
    
monkeys: list[Monkey] = []

# Parse input
for monkey in lineString.split("\n\n"):
    items = list()
    calc = ""
    test = -1
    toTrue = -1
    toFalse = -1
    for line in monkey.split("\n"):

        match line.strip().split(": "):
            case ["Starting items", i]:
                for j in i.split(", "):
                    items.append(int(j))
            
            case ["Operation", i]:
                calc = i.split(" = ")[-1]
            
            case ["Test", i]:
                test = int(i.split(" ")[-1])
            
            case ["If true", i]:
                toTrue = int(i.split(" ")[-1])

            case ["If false", i]:
                toFalse = int(i.split(" ")[-1])

    monkeys.append(Monkey(items, calc, test, toTrue, toFalse))

# Part 1
for round in trange(20):
    for monkey in monkeys:
        for item in monkey.items:
            newWorry = monkey.getWorry(item) // 3

            if newWorry % monkey.test == 0:
                monkeys[monkey.toTrue].items.append(newWorry)
            else:
                monkeys[monkey.toFalse].items.append(newWorry)
            
        monkey.items = list()

topMonkeys = sorted(monkeys, key=lambda x: x.inspections)[-2:]


print(f"Part 1 {topMonkeys[0].inspections * topMonkeys[1].inspections}")

# Reset
monkeys: list[Monkey] = []
for monkey in lineString.split("\n\n"):
    items = list()
    calc = ""
    test = -1
    toTrue = -1
    toFalse = -1
    for line in monkey.split("\n"):

        match line.strip().split(": "):
            case ["Starting items", i]:
                for j in i.split(", "):
                    items.append(int(j))
            
            case ["Operation", i]:
                calc = i.split(" = ")[-1]
            
            case ["Test", i]:
                test = int(i.split(" ")[-1])
            
            case ["If true", i]:
                toTrue = int(i.split(" ")[-1])

            case ["If false", i]:
                toFalse = int(i.split(" ")[-1])

    monkeys.append(Monkey(items, calc, test, toTrue, toFalse))

# Part 2
modulo = 1
for m in monkeys:
    modulo *= m.test

for round in trange(1, 10_001):
    for monkey in monkeys:
        while monkey.items:
            item = monkey.items.pop(0)
            newWorry = monkey.getWorry(item) % modulo
        
            if newWorry % monkey.test == 0:
                monkeys[monkey.toTrue].items.append(newWorry)
            else:
                monkeys[monkey.toFalse].items.append(newWorry)
            
topMonkeys = sorted(monkeys, key=lambda x: x.inspections)[-2:]

print(f"Part 2 {topMonkeys[0].inspections * topMonkeys[1].inspections}")