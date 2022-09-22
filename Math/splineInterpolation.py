"""
@author: Fabian C. Annaheim
@description: Spline interpolation attempts to interpolate given interpolation 
points, also called knots, with the help of piecewise polynomials of low degree. 
While the result of a polynomial interpolation often oscillates to the point of 
unrecognizability due to unfavorably defined interpolation points, the spline 
interpolation provides useful curve shapes and approximation properties. The 
spline interpolation can be calculated with low, linear effort, but provides a 
lower order of convergence compared to the polynomial interpolation.
"""

import numpy as np
#import matplotlib.pyplot as plt

def splineInterpolation(x,y,xx):
    x = np.array(x)
    y = np.array(y)
    xx = np.array(xx)
    n = np.size(x) - 1
    # Step 1
    a = y[0:n]
    # Step 2
    h = x[1:n+1] - x[0:n]
    # Step 3
    c = np.zeros(n+1)
    # Step 4
    A = np.zeros((n-1, n-1))
    for i in range(n-1):
        A[i,i] = 2*(h[i] + h[i+1])
    for i in range(0,n-2):
        A[i,i+1] = h[i]
        A[i+1,i] = h[i]
    z = 3*((y[2:n+1]-y[1:n])/h[1:n] - (y[1:n]-y[0:n-1])/h[0:n-1])
    c[1:n] = np.linalg.solve(A,z)
    #Step 5
    b = (y[1:n+1]-y[0:n])/h - h/3*(c[1:n+1]+2*c[0:n])
    #Step 6
    d = (c[1:n+1]-c[0:n]) / (3*h)
    #Evaluate
    m = np.size(xx)
    yy = np.zeros(m)
    for j in range(0,m):
        i = 0
        while xx[j] > x[i+1]:
            i = i+1
        t = xx[j] - x[i]
        yy[j] = a[i] + t*(b[i] + t*(c[i] + t*d[i]))
    #Return
    return yy


#x = np.array([4,6,8,10])
#y = np.array([6,3,9,0])
#xx = np.arange(4,10,0.1)
#yy = splineInterpolation(x,y,xx)
#plt.plot(x,y,'o')
#plt.plot(xx,yy,'x')
#plt.legend(['Stützpunkte', 'Interpolationspunkte'])
#print(yy)