# -*- coding: utf-8 -*-
"""
-------------------------------------------------
   File Name：     test
   Description :
   Author :       admin
   date：          2021/1/8
-------------------------------------------------
   Change Activity:
                   2021/1/8:
-------------------------------------------------
"""
__author__ = 'admin'

# import three
import random

users = [
    '李小维', '钟代友', '刘东京', '王旭磊', '舒癸栗', '胡雨', '苏依星', '赵小琴', '黎生军', '何银', '余敏', '曾智', '王代伟', '张杰', '王兵', '曾旭明', '周焱'
]


def get_user():
    random.shuffle(users)
    r_index = random.randint(0, len(users) - 1)
    user_name = users[r_index]
    users.remove(user_name)
    return user_name


if __name__ == '__main__':
    # three.three()
    # input('输入Enter键后退出')
    print('总人数')
