# coding=utf-8

# python description
# 1、易于学习；
# 2、易于阅读；
# 3、易于维护；
# 4、一个广泛的标准库；
# 5、互动模式；
# 6、可移植；
# 7、可拓展；
# 8、数据库；
# 9、GUI编程；
# 10、可嵌入
from Lib import keyword

print('this is my python about description')
print('这是关于python说明的文章')

if __name__ == '__main__':
    # keyword.kwlist为python中的关键字
    keyList = keyword.kwlist

    for keyword in keyList:
        print('当前关键字为：', keyword)

    # 函数 len() 返回列表的长度，即元素的个数。 range返回一个序列的数
    for index in range(len(keyList)):
        print('序列为-', index, '的关键字为：', keyList[index])
