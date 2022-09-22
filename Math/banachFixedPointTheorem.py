"""
@author: Fabian C. Annaheim
@topic: Numerical Mathematics
@description: The banach fixed point theorem guarantees the existence and uniqueness of fixed points of certain self-maps 
of metric spaces, and provides a constructive method to find those fixed points.The banach function in this script checks 
if a certain function is self-imaging and / or contractive and calculates the constant alpha which represents the largest 
possible slope of the handed over function on the interval [a,b]
"""

import numpy as np

def banach(F,dF,a,b):
    selfImaging = a < F(a) and F(b) < b
    alpha = -1e308
    for i in np.arange(a,b,0.001):
        if (alpha < dF(i)):
            alpha = dF(i)
    contractive = alpha < 1
    print("Self imaging: ", selfImaging)
    print("Contractive: ", contractive)
    print("α = ", alpha)
    return selfImaging, contractive, alpha

# def f(x): return x**2
# def dF(x): return 2*x
# banach(f, dF, 0, 5);
