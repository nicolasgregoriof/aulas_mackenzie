import random

class Tank(object):
    def __init__(self, name):
        self.name = name
        self.alive = True
        self.ammo = 5
        self.armor = 60

    def __str__(self):
        if self.alive:
            return "%s (%i armor, %i shells)" % (self.name, self.armor, self.ammo)
        else:
            return "%s (DEAD)" % self.name

    def fire_at(self, enemy):
        if self.ammo >= 1:
            self.ammo -= 1
            print(self.name, "fires on", enemy.name)
            enemy.hit()
        else:
            print(self.name, "has no shells!")

    def hit(self):
        self.armor -= 20
        print(self.name, "is hit.")
        if self.armor <= 0:
            self.explode()

    def explode(self):
        self.alive = False
        print(self.name, "explodes!")

tanque1 = Tank("Tank1")
tanque2 = Tank("Tank2")
tanque3 = Tank("Tank3")
tanque4 = Tank("Tank4")
tanque5 = Tank("Tank5")

array = [tanque1,tanque2,tanque3,tanque4,tanque5]


while(len(array)!=1):
    num = random.randint(0,len(array)-1)
    num2 = random.randint(0,len(array)-1)
    while num2 == num:
        num2 = random.randint(0,len(array)-1)
    
    array[num].fire_at(array[num2])
    if(array[num2].alive != True):
        array.remove(array[num2])

print("\nO tanque", array[0].name,"venceu")