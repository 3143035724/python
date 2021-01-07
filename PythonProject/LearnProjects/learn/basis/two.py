# -*- coding: utf-8 -*-
"""
-------------------------------------------------
   File Name：     two
   Description :
   Author :       admin
   date：          2021/1/7
-------------------------------------------------
   Change Activity:
                   2021/1/7:
-------------------------------------------------
"""
__author__ = 'admin'

print('特别注意：python以顺序执行方法')


class two():
    def __init__(self):
        print('two method，打印顺序为6')

    # 声明变量不需要进行赋值
    counter = 500
    miles = 1000.7
    name = 'syx'
    print(counter, '打印顺序为2')
    print(miles, '打印顺序为3')
    print(name, '打印顺序为4')


if __name__ == '__main__':
    print('main init ', '打印顺序为5')
    two()
