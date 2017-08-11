# -*- coding: utf-8 -*-
"""
Created on Fri Aug 11 13:40:25 2017

@author: cse
"""

https://archive.ics.uci.edu/ml/machine-learning-databases/wine-quality/

import pandas as pd
a = pd.read_csv(
        'https://archive.ics.uci.edu/ml/machine-learning-databases/wine-quality/winequality-red.csv',      
        delimiter=';'
        )
type(a)
a.shape

import numpy as np
b=np.array(a)
b.shape

print('a : '+str(a.shape))
print('b : '+str(b.shape))

numpy의 합
type(b)
b.sum()
b.mean()
b.mean(axis = 0)
b[:10].mean()
b.max(axis=0)

