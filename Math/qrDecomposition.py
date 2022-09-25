"""
@author: Fabian C. Annaheim
@topic: Numerical Mathematics
@description: The QR decomposition or QR factorization is a term from the mathematical subfields 
of linear algebra and numerics. It describes the decomposition of a matrix A into the product 
A = Q x R of two other matrices, where Q is an orthogonal or unitary matrix and R is an upper 
triangular matrix. The QR decomposition is very often used in numerical mathematics, for example 
in the QR algorithm for calculating the eigenvalues of a matrix. But it is also helpful in solving 
systems of linear equations.
"""

import numpy as np

def qrDecomposition(A):
        
    A = np.copy(A)
    A = A.astype('float64')
    
    n = np.shape(A)[0]
    
    if n != np.shape(A)[1]:
        raise Exception('Matrix is not square')

    Q = np.eye(n)
    R = A
    
    for j in np.arange(0, n-1):
        a = np.copy(R[j:,j]).reshape(n-j, 1)
        e = np.eye(n-j)[:,0].reshape(n-j, 1)
        length_a = np.linalg.norm(a)
        if a[0] >= 0 : sig = 1
        else: sig = -1
        v = a + sig * length_a * e
        u = v * 1 / np.linalg.norm(v)
        H = np.eye(n-j) - 2 * u @ u.T
        Qi = np.eye(n)
        Qi[j:,j:] = H[:,:]
        R = Qi @ R
        Q = Q @ Qi.T
    
    return (Q, R)

def solve(Q, R, b):
    Qb = Q.T.dot(b)
    return np.linalg.solve(R, Qb)


"""
A = np.array([[1.,2.,-1.],
              [4.,-2.,6.],
              [3.,1.,0.]])
b = np.array([[9,-4,9]]).T
qrElems = np.round(qrDecomposition(A), 6)
print(np.round(solve(qrElems[0], qrElems[1], b),2))
"""



