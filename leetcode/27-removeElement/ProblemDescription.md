Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. 

>可以改变元素的顺序， 超过长度之后的元素是什么无所谓。（这里隐含的一层意思是，返回长度之前的元素必须不同于被删除元素， 如  [3,2,2,3], val = 3; 返回长度为2， 数组必须为[2,2,x,x] 

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.



