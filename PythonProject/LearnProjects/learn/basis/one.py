# -*- coding: utf-8 -*-
"""
-------------------------------------------------
   File Name：     one，第一个python程序
   Description :
   Author :       admin
   date：          2021/1/7
-------------------------------------------------
   Change Activity:
                   2021/1/7:
-------------------------------------------------
"""
__author__ = 'admin'


# 标识符不能以数字开头

class one():
    def __init__(self):
        print('this is init method')

    def _foo(self):
        addName = 'this is addName'
        # _foo，__foo
        print('_foo，__foo，', addName)


if __name__ == '__main__':
    one()._foo()
    print('-------------')
    print(one()._foo(), '---->')
