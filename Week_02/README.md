学习笔记


# GC总结

jvm的运行模式：Client、Server； Client相对启动快、Server运行相对快


-年轻代常见的垃圾收集器

    -Serial收集器(-XX:+UseSerialGC，复制算法)
        -单线程收集，进行垃圾收集时，必须暂停所有工作线程
        -简单高效，Client模式下默认的年轻收集器

    -ParNew收集器(-XX:+UseParNewGC，复制算法)
        -多线程收集，其余的行为、特点和Serial收集器一样
        -单核执行效率不如Serial，在多核下执行才有优势

    -Parallel Scavenge收集器(-XX:+UseParallelGC，复制算法)
        -比起前面关注用户线程停顿时间，更关注系统的吞吐量 (低停顿时间适合用户界面交互强的场景，高吞吐量适合后台大量计算的场景)
        -在多核下执行才有优势，Server模式下默认的年轻代收集器


-常见的老年代收集器
        
    -Serial Old收集器(-XX:+UseSerialOldGC，标记-整理算法)
        -单线程收集，进行垃圾收集时，必须暂停所有工作线程
        -简单高效，Client模式下默认的老年代收集器

    -Parallel Old收集器(-XX:+UseParallelOldGC，标记-整理算法)
        -多线程，吞吐量优先

    -CMS收集器(-XX:+UseConcMarkSweepGC，标记-清除算法，占老年代收集器的半壁江山)
        能做到回收线程几乎与用户线程同时工作(channel)
        工作流程主要分六步:
        ① 初始标记：stop-the-world
        ② 并发标记：并发追溯标记，程序不会停顿
        ③ 并发预处理：查找执行并发标记阶段从年轻代晋升到老年代的对象
        ④ 重新标记：暂停虚拟机，扫描CMS堆中的剩余对象
        ⑤ 并发清理：清理垃圾对象，程序不会停顿
        ⑥ 并发重置：重置CMS收集器的数据结构

    -G1收集器（-XX:+UseG1GC，复制+标记-整理算法）
        Garbage First收集器，即用于年轻代，又用于老年代，使命是用于替换JDK中的CMS收集器，其特点：
        -并发和并行
        -分代收集
        -空间整合
        -可预测的停顿

        它将整个Java堆内存划分为多个大小相等的Region，新生代和老年代不再物理隔离



# Week02 作业题目（周六）
2、homework2
