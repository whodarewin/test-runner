# 线上接口排查工具 #  
## 功能
1. 支持实时调用线上任何接口。
2. 支持动态修改线上源码，增加日志或者监控信息。
## 使用方式
### 实时调用线上接口
传递json格式数据给线上web接口，返回调用结果，格式为
```
{
  "constructParam": {
    "className": "com.hc.test.runner.TestObject",
    "source": "REFLECT",
    "param": null
  },
  "methodParam": {
    "methodName": "search",
    "params": [
      {
        "className": "com.hc.test.runner.ConstructParam",
        "source": "BASIC",
        "param": [
          {
            "value": "A",
            "constructParam": false
          }
        ]
      }
    ]
  }
}
```
1. constructParam: 构造参数，表示需要构建的对象如何创建。  
    1. className: 构造的类的名称
    2. source: 使用何种方式构造，反射还是spring中获取。
    3. param: 构造方法的参数
2. methodParam:调用对象的方法的参数
    1. methodName: 调用方法的名称
    2. params: 调用方法的参数 
        1. className：参数的class名称
        2. source: 使用何种方法构造，反射还是spring中获取。
        3. param: 构造方法使用的参数
            1. value: 参数值
            2. constructParam: 是否是另一个constructParam，false，不是，直接返回值，true,是，迭代构造参数。
### 动态修改线上源码接口
TODO：Btrace