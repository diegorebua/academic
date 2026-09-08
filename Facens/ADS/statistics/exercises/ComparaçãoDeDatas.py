d1 = int(input("Digite o dia da primeira data: "))
m1 = int(input("Digite o mês da primeira data: "))
a1 = int(input("Digite o ano da primeira data: "))

d2 = int(input("Digite o dia da segunda data: "))
m2 = int(input("Digite o mês da segunda data: "))
a2 = int(input("Digite o ano da segunda data: "))

if (a1, m1, d1) < (a2, m2, d2):
    print("A primeira data é anterior à segunda.")
elif (a1, m1, d1) > (a2, m2, d2):
    print("A primeira data é posterior à segunda.")
else:
    print("As duas datas são iguais.")
