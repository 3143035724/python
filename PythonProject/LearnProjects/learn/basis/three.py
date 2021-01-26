# -*- coding: utf-8 -*-
"""
-------------------------------------------------
   File Name：     three
   Description :
   Author :       admin
   date：          2021/1/7
-------------------------------------------------
   Change Activity:
                   2021/1/7:
-------------------------------------------------
"""
__author__ = 'admin'


# python内部不区分单双引号，但必须成对出现
class three():
    print('--数字、字符串、列表、元祖、字典--')
    print('----数字----')
    # 数字类型为不可变的数据类型，当改变数据类型时会分配一个新的对象
    var1 = 1
    var2 = 10
    del var1, var2
    # 此时，变量var1和var2均不存在，尝试对其进行操作时就会报错，提示未定义，无法进行操作
    # print(var2)
    # 复数：由实数部分和虚数部分组成
    var1 = complex(1, 2)
    # 打印结果为：(1+2j)
    print(var1)

    print('----字符串----')
    s = 's123456789sn'
    # python存在两种取值顺序
    # 从左到右索引默认从0开始，最大范围是字符串长度少1，也就是length-1
    # 从右到左索引默认-1开始，最大范围是字符串开头
    # [头下标:尾下标] 获取的子字符串包含头下标的字符，但不包含尾下标的字符
    print(s[0])
    print(s[0:2])  # 结果为s1
    print(s[0:2] * 2)  # 结果为s1s1，*代表重复实例
    print(s[0:2] + "ADDSTRING")  # 结果为s1ADDSTRING，+代表连接
    print(s[0:2] + 'ADDSTRING')  # 结果为s1ADDSTRING，+代表连接
    # Python 列表截取可以接收第三个参数，参数作用是截取的步长
    print(s[0:5:2])  # 结果为s24

    print('----列表----')
    # 列表嵌套，是最频繁使用的数据类型,列表中数据不限一种类型，可以多种，有序
    list = []
    print(list)  # []
    # 列表的截取和字符串截取一样，也是使用[头下标:尾下标]进行截取
    list = ['String', 0, 1.52, 'end']
    print(list)
    print(list[0])  # String
    print(list[-1])  # end
    print(list[1:])  # [0, 1.52, 'end']
    print(list * 2)  # ['String', 0, 1.52, 'end', 'String', 0, 1.52, 'end']

    print('----元祖----')
    # 元祖不能二次赋值，只能进行读取操作
    tuple = ('1', 2, 'tuple', 3.1415)
    # tuple[2] = tuple[1] 对元祖内对象进行重新赋值是不允许的，元祖为不可变对象
    print(tuple)

    print('----字典----')
    # 除列表外最灵活的内置数据结构类型，字典是无序的对象集合
    dict = {'one': 1, 'tuple': 'this is two', 3: 3, 'name': 'runoob', 'code': 6734, 'dept': 'sales'}
    print(dict.keys())
    print(dict.values())
    print(dict)

    print('----类型转换----')
    # 转义符'\'；特别注意，空行不属于python语法的一部分，代码缩进属于python语法的一部分，但空行属于程序代码的一部分

    if dict.__len__() == 2:
        print('33333')
    elif dict.__len__() == 3:
        print('444444')
    else:
        print(dict.__len__())


if __name__ == '__main__':
    three()
    input('输入Enter键后退出')
