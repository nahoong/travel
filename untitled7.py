# -*- coding: utf-8 -*-
"""
Created on Fri Aug 11 10:13:47 2017

@author: cse
"""
#array
import numpy as np

a=[1,2,3,4]
b=np.array(a)

a
b
a[0]
b[0]
a[:2]
b[:2]
a*0.3 #error
b*0.3

c = np.zeros((7,7))
d = np.ones([5,10])
e = np.array([[1,2,3],[4,5,6]])
e.shape    #row,col
e.ndim     #배열이 몇차원인지 보여줌
e.dtype

e*0.3
a = np.array([100, 500, 300, 250])
b = np.array([2, 1.2, 0.4, 0.5])
a*b

a = np.array([1,2,3,4])
a.dtype

b = a*1.0       #type 자동변환
b.dtype

c = a.astype(np.float32)    #형변환
c.dtype

arr_str = np.array(['1','2','3'])
arr_str.dtype
arr_int = arr_str.astype(np.int64)
arr_int.dtype

arr1 = np.array([[1,2],[3,4]])
arr2 = np.array([[5,6],[7,8]])
arr1 + arr2
np.add(arr1,arr2)

arr1*arr2
np.multiply(arr1,arr2)

##배열 슬라이싱
d = np.array( [[1,2,3],[4,5,6],[7,8,9]] )
d
d[:2,1:3]

slice를 이용해서 7,8을 추출
d[2,:2]
d[2:,:2]

#정수 배열 인덱싱
arr = np.array( [[1,2,3],[4,5,6],[7,8,9]] )

arr[0,2] #0행 2열 값에 접근
arr[[0,1,2],[2,0,1]]  #0,1,2 행의 2,0,1 열 값에 접근

e = np.array([[1,2,3],[4,5,6]])
e
d = e >= 2
d
f = np.array([ [4,6,3],[1,5,2] ])
g =f>3
g




