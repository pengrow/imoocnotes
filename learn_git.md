# git学习



![image-20201020000229107](/Users/lipeng/Library/Application Support/typora-user-images/image-20201020000229107.png)



## 文件的4种状态

### Untracked

未跟踪，此文件在文件夹中，单并没有加入到git库，不参与版本控制，通过git add状态变为staged

![image-20201020001033145](/Users/lipeng/Library/Application Support/typora-user-images/image-20201020001033145.png)



![image-20201020001114444](/Users/lipeng/Library/Application Support/typora-user-images/image-20201020001114444.png)

### Unmodify

文件已经入库，未修改，即版本库中的文件快照内容与文件夹中完全一致。这种类型的文件有两种去处，如果它被修改，而变为**Modified**。如果使用git rm移除版本库，则成为Untracked文件



### Modified

文件已修改，仅仅是修改，并没有进行其他的操作。这个文件也有两个去处。通过git add可进入暂存staged状态，使用git checkout则丢弃修改过，返回到unmodify桩体，这个git checkout即从库中取出文件，覆盖当前修改。



### Staged

暂存状态。执行git commit则将修改同步到库中，这时库中的文件和本地文件又变为一致，文件为Unmodify状态。执行git reset HEAD filename取消暂存，文件状态为Modified



## 总结

只要本地文件有修改，被修改的文件就会进入Changes not staged for commit





