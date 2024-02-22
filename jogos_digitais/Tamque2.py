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


class Game:
    def __init__(self):
        self.tanks = {}

    def create_tanks(self):
        num_tanks = int(input("Quantos tanques você quer criar (entre dois e dez)? "))
        if num_tanks < 2 or num_tanks > 10:
            print("Número inválido de tanques.")
            return
        for i in range(num_tanks):
            name = input(f"Digite o nome do tanque {i + 1}: ")
            tank = Tank(name)
            self.tanks[chr(97 + i)] = tank

    def simulate(self):
        while len(self.tanks) > 1:
            attacking_tank_key = random.choice(list(self.tanks.keys()))
            attacking_tank = self.tanks[attacking_tank_key]

            remaining_tank_keys = [key for key in self.tanks.keys() if key != attacking_tank_key]
            target_tank_key = random.choice(remaining_tank_keys)
            target_tank = self.tanks[target_tank_key]

            attacking_tank.fire_at(target_tank)
            if not target_tank.alive:
                del self.tanks[target_tank_key]

            for tank_key, tank in self.tanks.items():
                print(tank)

            print("PARCIAL DOS JOGADORES ATIVOS: ", *[tank.name for tank in self.tanks.values()], "\n")

        if len(self.tanks) == 1:
            winner_tank = list(self.tanks.values())[0]
            print(f"FIM DE JOGO, TANQUE {winner_tank.name} VENCEU!")
        else:
            print("Não há mais tanques na lista.")


if __name__ == "__main__":
    game = Game()
    game.create_tanks()
    game.simulate()