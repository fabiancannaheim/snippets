"""
@author: Fabian C. Annaheim
@topic: Numerical Mathematics
@description: The newton method is a root-finding algorithm which produces successively better approximations
to the roots (or zeroes) of a real-valued function. Besides the source function its derivative is needed as well.
A starting value (x) has to be defined. This value should be guessed according to previous analysis because it should
not be to faar away from the solution. Otherwise convergence of the procedure is not guaranteed.
- newtonMethod(x, f, df, i) iterates a predefined number of times
- newtonMethodWithTolerance(x, f, df, i, tol) iterates until a certain distance to the real solution (tol) is reached
- simpleNewtonMethod(x, f, df, i) simplifies the process by always using df(x0) instead of df(x) which reduces computing 
  effort for the cost of being less exact
"""

def newtonMethod(x, f, df, i):
    while (i != 0):
        x = x - f(x) / df(x)
        i = i - 1
    return x

def newtonMethodWithTolerance(x, f, df, i, tol):
    crit = f(x-tol)*f(x+tol)
    while (i != 0 or crit > 0):
        x = x - f(x) / df(x)
        crit = f(x-tol)*f(x+tol)
        i = i - 1
    return x

def simpleNewtonMethod(x, f, df, i):
    x0 = x
    while (i != 0):
        x = x - f(x) / df(x0)
        i = i - 1
    return x

"""
def f(x): return 3*x**2 - 5
def df(x): return 6*x
x = 2; i = 5
print(newtonMethod(x, f, df, 4))
print(newtonMethodWithTolerance(x, f, df, 4, 1e-5))
print(simpleNewtonMethod(x, f, df, 4))
"""