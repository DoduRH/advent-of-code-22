file = "aoc22/src/main/java/resources/Day7Input.txt"
# file = "aoc22/src/main/java/resources/Day7Test.txt"

from enum import Enum
from pprint import pprint

with open(file) as f:
    lines = f.readlines()

# Part 1
folderStructure = {}

class State(Enum):
    NONE = 0
    LS = 1

state = State.NONE

def getFolder(loc):
    if loc == "/":
        return folderStructure
    returnFolder = folderStructure
    for folderName in loc[1:-1].split("/"):
        returnFolder = returnFolder[folderName]
    
    return returnFolder


cwd = "/"

for line in lines:
    line = line.strip()
    if line.startswith("$"):
        _, cmd, *args = line.split(" ")
        if cmd == "ls":
            state = State.LS

        elif cmd == "cd":
            # cd command
            toDir = args[0]
            # print(cwd, toDir)
            if toDir == "/":
                cwd = "/"
            elif toDir == "..":
                cwd = "/".join(cwd.split("/")[:-2]) + "/"
            else:
                cwd += toDir + "/"
            # print(cwd)
    elif state == State.LS:
        # Middle of listing stuff
        size, name = line.split()
        if size == "dir":
            print(f"Creating folder {name} at location {cwd}")
            getFolder(cwd)[name] = {}
        else:
            getFolder(cwd)[name] = int(size)

print(pprint(folderStructure, indent=4))

# Find the sum of all folders <=100000

pt1Total = 0
def getSize(folder):
    global pt1Total
    folderSize = 0
    
    for key, val in folder.items():
        if type(val) == dict:
            folderSize += getSize(val)
        else:
            folderSize += val
    
    if folderSize <= 100_000:
        pt1Total += folderSize
    
    return folderSize

totalSize = getSize(folderStructure)

print(f"{pt1Total = :,}")

print(f"{totalSize = :,}")

required = 30_000_000 - (70_000_000-totalSize)

print(f"{required = :,}")

allFolders = []
largeFiles = []

def getSize2(folder):
    folderSize = 0
    
    for key, val in folder.items():
        if type(val) == dict:
            folderSize += getSize2(val)
        else:
            folderSize += val
    
    if folderSize >= required:
        allFolders.append(folderSize)
    
    return folderSize

getSize2(folderStructure)

print(min(allFolders))