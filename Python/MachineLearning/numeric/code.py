from re import M
from turtle import color
import matplotlib.pyplot as plt
import numpy as np
from scipy import interpolate

# Newton's Divided

x = [20, 21, 24, 26, 27, 28]
y = [18, 17, 15, 14, 16, 15]
def getNDDCoeffs(x, y):
    n = np.shape(y)[0]
    pyramid = np.zeros([n, n])
    pyramid[::, 0] = y
    for j in range(1, n):
        for i in range(n-j):
            pyramid[i][j] = (pyramid[i+1][j-1] - pyramid[i]
                             [j-1]) / (x[i+j] - x[i])

    return pyramid[0]
coeff_vector = getNDDCoeffs(x, y)
final_pol = np.polynomial.Polynomial([0.])
n = coeff_vector.shape[0]
for i in range(n):
    p = np.polynomial.Polynomial([1.])
    for j in range(i):
        p_temp = np.polynomial.Polynomial([-x[j], 1.])
        p = np.polymul(p, p_temp)
    p *= coeff_vector[i]
    final_pol = np.polyadd(final_pol, p)

p = np.flip(final_pol[0].coef, axis=0)
xa = np.linspace(20, 28)
ya = np.polyval(p, xa)



plt.figure(figsize=(12,6))
plt.title('Newtons Divided')
plt.xlabel('Days')
plt.ylabel('Deaths')
plt.plot(xa, ya)
plt.grid(alpha=0.5)
plt.grid(linestyle="--")
plt.grid(color="r")
plt.show()
print()
print('# Newtons Divided')
print('D(23) = ', np.polyval(p, 23))

# Lagrange

x = np.array([20, 21, 24, 26, 27, 28])
y = np.array([18, 17, 15, 14, 16, 15])

xs = np.linspace(np.min(x), np.max(x), 100)

inter = interpolate.lagrange(x, y)
ys = inter(xs)


def Lagrange(x, y, xi):
    n = np.size(x)
    p = 0
    for i in range(n):
        z = y[i]
        for j in range(n):
            if i != j:
                z = z*(xi-x[j])/(x[i]-x[j])
        p = p+z
    return p


days = 23
deaths = Lagrange(x, y, days)
print()
print('# Lagranges')
print('D(23) = ', deaths)

fig = plt.figure()
plt.plot(xs, ys, '-', label='Lagrange')
plt.title('Lagrange')
plt.xlabel('Days')
plt.ylabel('Deaths')
plt.grid(alpha=0.5)
plt.grid(linestyle="--")
plt.grid(color="r")
plt.show()

# Direct Method

day = 23

k = np.ones((6, 6), dtype=int)
k[:, 1] = x

square = np.square(x)
k[:, 2] = square

three = [3, 3, 3, 3, 3, 3]
a = np.power(x, three)
k[:, 3] = a

four = [4, 4, 4, 4, 4, 4]
b = np.power(x, four)
k[:, 4] = b

five = [5, 5, 5, 5, 5, 5]
c = np.power(x, five)
k[:, 5] = c

x = np.linalg.solve(k, y)

result = (x[0])+(x[1] * (day))+(x[2]*(day)**2) + (x[3]*(day)**3) + (x[4]*(day)**4)+(x[5]*(day)**5)

print()
print('# Direct Method Interpolation')
print('D(23) = ', result)



