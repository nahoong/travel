# -*- coding: utf-8 -*-
"""
Created on Fri Aug 11 09:29:41 2017

@author: cse
"""
#groupby
price = [2000,3000,5000,1000,1000,2000,4000]
name = ['apple','cherry',
        'apple','cherry',
        'cherry','apple','cherry'
        ]
city=['Seoul','Daejeon',
      'Seoul','Daejeon',
      'Seoul','Daejeon','Daejeon']
f_dic = {
        'name':name,
        'price':price,
        'city':city
        }
from pandas import DataFrame
import pandas

f_df = DataFrame(f_dic,columns=['city','name','price'])    #column순서
f_df

f_group = f_df['price'].groupby( [ f_df['city'],f_df['name'] ] )

f_group.count()
f_group.sum()
f_group.mean()
f_group.max()
f_group.min()