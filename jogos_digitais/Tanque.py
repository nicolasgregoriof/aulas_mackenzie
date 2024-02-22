""" 
1)      Crie cinco objetos do tipo Tanque e armazene-os em um array.
2)      Crie a simulação conforme as seguintes regras:
a. Deve ser sorteado um número entre 0 e o tamanho do array de tanques, de forma a se selecionar o tanque que realizará o primeiro ataque.
b. Sortear um novo número entre 0 e o tamanho do array de tanques (excluindo o tanque que já foi selecionado para atirar). Este novo tanque selecionado será o tanque que levará o tiro. Se o tanque explodir, ele deve ser retirado do array.
c. Execute os itens ‘a’ e ‘b’ até que reste apenas um tanque.
"""

import random

class Tank(object):
    def __init__(self,name):
        self.name = name
        self.alive =True
        self.ammo = 5
        self.armor = 60
    
    def __str__(self):
        if self.alive:
            return "%s (%i armor, %i shells)" % (self.name, self.armor, self.ammo)
        else:
            return "%s (DEADE)" % self.name
    
    def fire_at (self,enemy):
        if self.ammo >= 1:
            self.ammo -= 1
            print(self.name, "fires on", enemy.name)
            enemy.hit()
        else:
            print(self.name,"has no shells!")
    
    def hit (self):
        self.armor -= 20
        print (self.name, "is hit,\n")
        if self.armor <= 0:
            self.explode()
    
    def explode (self):
        self.alive = False
        print (self.name, "explodes!,\n")

    
    def war (self):
        while len(tanques_sobreviventes) > 1:
            print("##### INICIO DA RODADA #####","\n","\n")
            tanques_ataque_temp = list(tanques_sobreviventes)

            """a - Deve ser sorteado um número entre 0 e o tamanho do array de tanques, de forma a se selecionar o tanque que realizará o primeiro ataque."""
            tanque_ataque = random.choice(tanques_ataque_temp)
            tanques_ataque_temp.remove(tanque_ataque)

            print("Tanque sorteado, p/ ataque!:", tanque_ataque)

            """"Sortear um novo número entre 0 e o tamanho do array de tanques (excluindo o tanque que já foi selecionado para atirar). 
            Este novo tanque selecionado será o tanque que levará o tiro. 
            Se o tanque explodir, ele deve ser retirado do array."""
            tanques_disponiveis = tanques_ataque_temp
            tanque_vitima = random.choice(tanques_disponiveis) 
            print("Tanque sorteado, p/ ser atacado!:", tanque_vitima)
            
            tanque_ataque.fire_at(tanque_vitima)
            
            if not tanque_vitima.alive:
                tanques_sobreviventes.remove(tanque_vitima)

            print(meuTanque1,"\n")
            print(meuTanque2,"\n")
            print(meuTanque3,"\n")
            print(meuTanque4,"\n")
            print(meuTanque5,"\n","\n")
            print("PARCIAL DOS JOGADORES ATIVOS: " ,*tanques_sobreviventes,"\n","\n")
            print("##### FIM DA RODADA #####","\n","\n")

        if len(tanques_sobreviventes) == 1:
            print(f"FIM DE JOGO, TANQUE {tanques_sobreviventes[0].name} VENCEU!")
        else:
            print("Não há mais tanques na lista.")

"""1 - Crie cinco objetos do tipo Tanque"""
meuTanque1 = Tank("Bob")
meuTanque2 = Tank("Paola")
meuTanque3 = Tank("Nick")
meuTanque4 = Tank("Hebrom")
meuTanque5 = Tank("Elisa")
"""2 - Armazene-os em um array"""
tanques_base = [meuTanque1,meuTanque2,meuTanque3,meuTanque4,meuTanque5] 
tanques_sobreviventes = list(tanques_base)

guerra = Tank("Guerra")

guerra.war()
