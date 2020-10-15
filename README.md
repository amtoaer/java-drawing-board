<h1 align="center">画板</h1>
<p align="center">
<img src="img/logo.png" width="150">
</p>
<p align="center">
<img src="https://img.shields.io/badge/Java-15-orange?style=for-the-badge">
<img src="https://img.shields.io/github/languages/code-size/amtoaer/java-drawing-board?style=for-the-badge&color=red">
<img src="https://img.shields.io/github/v/release/amtoaer/java-drawing-board?style=for-the-badge">
<img src="https://img.shields.io/github/license/amtoaer/java-drawing-board?style=for-the-badge&color=blueviolet">
<img src="https://img.shields.io/github/workflow/status/amtoaer/java-drawing-board/release?style=for-the-badge">
</p>


## 项目介绍
该仓库为Java语言程序设计大作业，队伍成员有[amtoaer](https://github.com/amtoaer)、[RayK](https://github.com/Ray-Keiyaku)和[clover3333](https://github.com/clover3333)。
## 运行使用
下载[release界面](https://github.com/amtoaer/java-drawing-board/releases)的最新版本`DrawBoard.jar`，使用以下命令运行：
```bash
java -jar DrawBoard.jar
```
## 版本发布
该仓库已经进行了`CI`的配置，对于开发人员，可以通过**为某次`commit`添加`tag`并`push`到仓库**来触发自动构建，以基础版本的构建为例：
```bash
git tag -a '0.1.0' -m '基础版本'
git push --tags
```
## 项目结构
```bash
.
└── src
    ├── Colorlist.java #颜色选择区域
    ├── Drawboard.java #绘图区域
    ├── Eraser.java #橡皮擦类
    ├── EventListener.java #事件监听器以及绘图核心逻辑
    ├── Linewidth.java #线条粗细组件
    ├── MultiShape.java #直线、矩形和圆的实现
    ├── Shape.java #图形基类
    ├── Toolbar.java #工具栏界面
    └── Window.java #程序入口
```
## 开发进度
详见[待办事项](https://github.com/amtoaer/java-drawing-board/projects/1)。
## 当前功能
- [x] 绘制直线、矩形、圆
- [x] 修改线条颜色
- [x] 实现铅笔、橡皮擦
- [x] 按住拖动时的实时绘制
- [x] 线条粗细调整
- [x] 撤销某次绘图