N = int(input())
# N = 5

class Clock():
    def __init__(self):
        self.h = 0
        self.m = 0
        self.s = 0
    def tick(self):
        if(self.s != 59):
            self.s += 1
        else:
            self.s = 0
            if(self.m != 59):
                self.m += 1
            else:
                self.m = 0
                self.h += 1

clock = Clock()
count = 0

while(clock.h != N or clock.m != 59 or clock.s != 59):
    now = str(clock.h) + str(clock.m) + str(clock.s)
    if("3" in now):
        count += 1
    clock.tick()

print(count)

