

```c++
struct point{
    
}



for (i=0;i<h/heigh;i++)
{
    for (j=0;j<t/width;j++)
    {
        point.trend+=
        for (i:poit.next.trend);
        
       	point.all+=for(i:point.next)
    }
}
//所有点的trend和weight


```

The major contributions of this paper are

* Study the line graph visual clutter problem
* Develop a hierarchical visual clustering algorithm specifically for line graphs

* A new design that deals with line graph visual clutter issue, and allows hierarchical exploration.



**2.3 SOM聚类算法**
SOM神经网络[11]是由芬兰神经网络专家Kohonen教授提出的，该算法假设在输入对象中存在一些拓扑结构或顺序，可以实现从输入空间(n维)到输出平面(2维)的降维映射，其映射具有拓扑特征保持性质,与实际的大脑处理有很强的理论联系。
SOM网络包含输入层和输出层。输入层对应一个高维的输入向量，输出层由一系列组织在2维网格上的有序节点构成，输入节点与输出节点通过权重向量连接。
学习过程中，找到与之距离最短的输出层单元，即获胜单元，对其更新。同时，将邻近区域的权值更新，使输出节点保持输入向量的拓扑特征。
算法流程：
(1) 网络初始化，对输出层每个节点权重赋初值；
(2) 将输入样本中随机选取输入向量，找到与输入向量距离最小的权重向量；
(3) 定义获胜单元，在获胜单元的邻近区域调整权重使其向输入向量靠拢；
(4) 提供新样本、进行训练；
(5) 收缩邻域半径、减小学习率、重复，直到小于允许值，输出聚类结果。
**2.4 FCM聚类算法**
1965年美国加州大学柏克莱分校的扎德教授第一次提出了‘集合’的概念。经过十多年的发展，模糊集合理论渐渐被应用到各个实际应用方面。为克服非此即彼的分类缺点，出现了以模糊集合论为数学基础的聚类分析。用模糊数学的方法进行聚类分析，就是模糊聚类分析[12]。
FCM算法是一种以隶属度来确定每个数据点属于某个聚类程度的算法。该聚类算法是传统硬聚类算法的一种改进。
![img](http://files.chinaaet.com/images/2010/10/18/4436166261885.gif)
​    算法流程：
(1) 标准化数据矩阵；
(2) 建立模糊相似矩阵，初始化隶属矩阵；
(3) 算法开始迭代，直到目标函数收敛到极小值；
(4) 根据迭代结果，由最后的隶属矩阵确定数据所属的类，显示最后的聚类结果。







* 根据层次确定聚类数量
* 自动生成聚类数量

****