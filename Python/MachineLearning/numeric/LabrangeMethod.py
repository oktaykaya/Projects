x = [20,21,24,26,27,28]
y = [18,17,15,14,16,15]

m = len(x)
n = m-1

xp = 23
yp = 0

for i in range(n+1):
    p = 1
    for j in range(n+1):
        if j != i:
            p *= (xp - x[j])/(x[i] - x[j])
    yp += y[i]*p

print('For x =%.2f, y= %f' % (xp,yp))
    