"""
@author: Fabian C. Annaheim
"""

import numpy as np

def jacobiProcedure(A, b, x0, tol):
        
    A = np.copy(A)
    b = np.copy(b)
    
    A = A.astype('float64')
    b = b.astype('float64')
    
    D = np.diag(np.diag(A))
    D_inv = np.linalg.inv(D)
    LpR = A - D
    D = 0

    B = - D_inv @ LpR
    LpR = 0 #Memory release
    c = D_inv @ b
    D_inv = 0 #Memory release

    # inf-Norm of B
    B_inf = np.linalg.norm(B, np.inf)
    
    #Test, if procedure converges
    if B_inf > 1:
        raise Exception('Fixed point is not attractive')
    
    #First iteration
    xn = B @ x0 + c
    n = 1
    
    #A-priori estimation
    n2 = np.log(tol * (1 - B_inf) / np.linalg.norm(xn - x0, np.inf)) / np.log(B_inf)
    
    #More iterations whereby a a-posteriori estimation is used
    while B_inf / (1 - B_inf) * np.linalg.norm(xn-x0, np.inf) >= tol:
        x0 = xn
        xn = B @ x0 + c
        n = n + 1
    
    return (xn, n, n2)

