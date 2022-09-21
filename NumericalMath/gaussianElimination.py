"""
@author: Fabian C. Annaheim
@description: The Gaussian elimination method or simply Gaussian method is 
an algorithm from the mathematical subfields of linear algebra and numerics. 
It is an important method for solving systems of linear equations and is based 
on the fact that equivalence transformations change the system of equations 
but preserve the solution. This allows any uniquely solvable system of equations 
to be put into step form, from which the solution can be easily determined by 
successive elimination of the unknowns, or the solution set can be read off.
"""

import numpy as np

def gauss_elimination(A,b):

    A = np.copy(A)
    b = np.copy(b)
    A = A.astype('float64')
    b = b.astype('float64')
    n = np.shape(A)[0]
    
    #Gauss elimination without pivotisation
    for i in np.arange(0,n):
        j = i
        while j < n and A[j,i] == 0:
            j = j+1
        if j != i:
            swap(A,b,i,j)
        for j in np.arange(i+1,n):
            c = A[j,i] / A[i,i]
            subtract(A,b,j,i,c)
    
    return A, b


def swap(A,b,i,j):
        dummy = np.copy(A[i,:])
        A[i,:] = A[j,:]
        A[j,:] = dummy
        dummy = np.copy(b[i])
        b[i] = b[j]
        b[j] = dummy
        return A,b

    
def subtract(A,b,j,i,c):
    A[j,:] = A[j,:] - c * A[i,:]
    b[j] = b[j] - c * b[i]
    return A, b