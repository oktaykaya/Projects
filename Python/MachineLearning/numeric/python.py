import numpy as np

x = np.array([10, 15, 20, 22.5])
y = np.array([227.04, 362.78, 517.35, 602.97])


def getNDDCoeffs(x, y):
    n = np.shape(y)[0]
    pyramid = np.zeros([n, n])
    pyramid[::, 0] = y
    for j in range(1, n):
        for i in range(1, n):
            pyramid[i][j] = (pyramid[i+1][j-1] - pyramid[i]
                             [j-1]) / (x[i+j] - x[i])
    return pyramid[0]


coeff_vector = getNDDCoeffs(x, y)
print("Resulting divided diffirences are:(b0,b1,b2,b3... etc.)")
print(coeff_vector)
print()

final_pol = np.polynomial.Polynomial([0.])
n = coeff_vector.shape[0]
for i in range(n):
    p = np.polynomial.Polynomial([1.])
    for j in range(i):
        p_temp = np.polynomial.Polynomial([-x[j], 1.])
        p = np.polymul(p, p_temp)
    p *= coeff_vector[i]
    final_pol = np.polyadd(final_pol, p)

p = np.flip(final_pol[0].coef, axis = 0)
print("Resulting polynomial coefficients are: (a,b,c,d,e) of ax^4+bx^3+cx^2+dx+e")
print(p)

import matplotlib.pyplot as plt
x_axis = np.linspace(0, 35, num=5000)
y_axis = np.polyval(p, x_axis)

print()
print("Plot of resulting polynomial:")
plt.plot(x_axis, y_axis)
plt.show()

print()
print("v(16) = ", np.polyval(p,16))
